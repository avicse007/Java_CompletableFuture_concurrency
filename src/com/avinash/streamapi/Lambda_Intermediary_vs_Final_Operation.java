package com.avinash.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Lambda_Intermediary_vs_Final_Operation {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("one","two","three","four","five");
		
		Predicate<String> p1 = s->s.equals("one");
		Predicate<String> p2 = s->s.equals("two");
		Predicate<String> p3 = s->s.equals("three");
		
		//peek is an intermediary operation of a Stream 
		// so it will not produce any data .For this we will 
		// have a Consumer with peek and a list.add method to 
		// check its impact
		
		List<String> list = new ArrayList<>();
		
		//Here we have use intermediary steps so no output
		System.out.println("With intermediary steps no output");
		stream1.peek(System.out::println).filter(p1.or(p2).or(p3))
		.peek(list::add);
		//check list size 
		System.out.println("Size of list "+list.size());
		
		System.out.println("With final operation there will be output");
		//Now lets try final operation. forEach is a final operation
		Stream<String> stream11 = Stream.of("one","two","three","four","five");
		stream11.peek(System.out::println).filter(p1.or(p2).or(p3))
		.forEach(list::add);
		//check list size 
		System.out.println("Size of list "+list.size());
		list.forEach(System.out::println);
		

	}

}
