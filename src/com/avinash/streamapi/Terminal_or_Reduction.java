package com.avinash.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Terminal_or_Reduction {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9);
		
		Optional<Integer> min = list.stream().min(Comparator.naturalOrder());
		
		Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
		
		System.out.println(min.isPresent());
		
		System.out.println(min.get());
		
		System.out.println(max.isPresent());
		
		System.out.println(max.get());

	}

}
