package com.mercadolibre.fuegoquasar.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mercadolibre.fuegoquasar.exception.InformationShipException;
import com.mercadolibre.fuegoquasar.model.Position;
import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.LocationService;
import com.mercadolibre.fuegoquasar.services.MessageService;
import com.mercadolibre.fuegoquasar.services.ShipServices;
import com.mercadolibre.fuegoquasar.util.SatelliteInitialPosition;

@Service
public class ShipServicesImpl implements ShipServices {

	private final LocationService locationService;

	private final MessageService messageService;

	public ShipServicesImpl(LocationService locationService, MessageService messageService) {
		super();
		this.locationService = locationService;
		this.messageService = messageService;
	}

	@Override
	public ShipResponse getInformationShip(List<Satellite> satellites) {
		return ShipResponse.builder().position(getCoordinates(satellites)).message(getMessage(satellites)).build();
	}

	/**
	 * Metodo que permite obtener la posicion (x/y) de la nave
	 * 
	 * @param satellites
	 * @return
	 */
	private Position getCoordinates(List<Satellite> satellites) {

		double[] distances = satellites.stream().map(Satellite::getDistance).collect(Collectors.toList()).stream()
				.mapToDouble(Double::doubleValue).toArray();

		if (distances == null)
			throw new InformationShipException("No existe información de las distancias");

		double[] location = locationService
				.getLocation(SatelliteInitialPosition.getPositionInitialSatellite(satellites), distances);

		if (location == null)
			throw new InformationShipException("No se puede obtener la posición");

		return Position.builder().x(location[0]).y(location[1]).build();
	}

	/**
	 * 
	 * 
	 * /** Permite obtener el mensaje enviado
	 * 
	 * @param satellites
	 * @return
	 */
	private String getMessage(List<Satellite> satellites) {
		List<String[]> messages = satellites.stream().map(Satellite::getMessage).collect(Collectors.toList());
		return messageService.getMessage(messages);

	}

}
