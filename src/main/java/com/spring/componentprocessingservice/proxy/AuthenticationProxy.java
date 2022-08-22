package com.spring.componentprocessingservice.proxy;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authorization-service")
public interface AuthenticationProxy {
	
	@GetMapping("/validate")
	public boolean authorize(@RequestHeader("Authorization")String token)
			throws ServletException, IOException;

}
