package com.avinash.streamapi;

import java.util.Arrays;
import java.util.List;

public class LambdaResuction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(10,20,30);
		
		Integer red = list.stream().reduce(0,Integer::sum);
		
		System.out.println("Resuction is "+red);
		
		red = list.stream().reduce(100,Integer::sum);
		
		System.out.println("Resuction is "+red);
		
		red = list.stream().reduce(100,Integer::max);
		
		System.out.println("Resuction is "+red);
		
        red = list.stream().reduce(0,Integer::max);
		
		System.out.println("Resuction is "+red);

	}

}
