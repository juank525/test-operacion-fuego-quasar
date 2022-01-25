package com.mercadolibre.fuegoquasar.model;

import java.io.Serializable;

public class Satellite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double distance;
	private String[] message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

	public static class Builder {
		private String name;
		private double distance;
		private String[] message;;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder distance(double distance) {
			this.distance = distance;
			return this;
		}

		public Builder message(String[] message) {
			this.message = message;
			return this;
		}

		public Satellite build() {
			Satellite satellite = new Satellite();
			satellite.name = name;
			satellite.distance = distance;
			satellite.message = message;
			return satellite;
		}

	}

	public static Builder builder() {
		return new Builder();
	}

}
