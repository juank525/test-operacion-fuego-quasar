package com.mercadolibre.fuegoquasar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mercadolibre.fuegoquasar.exception.InformationShipException;
import com.mercadolibre.fuegoquasar.model.Position;
import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.impl.ShipServicesImpl;
import com.mercadolibre.fuegoquasar.util.SatelliteInitialPosition;

public class ShipServicesImplTest {

	@Mock
	private LocationService locationService;

	@Mock
	private MessageService messageService;

	@Mock
	private SatelliteInitialPosition satelliteInitialPosition;

	@InjectMocks
	private ShipServicesImpl shipServicesImpl;

	private String[] messageKenobi = { "este", "", "", "mensaje", "" };
	private String[] messageSkywalker = { "", "es", "", "", "secreto" };
	private String[] messageSato = { "este", "", "un", "", "" };

	private final Position position = new Position(-59.84042612609117, -67.49680156707802);

	private final String message = "este es un mensaje";

	private final ShipResponse expect = ShipResponse.builder().position(position).message(message).build();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getInformationShipErrorTest() {
		List<Satellite> satellites = List.of();
		assertThrows(InformationShipException.class, () -> {
			shipServicesImpl.getInformationShip(satellites);
		});
	}

	@Test
	void getInformationTest() {
		List<Satellite> satellites = new ArrayList<Satellite>();
		satellites.add(Satellite.builder().name("kenobi").message(messageKenobi).distance(100).build());
		satellites.add(Satellite.builder().name("skywalker").message(messageSkywalker).distance(115.5).build());
		satellites.add(Satellite.builder().name("sato").message(messageSato).distance(142.7).build());

		double point[] = position.getPositionAsArray();
		when(locationService.getLocation(any(), any())).thenReturn(point);

		when(messageService.getMessage(any())).thenReturn(message);

		double[][] positions = { { -500, -200 }, { -100, -100 }, { 500, 100 } };
		when(satelliteInitialPosition.getPositionInitialSatellites(any())).thenReturn(positions);

		ShipResponse shipResponse = shipServicesImpl.getInformationShip(satellites);

		assertEquals(expect.getMessage(), shipResponse.getMessage());
	}
}
