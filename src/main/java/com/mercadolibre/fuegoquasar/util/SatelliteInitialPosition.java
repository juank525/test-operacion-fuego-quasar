package com.mercadolibre.fuegoquasar.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.mercadolibre.fuegoquasar.exception.InformationShipException;
import com.mercadolibre.fuegoquasar.model.Satellite;

@Component
@ConfigurationProperties(prefix = "satellite")
public class SatelliteInitialPosition {

	private Map<String, double[]> positionInitial;

	/**
	 * @return the positionInitial
	 */
	public Map<String, double[]> getPositionInitial() {
		return positionInitial;
	}

	/**
	 * @param positionInitial the positionInitial to set
	 */
	public void setPositionInitial(Map<String, double[]> positionInitial) {
		this.positionInitial = positionInitial;
	}

	/**
	 * Metodo que permite obtener las posiciones iniciales de los satelites
	 * 
	 * @param satellites
	 * @return
	 */
	public double[][] getPositionInitialSatellites(List<Satellite> satellites) {

		double[][] positionsInitials = new double[satellites.size()][2];

		int row = 0;
		for (Satellite satellite : satellites) {
			positionsInitials[row] = getPositionSatellite(satellite);
			row++;
		}

		return positionsInitials;

	}

	public double[] getPositionSatellite(Satellite satellite) {
		double[] position = positionInitial.get(satellite.getName());
		if (ObjectUtils.isEmpty(position)) {
			throw new InformationShipException("No tenemos información del satellite: " + satellite.getName());
		}

		return position;
	}

}
