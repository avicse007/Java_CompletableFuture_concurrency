package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWiththenApply {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> nameFuture = CompletableFuture
				.supplyAsync(()->{
					System.out.println("inside name future");
					try {
						Thread.sleep(3000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					return "Avinash";
				});
		
		CompletableFuture<String> greeting = nameFuture.thenApplyAsync(
				name->{
					System.out.println("inside greeting future");
					try {
						Thread.sleep(3000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					return "Hello "+name;
				});
		
		System.out.println("Here are the greeting "+greeting.get());

	}

}
