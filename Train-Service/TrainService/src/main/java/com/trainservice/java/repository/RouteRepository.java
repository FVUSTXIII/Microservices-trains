<<<<<<< HEAD
package com.trainservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainservice.java.dto.RouteDto;
import com.trainservice.java.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {
	RouteDto findRouteByRouteId(Integer routeId);
}
=======
package com.trainservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainservice.java.entity.Route;


@Repository
public interface RouteRepository extends JpaRepository <Route, Integer>{

	Route findBySourceAndDestination(String source, String destination);

}
>>>>>>> origin/train-service
