package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsignmentService {

	public String generate(Consignment item) {
	 log.info("ConsignmentService: generate () ");
	  
	   String  index=calculateIndex(item.getLastUsedIndex(),item.getRangeStart(),item.getRangeEnd(),item.getDigits());
	   String indexWithcheckSum=concateCheckSum(index,item.getDigits()/2);
	   
	   
	   return "FMCC"+item.accountNumber+indexWithcheckSum;
		
	}

	
	private String calculateIndex(long lastUsedIndex, long rangeStart, long rangeEnd,int digits) {
        if(lastUsedIndex>=rangeStart && lastUsedIndex<=rangeEnd )
        {
		String output = Long.toString(lastUsedIndex+1);
	    while (output.length() < digits) 
	               output = "0" + output;
	    return output;
        }
        return null;
		
	}
	
	private String concateCheckSum(String index,int limit)
	{
		 log.info("ConsignmentService: concateCheckSum (): index= "+index);
	    Integer number=Integer.valueOf(index);
	    List<Integer> numbersList = new ArrayList<>();
	      
	    for (int i=0 ;i<index.length();i++)
	    	{
	    	
	    	numbersList.add(Integer.valueOf(index.charAt(i)-'0'));
	    	}
	     
	      log.info("concateCheckSum ()is numbersList= "+numbersList);
	    //step 1: Adding every second number in the index from the right starting at the first element
	     //step2: - Multiply that number by 3 
	      Integer level1=  Stream.iterate(9, i -> i - 2)
	    		   .limit(limit)
	    		   .map(numbersList::get).reduce(0,Integer::sum)*3;
	 
	      //step 3: Adding every second number in the index from the right starting at the first element
		     //step4: Multiply that number by 7
	      Integer level2=  Stream.iterate(8, i -> i - 2)
	    		   .limit(limit)
	    		   .map(numbersList::get).reduce(0,Integer::sum)*7;
	      
	      Integer checksum=round(level1+level2) -(level1+level2);
	      log.info("concateCheckSum () checksum= "+checksum);
	    return index.concat(checksum.toString());
		
	}

	  private  Integer round(Integer n)
	    {
		  log.info("ConsignmentService: round (): n= "+n);
	        int a = (n / 10) * 10;
	          
	      
	        int b = a + 10;
	      
	    
	        return  b ;
	    }

	
}
