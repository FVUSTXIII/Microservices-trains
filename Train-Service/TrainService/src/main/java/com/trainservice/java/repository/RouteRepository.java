package com.trainservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainservice.java.entity.Route;


@Repository
public interface RouteRepository extends JpaRepository <Route, Integer>{

	Route findBySourceAndDestination(String source, String destination);

}
