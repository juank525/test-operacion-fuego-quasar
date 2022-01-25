package com.mercadolibre.fuegoquasar.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mercadolibre.fuegoquasar.exception.BussinessException;
import com.mercadolibre.fuegoquasar.exception.InformationShipException;
import com.mercadolibre.fuegoquasar.exception.MessageException;
import com.mercadolibre.fuegoquasar.model.Position;
import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;
import com.mercadolibre.fuegoquasar.services.MessageService;
import com.mercadolibre.fuegoquasar.services.SatelliteService;
import com.mercadolibre.fuegoquasar.util.SatelliteInitialPosition;

@Service
public class SatelliteServiceImpl implements SatelliteService {

	private final MessageService messageService;

	private final SatelliteInitialPosition satelliteInitialPosition;

	public SatelliteServiceImpl(MessageService messageService, SatelliteInitialPosition satelliteInitialPosition) {
		super();

		this.messageService = messageService;
		this.satelliteInitialPosition = satelliteInitialPosition;
	}

	@Override
	public ShipResponse getInformationSatellite(Satellite satellite) {
		satellite.getMessage();
		List<String[]> msgList = new ArrayList<>();
		msgList.add(satellite.getMessage());

		try {
			double[] positionInitial = satelliteInitialPosition.getPositionSatellite(satellite);
			String mensaje = messageService.getMessage(msgList);
			return ShipResponse.builder()
					.position(Position.builder().x(positionInitial[0]).y(positionInitial[1]).build()).message(mensaje)
					.build();
		} catch (MessageException | InformationShipException e) {
			throw new BussinessException("No hay suficiente información");
		}

	}
}
