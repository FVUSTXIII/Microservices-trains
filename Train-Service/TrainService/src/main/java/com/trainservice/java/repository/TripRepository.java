package com.trainservice.java.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainservice.java.dto.TripDto;
import com.trainservice.java.entity.Trips;


@Repository
public interface TripRepository extends JpaRepository <Trips, Integer> {

	Page<Trips> findByTripDateAndRouteId(LocalDate date, Integer integer, Pageable paging);
	Trips findByTripId(Integer tripId);
}
