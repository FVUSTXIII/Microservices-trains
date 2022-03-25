package com.mocktrainservice.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mocktrainservice.java.entity.Route;

public interface RouteRepository extends JpaRepository <Route, Integer>{

	List<Route> findBySourceAndDestination(String source, String destination);

}
