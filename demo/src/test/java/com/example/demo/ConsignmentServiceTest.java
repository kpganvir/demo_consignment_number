package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.test.context.ActiveProfiles;




@Tag("UnitTest")
@DisplayName("Consignment Service Unit Tests")
class ConsignmentServiceTest {

	
	 private ConsignmentService consignmentService;
	 
	 @BeforeEach
	    public void init() {
	      
		 consignmentService = new ConsignmentService();
	    }

	 @Test
	void testgenerate() {

		 Consignment  consignment =Consignment.builder().carrierName("FreightmateCourierCo")
				                    .accountNumber("123ABC").digits(10).lastUsedIndex(19604)
				                    .rangeEnd(20000).rangeStart(19000). build();
		 
		 String expectedResult="FMCC123ABC00000196051";
		   
		
		  String actualResult = consignmentService.generate(consignment);
		  
		  assertNotNull(actualResult);
	      assertEquals(expectedResult, actualResult);

	}

}
