package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class ConsignmentController {

	
	@Autowired
	ConsignmentService service;
	
	@PostMapping("/generate")
	public String generateConsigmentNumber(@RequestBody  Consignment item)
	{
		 log.info("ConsignmentController: generateConsigmentNumber ()");
		String consignmentNum=service.generate(item);
		
		return consignmentNum;
		
	}
	
	
	
	
	
	
}
