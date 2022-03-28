package com.mocktrainservice.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mocktrainservice.java.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository <Route, Integer>{

	List<Route> findBySourceAndDestination(String source, String destination);

}
