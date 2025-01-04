package com.touristmanagement.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service")
public interface JwtFeignClient {
	@PostMapping("auth/token")
    String token(@RequestHeader("Authorization") String token);

}
