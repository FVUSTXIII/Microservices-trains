package com.ticketservice.java.Client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("USERSERVICE")
public interface UserClient {
	
}
