package com.univision.message.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univision.message.model.Message;
import com.univision.message.model.data.MessageService;

/**
 * @author Alejandro
 * 
 *         MessageController handles the getMessage API in order to return the
 *         Message Object to the client in JSON format.
 * 
 */
@RestController
public class MessageController {

	@Autowired // Accomplish DI
	private MessageService messageService;

	/**
	 * getMessage API receives the id from the URI, gets the message
	 * from the Service class and returns it to the client as JSON format
	 * 
	 * @param id
	 * */
	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getMessage(@PathVariable String id) {
		Message message = messageService.getMessage(id);
		JSONObject obj = new JSONObject();
		if (message != null) {
			obj.put("id", message.getId());
			obj.put("message", message.getMessage());
		} else {
			obj.put("message", "Not valid id!");
		}
		return obj.toString();
	}
}
