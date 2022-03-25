package com.mocktrainservice.java.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mocktrainservice.java.entity.Trips;

public interface TripRepository extends JpaRepository <Trips, Integer> {

	List<Trips> findByTripDate(LocalDate date);

	Trips findByTripDateAndRouteId(LocalDate date, Integer integer);

}
