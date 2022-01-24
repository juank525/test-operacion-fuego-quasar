package com.mercadolibre.fuegoquasar.model;

import java.io.Serializable;

public class ShipResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Position position;
	private String message;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ShipResponse [position=" + position + ", message=" + message + "]";
	}

	public static class Builder {
		private Position position;
		private String message;

		public Builder position(Position position) {
			this.position = position;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public ShipResponse build() {
			ShipResponse responseTopSecret = new ShipResponse();
			responseTopSecret.position = position;
			responseTopSecret.message = message;
			return responseTopSecret;
		}
	}

	public static Builder builder() {
		return new Builder();
	}

}
