package com.capitalone.weathertracker;

import java.time.ZonedDateTime;
import java.util.List;

import com.capitalone.weathertracker.dao.WeatherRepository;
import com.capitalone.weathertracker.measurements.*;
import com.capitalone.weathertracker.statistics.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WeatherTrackerService implements MeasurementQueryService, MeasurementStore, MeasurementAggregator {
	private WeatherRepository weatherRepository = WeatherRepository.getInstance();

	@Override
	public void add(Measurement measurement) {
//		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
		this.weatherRepository.addWeatherData(measurement.getTimestamp(), measurement);
	}

	@Override
	public Measurement fetch(ZonedDateTime timestamp) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public List<Measurement> queryDateRange(ZonedDateTime from, ZonedDateTime to) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public List<AggregateResult> analyze(List<Measurement> measurements, List<String> metrics, List<Statistic> stats) {
		throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
	}
}