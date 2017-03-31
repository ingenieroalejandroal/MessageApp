package com.univision.message.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.univision.message.model.Message;
import com.univision.message.model.data.MessageService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 
import static org.mockito.Mockito.*; 

/**
 * @author Alejandro
 * 
 * Test class to verify if the MessageController and MessageService
 * are working correctly
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {
	
	private MockMvc mockMvc;
	
	// Inject an instance into the controller
	@InjectMocks
	private MessageController controller;
	
	// Inject automatically
	@Mock
	private MessageService messageService; 
	
	// Initialized the controller
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); 
	}
	
	@Test
	public void testGetMessage() throws Exception{
		final String ID = "0c80dacb-597c-4692-8396-00af6bb65ed7"; 
		final String MESSAGE = "Hello World!";
		
		// Arrange Mock Service behavior
		Message message = new Message(ID, MESSAGE); 
		when(messageService.getMessage(ID)).thenReturn(message); 
		
		// Perform the MVC request and Assert the result
		MvcResult result = mockMvc.perform(get(String.format("/messages/%s", ID)))
					.andExpect(status().isOk()) // 200 status code
					.andReturn();  
		String content = result.getResponse().getContentAsString(); 
		// response should be equals to {"id":"0c80dacb-597c-4692-8396-00af6bb65ed7","message":"Hello World!"}
		assertTrue(content.equals(String.format("{\"id\":\"%s\",\"message\":\"%s\"}", ID, MESSAGE)));
	}
}
