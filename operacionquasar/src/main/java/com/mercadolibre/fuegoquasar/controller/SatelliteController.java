package com.mercadolibre.fuegoquasar.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.SatelliteService;

@RestController
public class SatelliteController {

	private final SatelliteService satelliteService;

	public SatelliteController(SatelliteService satelliteService) {
		this.satelliteService = satelliteService;
	}

	@PostMapping(path = "/topsecret/{satelliteName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShipResponse> topSecret(@PathVariable String satelliteName,
			@RequestBody Satellite satellite) {
		satellite.setName(satelliteName);
		ShipResponse responseTopSecret = satelliteService.getInformationSatellite(satellite);
		return ResponseEntity.ok().body(responseTopSecret);
	}

	@GetMapping(path = "/topsecret/{satelliteName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShipResponse> getTopSecret(@PathVariable String satelliteName,
			@RequestBody Satellite satellite) {
		satellite.setName(satelliteName);
		ShipResponse responseTopSecret = satelliteService.getInformationSatellite(satellite);
		return ResponseEntity.ok().body(responseTopSecret);
	}
}
