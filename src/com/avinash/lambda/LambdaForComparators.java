package com.avinash.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaForComparators {

	public static void main(String[] args) {
	   
		Comparator<String> comp = (String s1,String s2)->{
			
			 return Integer.compare(s1.length(), s2.length());
			
		};
		
		
		List<String> list = Arrays.asList("*","**","******","##","#","####");
		list.sort(comp);
		for(String s : list)
			System.out.print(s+" ");
		
	}
	

}
