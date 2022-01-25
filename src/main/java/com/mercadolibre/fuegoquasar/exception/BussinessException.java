package com.mercadolibre.fuegoquasar.exception;

public class BussinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BussinessException(String errorMessage) {
		super(errorMessage);
	}

}
