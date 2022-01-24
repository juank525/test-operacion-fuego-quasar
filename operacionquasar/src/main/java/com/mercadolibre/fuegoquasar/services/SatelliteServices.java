package com.mercadolibre.fuegoquasar.services;

import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;

public interface SatelliteServices {

	/**
	 * Metodo que permite obtener la informacion del satellite
	 * 
	 * @param satellites
	 * @return
	 */
	ShipResponse getInformationSatellite(Satellite satellites);
}
