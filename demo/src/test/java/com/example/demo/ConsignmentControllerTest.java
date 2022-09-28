package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@Tag("UnitTest")
@DisplayName("Consignment Controller Unit Tests")
class ConsignmentControllerTest {



	@Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
	    private ConsignmentService consignmentService;
	 

	    @Autowired
	    private ObjectMapper objectMapper;
	    
	@Test
	void testGenerateConsigmentNumber() throws Exception {
		 Consignment  consignment =Consignment.builder().carrierName("FreightmateCourierCo")
                 .accountNumber("123ABC").digits(10).lastUsedIndex(19604)
                 .rangeEnd(20000).rangeStart(19000). build();
		
		 String expectedResult="FMCC123ABC00000196051";
		
		 String json = objectMapper.writeValueAsString(consignment);
	        when(this.consignmentService.generate(consignment)).thenReturn(expectedResult);

	        //when-then
	        this.mockMvc.perform(post("/generate/")
	                .contentType(APPLICATION_JSON_UTF8)
	                .content(json))
	                .andExpect(status().isOk());
	}

}
