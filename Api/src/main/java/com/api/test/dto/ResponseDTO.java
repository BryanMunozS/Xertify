package com.api.test.dto;

import java.io.Serializable;

/**
 * 
 * @author Bryan Muñoz
 *
 */
public class ResponseDTO implements Serializable  {

	private static final long serialVersionUID = 1L;
	private int responseCode;
	private String messageResponse;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

}
