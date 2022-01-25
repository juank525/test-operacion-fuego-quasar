package com.mercadolibre.fuegoquasar.exception;

/**
 * 
 * @author juan.pena
 *
 */
public class MessageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageException(String errorMessage) {
		super(errorMessage);
	}

}
