package com.mercadolibre.fuegoquasar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mercadolibre.fuegoquasar.model.Position;
import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.impl.SatelliteServiceImpl;
import com.mercadolibre.fuegoquasar.util.SatelliteInitialPosition;

public class SatelliteServiceImplTest {
	@Mock
	private MessageService messageService;
	@Mock
	private SatelliteInitialPosition satelliteInitialPosition;

	@InjectMocks
	private SatelliteServiceImpl satelliteServiceImpl;

	private final String message = "este es un mensaje";
	private double[] positionArray = { 500, 500 };

	private final Position position = new Position(positionArray[0], positionArray[1]);
	private final ShipResponse expect = ShipResponse.builder().position(position).message(message).build();

	String[] messageArray = { "este", "es", "un", "mensaje" };
	private final Satellite satellite = Satellite.builder().message(messageArray).name("kenobi").build();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getInformationSatelliteTest() {
		when(messageService.getMessage(any())).thenReturn(message);

		when(satelliteInitialPosition.getPositionSatellite(any())).thenReturn(positionArray);

		ShipResponse shipResponse = satelliteServiceImpl.getInformationSatellite(satellite);

		assertEquals(expect.getMessage(), shipResponse.getMessage());
	}
}
