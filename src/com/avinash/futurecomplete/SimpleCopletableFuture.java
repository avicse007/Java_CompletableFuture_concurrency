package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleCopletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> simpleFuture = new CompletableFuture<String>();
		System.out.println(" Again getting the future result after "+simpleFuture.isDone());
		try {
			System.out.println("Future get function is blocking "+simpleFuture.get(3, TimeUnit.SECONDS));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("There is the error "+e.getLocalizedMessage());
		}
		CompletableFuture.allOf(simpleFuture);
		//System.out.println(" Again getting the future result after calling allOf()"+simpleFuture.get());
		boolean isCompleted = simpleFuture.complete("Manually Completing a future");
		simpleFuture.complete("This Completation will not work future");
		System.out.println("Is Completed "+isCompleted);
		System.out.println(" Again getting the future result after complete "+simpleFuture.get());

	}

}
