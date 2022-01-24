package com.mercadolibre.fuegoquasar.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x;
	private double y;

	public Position() {
		super();
	}

	public Position(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@JsonIgnore
	public double[] getPositionAsArray() {
		double arrayPosition[] = { this.x, this.y };
		return arrayPosition;
	}

	public static class Builder {
		private double x;
		private double y;

		public Builder x(double x) {
			this.x = x;
			return this;
		}

		public Builder y(double y) {
			this.y = y;
			return this;
		}

		public Position build() {
			Position position = new Position();
			position.x = x;
			position.y = y;
			return position;
		}

	}

	public static Builder builder() {
		return new Builder();
	}
}
