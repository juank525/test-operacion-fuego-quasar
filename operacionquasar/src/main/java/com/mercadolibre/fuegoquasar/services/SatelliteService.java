package com.mercadolibre.fuegoquasar.services;

import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;

public interface SatelliteService {

	/**
	 * Metodo que permite obtener informacion del satellite
	 * 
	 * @param satellite
	 * @return
	 */
	ShipResponse getInformationSatellite(Satellite satellite);

}
