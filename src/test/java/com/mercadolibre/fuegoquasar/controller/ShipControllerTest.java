package com.mercadolibre.fuegoquasar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.fuegoquasar.model.ShipRequest;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.ShipServices;

@RestController
public class ShipControllerTest {

	@Mock
	private ShipServices issuingServices;

	@InjectMocks
	private ShipController shipController;

	private final ShipResponse shipResponse = new ShipResponse();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getInformationShipTest() {
		when(issuingServices.getInformationShip(any())).thenReturn(shipResponse);
		ResponseEntity<ShipResponse> responseActual = shipController.topSecret(new ShipRequest());
		assertEquals(shipResponse.getMessage(), responseActual.getBody().getMessage());
		assertEquals(200, responseActual.getStatusCodeValue());
	}

}
