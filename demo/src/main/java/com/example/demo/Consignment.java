package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Consignment {

	
	  String carrierName;
	  String accountNumber;
	  int digits;
	  long lastUsedIndex ;
	  long rangeStart;
	  long rangeEnd;
}
