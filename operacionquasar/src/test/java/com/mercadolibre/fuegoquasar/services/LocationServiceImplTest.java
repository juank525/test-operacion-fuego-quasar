package com.mercadolibre.fuegoquasar.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.mercadolibre.fuegoquasar.services.impl.LocationServiceImpl;

public class LocationServiceImplTest {

	@InjectMocks
	LocationServiceImpl locationServiceImpl;

	@BeforeEach
	private void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLocationTest() {
		// Kenobi , Skywalker, Sato
		double positions[][] = { { -500, -200 }, { 100, -100 }, { 500, 100 } };
		double distances[] = { 100.0, 115.5, 142.7 };
		double[] ubicacionNave = locationServiceImpl.getLocation(positions, distances);
		System.out.println("x: "+ ubicacionNave[0] + " y: " + ubicacionNave[1]);
	}
}
