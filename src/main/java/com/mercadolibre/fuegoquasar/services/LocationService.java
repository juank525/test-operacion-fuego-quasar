package com.mercadolibre.fuegoquasar.services;

/**
 * 
 * @author juan.pena
 *
 */
public interface LocationService {
	/**
	 * Metodo que permite obtener la ubicacion con el algoritmo de Trilateration
	 * 
	 * @param positions
	 * @param distances
	 * @return
	 */
	public double[] getLocation(double[][] positions, double[] distances);
}
