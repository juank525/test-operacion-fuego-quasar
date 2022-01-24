package com.mercadolibre.fuegoquasar.services;

import java.util.List;

import com.mercadolibre.fuegoquasar.model.Satellite;
import com.mercadolibre.fuegoquasar.model.ShipResponse;

public interface ShipServices {

	/**
	 * Metodo permite obtener informacion de la nave
	 * 
	 * @param satellites
	 * @return
	 */
	ShipResponse getInformationShip(List<Satellite> satellites);
}
