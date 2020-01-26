package com.avinash.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda_Predicate {
	
	public static void main(String[] args) {
		
		Predicate<String> p1 = s->s.length()<=20;
		
		Predicate<String> p2 = s->s.length()>20;

		Predicate<String> nameConstraints = p1.and(p2);
		
		List<String> list = Arrays.asList("*","**","******","##","#","####");
		
		List<String> result = new ArrayList<String>();
		
		Consumer<String> c1 = System.out::println;
		
		Consumer<String> c2 = result::add;
		
		list.forEach(c1.andThen(c2));
		result.forEach(c1);
		
		
	
	}

}
