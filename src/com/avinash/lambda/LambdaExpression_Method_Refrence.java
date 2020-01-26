package com.avinash.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression_Method_Refrence {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Avinash","Suraj","Bikash","Raj","Anand");
		System.out.println("Using Lambda Expresion");
		list.forEach(name->System.out.println(name));
		System.out.println("Using foreach with lambda and method reference");
		list.forEach(System.out::println);

	}

}
