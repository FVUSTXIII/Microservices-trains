package com.ticketservice.java.Client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("TRAINSERVICE")
public interface TrainClient {
	
}
