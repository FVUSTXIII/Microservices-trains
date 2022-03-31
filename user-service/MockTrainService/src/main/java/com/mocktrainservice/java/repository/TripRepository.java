package com.mocktrainservice.java.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mocktrainservice.java.entity.Trips;

@Repository
public interface TripRepository extends JpaRepository <Trips, Integer> {


	Page<Trips> findByTripDateAndRouteId(LocalDate date, Integer integer, Pageable paging);

}
