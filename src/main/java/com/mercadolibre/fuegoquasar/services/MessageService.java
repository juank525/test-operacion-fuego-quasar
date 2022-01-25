package com.mercadolibre.fuegoquasar.services;

import java.util.List;

import com.mercadolibre.fuegoquasar.exception.MessageException;

/**
 * 
 * @author juan.pena
 *
 */
public interface MessageService {

	/**
	 * Metodo que permite obtener el mensaje enviado por el emisor del mensaje
	 * 
	 * @param messages
	 * @return
	 */

	String getMessage(List<String[]> msgList) throws MessageException;

}
