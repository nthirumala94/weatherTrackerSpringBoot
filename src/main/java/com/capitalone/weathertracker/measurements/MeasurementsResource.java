package com.capitalone.weathertracker.measurements;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capitalone.weathertracker.WeatherTrackerService;
import com.capitalone.weathertracker.dao.WeatherRepository;

import java.net.URI;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

@RestController
@RequestMapping("/measurements")
public class MeasurementsResource {
  private final MeasurementStore store;
  private final DateTimeFormatter dateTimeFormatter;

  public MeasurementsResource(WeatherTrackerService store, DateTimeFormatter dateTimeFormatter) {
    this.store = new WeatherTrackerService();
    this.dateTimeFormatter = dateTimeFormatter;
  }

  // features/01-measurements/01-add-measurement.feature
  @PostMapping
  public ResponseEntity<?> createMeasurement(@Valid @RequestBody Measurement measurement) {
	  System.out.println("Inside Post");
	  store.add(measurement);

	  return null;
  }

  // features/01-measurements/02-get-measurement.feature
  @GetMapping("/{timestamp}")
  public ResponseEntity<Measurement> getMeasurement(@PathVariable ZonedDateTime timestamp) {
    Measurement measurement = store.fetch(timestamp);

    if (measurement != null) {
      return ResponseEntity.ok(measurement);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
