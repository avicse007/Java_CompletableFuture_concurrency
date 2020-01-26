package com.avinash.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda_Collectors {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		List<String> str = Arrays.asList("sadasda","hfgh","hrtyryry","gdgdfgdg","hgjg","dfdsf","adafsdf","dfsdfs","hgg","fghfg");
		for(int i=0;i<20;i++) {
			int age = (int) (Math.random()*20);
			age = age+i;
			String str1 = str.get((int) (Math.random()*10))+i;
			Person p = new Person(age, str1);
            people.add(p);
		}
		
		Optional<Person> young=people.stream().filter(p->p.getAge()>20).min(Comparator.comparing(Person::getAge));
		
		System.out.println("Young People of age >20 "+young);
		
		Map<Integer, List<Person>> map = 
				people.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		
		System.out.println("Map grouped by age is "+map);
		
		Map<Integer, Long> map1 = 
				people.stream()
				.collect(Collectors.
						groupingBy(Person::getAge,Collectors.counting()));
		
		System.out.println("Map grouped by age count "+map1);
	   }
	

}

class Person {
	
	String name;
	
	int age; 
	
	Person(int age ,String name){
		this.age = age;
		this.name= name;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return this.name+" : "+this.age;
	}
	
}
