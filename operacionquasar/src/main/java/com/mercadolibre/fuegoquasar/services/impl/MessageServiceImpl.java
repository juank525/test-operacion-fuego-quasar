package com.mercadolibre.fuegoquasar.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mercadolibre.fuegoquasar.exception.MessageException;
import com.mercadolibre.fuegoquasar.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public String getMessage(List<String[]> messages) throws MessageException {
		List<String> words = getWordsMessages(messages);
		removeGap(messages, words.size());

		List<String> messageSender = getMessageSender(messages);
		words.removeAll(messageSender);
		if (!words.isEmpty()) {
			throw new MessageException("No se puede determinar el mensaje");
		}
		return String.join(" ", getMessageSender(messages));
	}

	/**
	 * Metodo que permite obtener las palabras del mensaje
	 * 
	 * @param messages
	 * @return
	 */
	private List<String> getWordsMessages(List<String[]> messages) {
		List<String> words = new ArrayList<String>();
		for (String[] message : messages) {
			words = Stream.concat(words.stream(), Arrays.asList(message).stream()).distinct()
					.collect(Collectors.toList()).stream().filter(m -> StringUtils.hasLength(m))
					.collect(Collectors.toList());
		}
		return words;
	}

	/**
	 * Metodo que permite eliminar el desfase del mensaje
	 * 
	 * @param messages
	 * @param wordSize
	 */
	private void removeGap(List<String[]> messages, int totalWord) {
		int lengthMessage = 0;
		for (int i = 0; i < messages.size(); i++) {
			lengthMessage = messages.get(i).length;
			if (lengthMessage > totalWord) {
				List<String> wordMessage = new ArrayList<>(Arrays.asList(messages.get(i)));
				wordMessage.remove((lengthMessage - totalWord));
				messages.set(i, wordMessage.toArray(String[]::new));
			}
		}
	}

	/**
	 * Metodo que permite obtener el mensaje del emisor del mensaje
	 * 
	 * @param messages
	 * @return
	 */
	private List<String> getMessageSender(List<String[]> messages) {
		List<String> messageSender = new ArrayList<String>();
		for (String[] message : messages) {
			List<String> messageAsList = Arrays.asList(message);
			if (messageSender.isEmpty()) {
				messageSender = Arrays.asList(message);
			} else {
				int i = 0;
				for (String word : messageAsList) {
					if ("".equals(messageSender.get(i))) {
						messageSender.set(i, word);
					}
					i++;
				}
			}
		}

		return messageSender;
	}
}
