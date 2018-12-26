package com.ramosvji.dtos;

import java.io.Serializable;
import java.util.List;

public class CarErrorMessagesRestDtoOut implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<String> messages;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
}
