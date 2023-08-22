package com.siddhant.kedia.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {
	
	static {
		System.out.println("endpoints");
	}
	
	@GetMapping(value = "/hello")
	public String getPage() {
		return "bye";
	}
	
	@GetMapping(value = "/getData")
	public List<String> getData() {
		
		
		return null;
	}
	
	
	
}