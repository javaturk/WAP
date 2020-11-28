package org.javaturk.wap.ch08.temperatureConverter.domain;

import org.javaturk.wap.ch08.temperatureConverter.dao.TemperatureConverterQuery;

public class TripleTemperatureConverter implements TemperatureConverter {

	@Override
	public synchronized Temperature convert(TemperatureConverterQuery query) throws IllegalArgumentException {
		TemperatureType source = query.getSource();
		TemperatureType target = query.getTarget();
		double degree = query.getDegree();
		
		validateDegree(source, degree);
		
		double result = 0.0;

		if (source == TemperatureType.CELSIUS) {
			if (target == TemperatureType.FAHRENHEIT)
				result = c2f(degree);
			else if (target == TemperatureType.KELVIN)
				result = c2k(degree);
			else if (target == TemperatureType.CELSIUS)
				result = degree;
		} else if (source == TemperatureType.FAHRENHEIT) {
			if (target == TemperatureType.CELSIUS)
				result = f2c(degree);
			else if (target == TemperatureType.KELVIN)
				result = f2k(degree);
			else if (target == TemperatureType.FAHRENHEIT)
				result = degree;
		} else if (source == TemperatureType.KELVIN) {
			if (target == TemperatureType.FAHRENHEIT)
				result = k2f(degree);
			else if (target == TemperatureType.CELSIUS)
				result = k2c(degree);
			else if (target == TemperatureType.KELVIN)
				result = degree;
		}
		
		Temperature temperature = new Temperature(result, target);
		
		return temperature;
	}

	private void validateDegree(TemperatureType source, double degree) throws IllegalArgumentException{
		if(source == TemperatureType.CELSIUS & degree < -273)
			throw new IllegalArgumentException("Celcius can't be lower than -273. Degree provided: " + degree);
		
		if(source == TemperatureType.KELVIN & degree < 0)
			throw new IllegalArgumentException("Kelvin can't be lower than 0. Degree provided: " + degree);
		
		if(source == TemperatureType.FAHRENHEIT & degree < -459.67)
			throw new IllegalArgumentException("Fahrenheit can't be lower than -459.67. Degree provided: " + degree);
	}

	private double c2f(double degree) {
		double result = (degree * 9 / 5) + 32;
		return result;
	}

	private double f2c(double degree) {
		double result = (degree - 32) * 5 / 9;
		return result;
	}

	private double c2k(double degree) {
		double result = degree + 273.15;
		return result;
	}

	private double k2c(double degree) {
		double result = degree - 273.15;
		return result;
	}

	private double k2f(double degree) {
		double result = (degree - 273.15) * 9 / 5 + 32;
		return result;
	}

	private double f2k(double degree) {
		double result = (degree - 32) * 5 / 9 + 273.15;
		return result;
	}
}
