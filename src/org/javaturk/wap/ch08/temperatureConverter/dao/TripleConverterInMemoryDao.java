package org.javaturk.wap.ch08.temperatureConverter.dao;

import java.util.ArrayList;
import java.util.List;

public class TripleConverterInMemoryDao implements TemperatureConverterDao {
	private List<TemperatureConverterQuery> queries;

	public TripleConverterInMemoryDao() {
		queries = new ArrayList<>(100);
	}

	@Override
	public void save(TemperatureConverterQuery query) {
		queries.add(query);
	}

	@Override
	public List<TemperatureConverterQuery> retrieveAllQueries() {
		return queries;
	}

	@Override
	public int getQueryCount() {
		return queries.size();
	}
}
