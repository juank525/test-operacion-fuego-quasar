package com.mercadolibre.fuegoquasar.model;

import java.io.Serializable;
import java.util.List;

public class SatelliteRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Satellite> satellites;

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

}
