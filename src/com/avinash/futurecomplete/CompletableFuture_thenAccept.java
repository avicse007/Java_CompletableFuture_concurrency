package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture_thenAccept {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> nameFuture = 
				CompletableFuture.supplyAsync(()->{
					return "Avinash";
				});

		CompletableFuture<Void> sayHello = 
				nameFuture.thenAccept((name)->{
					System.out.println("Hello "+name);
				});
		sayHello.get();
	}

}
