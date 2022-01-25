package com.mercadolibre.fuegoquasar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.mercadolibre.fuegoquasar.exception.MessageException;
import com.mercadolibre.fuegoquasar.services.impl.MessageServiceImpl;

public class MessageServiceImplTest {

	@InjectMocks
	private MessageServiceImpl messageServiceImpl;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getMessageTest() {
		List<String[]> messages = new ArrayList<>();
		String[] kenobi = { "este", "", "", "mensaje", "" };
		String[] Skywalker = { "", "es", "", "", "secreto" };
		String[] Sato = { "este", "", "un", "", "" };

		messages.add(kenobi);
		messages.add(Skywalker);
		messages.add(Sato);

		String message = messageServiceImpl.getMessage(messages);

		assertEquals("este es un mensaje secreto", message);
	}

	@Test
	public void getMessageGapTest() {
		List<String[]> messages = new ArrayList<>();
		String[] kenobi = { "", "este", "es", "un", "mensaje" };
		String[] Skywalker = { "este", "", "un", "mensaje" };
		String[] Sato = { "", "", "es", "", "mensaje" };

		messages.add(kenobi);
		messages.add(Skywalker);
		messages.add(Sato);

		String message = messageServiceImpl.getMessage(messages);

		assertEquals("este es un mensaje", message);
	}

	@Test
	public void getMessageGapTestError() {
		List<String[]> messages = new ArrayList<>();
		String[] kenobi = { "este", "", "", "mensaje", "" };
		String[] Skywalker = { "", "es", "", "", "secreto" };
		String[] Sato = { "este", "", "un", "", "", "" };

		messages.add(kenobi);
		messages.add(Skywalker);
		messages.add(Sato);

		assertThrows(MessageException.class, () -> {
			messageServiceImpl.getMessage(messages);
		});
	}

	@Test
	public void getMessageFourTest() {
		List<String[]> messages = new ArrayList<>();
		String[] satelliteOne = { "este", "", "", "mensaje", "" };
		String[] satelliteTwo = { "", "es", "", "", "secreto" };
		String[] satelliteThree = { "este", "", "un", "", "" };
		String[] satelliteFour = { "", "", "un", "", "secreto" };

		messages.add(satelliteOne);
		messages.add(satelliteTwo);
		messages.add(satelliteThree);
		messages.add(satelliteFour);

		String message = messageServiceImpl.getMessage(messages);

		assertEquals("este es un mensaje secreto", message);
	}
}
