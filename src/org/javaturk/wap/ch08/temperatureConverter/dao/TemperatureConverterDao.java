package org.javaturk.wap.ch08.temperatureConverter.dao;

import java.util.List;

public interface TemperatureConverterDao {
	
	public void save(TemperatureConverterQuery query);
	
	public List<TemperatureConverterQuery> retrieveAllQueries();
	
	public int getQueryCount();

}
