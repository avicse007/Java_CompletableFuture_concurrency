package com.avinash.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream_Map_FlatMap {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		
		List<Integer> list3 = Arrays.asList(5,6);
		
		List<List<Integer>> list = Arrays.asList(list1,list2,list3);
		
		System.out.println(list);
		
		list.stream().map(l->l.size()).forEach(System.out::println);
		
		Function<List<?>, Integer> size = List::size;
		
		list.stream().map(size).forEach(System.out::println);
		
		Function<List<Integer>,Stream<Integer>> flatmapper = 
				l->l.stream();
	
		list.stream().map(flatmapper).forEach(System.out::println);
		
		list.stream().flatMap(flatmapper).forEach(System.out::println);
		
		
		
	}

}
