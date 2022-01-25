package com.mercadolibre.fuegoquasar.exception;

public class LocationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LocationException(String errorMessage) {
		super(errorMessage);
	}
}
