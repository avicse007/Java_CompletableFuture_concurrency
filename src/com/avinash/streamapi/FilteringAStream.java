package com.avinash.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilteringAStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("*","**","****","#**#","******","##","#","####");
		
		//Create a stream for a list
		Stream<String> stream = list.stream();
		
		//Create a Predicate that we can use in filter 
		
		Predicate<String> p2 = s->s.length()>2;
		
		System.out.println("String with length >2 ");
		stream.filter(p2).forEach(System.out::println);
		
		
		//Another way of creating a stream 
		
		Stream<String> stream1 = Stream.of("*","**","****","#**#","******","##","#","####");
		
		//Creating a Predicate 
		Predicate<String> p1 = s->s.length()%2==0;
		
		Stream<String> stream2 = stream1.filter(p1);
		
		System.out.println("Even Length Strings");
		stream2.forEach(System.out::println);
	}

}
