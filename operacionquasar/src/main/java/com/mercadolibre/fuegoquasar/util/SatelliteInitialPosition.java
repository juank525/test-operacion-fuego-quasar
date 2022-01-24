package com.mercadolibre.fuegoquasar.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mercadolibre.fuegoquasar.exception.InformationShipException;
import com.mercadolibre.fuegoquasar.model.Position;
import com.mercadolibre.fuegoquasar.model.Satellite;

public class SatelliteInitialPosition {

	public static Map<String, Position> initialPositionSatellite() {
		Map<String, Position> positionInitialSatellite = new HashMap<String, Position>();

		positionInitialSatellite.put("kenobi", Position.builder().x(-500).y(-200).build());
		positionInitialSatellite.put("skywalker", Position.builder().x(-100).y(-100).build());
		positionInitialSatellite.put("sato", Position.builder().x(500).y(100).build());

		return positionInitialSatellite;

	}

	/**
	 * Metodo que permite obtener las posiciones iniciales de los satelites
	 * 
	 * @param satellites
	 * @return
	 */
	public static double[][] getPositionInitialSatellite(List<Satellite> satellites) {

		double[][] positionsInitials = new double[satellites.size()][2];

		int row = 0;
		for (Satellite satellite : satellites) {
			Position position = initialPositionSatellite().get(satellite.getName());
			if (position == null) {
				throw new InformationShipException("No tenemos información del satellite: " + satellite.getName());
			}
			positionsInitials[row] = position.getPositionAsArray();
			row++;
		}

		return positionsInitials;

	}

}
