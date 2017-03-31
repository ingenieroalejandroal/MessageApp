package com.univision.message.model.data;

import org.springframework.stereotype.Component;

import com.univision.message.model.Message;

/**
 * @author Alejandro
 * 
 *         MessageService is emulating a Service layer that reds the Message
 *         Object from any data source. For the example the method getMessage is
 *         returning a simple hard coded Message Object.
 */
@Component
public class MessageService {

	final String MESSAGE = "Hello World!";

	public Message getMessage(String id) {
		if (id != null && !id.isEmpty()) {
			// get Message from DB ...
			return new Message(id, MESSAGE);
		}
		return null;
	}

}
