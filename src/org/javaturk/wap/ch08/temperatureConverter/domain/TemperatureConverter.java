package org.javaturk.wap.ch08.temperatureConverter.domain;

import org.javaturk.wap.ch08.temperatureConverter.dao.TemperatureConverterQuery;

public interface TemperatureConverter {
	
	public Temperature convert(TemperatureConverterQuery query) throws InvalidArgumentException;

}