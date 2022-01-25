package com.mercadolibre.fuegoquasar.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.fuegoquasar.model.ShipRequest;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.ShipServices;

@RestController
public class ShipController {

	private final ShipServices issuingServices;

	public ShipController(ShipServices issuingServices) {
		super();
		this.issuingServices = issuingServices;
	}

	@PostMapping(path = "/topsecret", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShipResponse> topSecret(@RequestBody ShipRequest satelliteRequest) {
		ShipResponse responseTopSecret = issuingServices.getInformationShip(satelliteRequest.getSatellites());
		return ResponseEntity.ok().body(responseTopSecret);
	}

	
}
