package com.ticketservice.java.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USERSERVICE")
public interface UserClient {
	@GetMapping("/userservice/Verification/{userId}")
	String verify(@PathVariable("userId") Integer userId);
}
