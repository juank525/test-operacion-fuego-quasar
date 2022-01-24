package com.mercadolibre.fuegoquasar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercadolibre.fuegoquasar.model.ErrorResponse;

/**
 * 
 * @author juan.pena
 *
 */
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({ MessageException.class, LocationException.class, InformationShipException.class })
	@ResponseBody
	ResponseEntity<Object> handleBusinessException(Exception ex) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		return ResponseEntity.notFound().build();
	}
}
