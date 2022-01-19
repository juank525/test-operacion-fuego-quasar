package com.mercadolibre.fuegoquasar.services;

public interface LocationService {
	/**
	 * Metodo que permite obtener la ubicacion mediente el algoritmo de
	 * Trilateration
	 * 
	 * @param positions
	 * @param distances
	 * @return
	 */
	public double[] getLocation(double[][] positions, double[] distances);
}
