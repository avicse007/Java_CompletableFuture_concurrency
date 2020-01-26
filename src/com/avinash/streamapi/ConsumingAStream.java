package com.avinash.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumingAStream {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("*","**","******","##","#","####");
		
		//Create a stream for a list
		Stream<String> stream = list.stream();
		
		//Lets create a consumer 
		
		Consumer<String> consumer = System.out::println;
		
		//Lets use this consumer on the stream
		
		stream.forEach(consumer);
	
		
		
	}

}
