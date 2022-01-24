package com.mercadolibre.fuegoquasar.model;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 3198299086569678273L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
