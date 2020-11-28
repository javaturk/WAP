package org.javaturk.wap.ch08.temperatureConverter.domain;

public enum TemperatureType {
	
	CELSIUS("Celsius"), FAHRENHEIT("Fahrenheit"), KELVIN("Kelvin");
	
	private String name;
	
	private TemperatureType(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}