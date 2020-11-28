package org.javaturk.wap.ch08.temperatureConverter.dao;

import java.util.Date;

import org.javaturk.wap.ch08.temperatureConverter.domain.TemperatureType;

public class TemperatureConverterQuery implements Comparable{
	private int id;
	private double degree;
	private TemperatureType source;
	private TemperatureType target;
	private Date queryTime;

	public TemperatureConverterQuery() {
	}

	public TemperatureConverterQuery(TemperatureType source, TemperatureType target, double degree) {
		this.degree = degree;
		this.source = source;
		this.target = target;
		this.queryTime = new Date();
	}
	
	public int getId() {
		return id;
	}

	public double getDegree() {
		return degree;
	}

	public TemperatureType getSource() {
		return source;
	}

	public TemperatureType getTarget() {
		return target;
	}

	public Date getQueryTime() {
		return queryTime;
	}

	public static TemperatureConverterQuery createTemperatureConverterQuery(String sourceString, String targetString, String degreeString){
		TemperatureType source = convertToTemperatureType(sourceString);
		TemperatureType target = convertToTemperatureType(targetString);
		TemperatureConverterQuery query = new TemperatureConverterQuery(source, target, Double.parseDouble(degreeString));
		return query;
	}

	private static TemperatureType convertToTemperatureType(String sourceString) {
		TemperatureType type = null;
		switch (sourceString) {
		case "celsius":
			type = TemperatureType.CELSIUS;
			break;
		case "fahrenheit":
			type = TemperatureType.FAHRENHEIT;
			break;
		case "kelvin":
			type = TemperatureType.KELVIN;
			break;
		}
		return type;
	}

	@Override
	public String toString() {
		return "CFQuery [id=" + id + ", degree=" + degree + ", source=" + source + ", target=" + target + ", queryTime=" + queryTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemperatureConverterQuery other = (TemperatureConverterQuery) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		TemperatureConverterQuery otherQuery = (TemperatureConverterQuery) o;
		return this.queryTime.compareTo(otherQuery.queryTime);
	}
}
