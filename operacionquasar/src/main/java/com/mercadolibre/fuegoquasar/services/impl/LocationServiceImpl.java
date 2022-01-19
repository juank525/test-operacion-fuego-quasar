package com.mercadolibre.fuegoquasar.services.impl;



import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.mercadolibre.fuegoquasar.services.LocationService;

public class LocationServiceImpl implements LocationService {
	
	@Override
	public double[] getLocation(double[][] positions, double[] distances) {

		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(trilaterationFunction,
				new LevenbergMarquardtOptimizer());

		return solver.solve().getPoint().toArray();
	}
}
