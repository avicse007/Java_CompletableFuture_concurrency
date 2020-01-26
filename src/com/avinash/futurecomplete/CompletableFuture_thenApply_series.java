package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture_thenApply_series {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> welcome = 
				CompletableFuture.supplyAsync(()->{
					try {
						TimeUnit.SECONDS.sleep(3);
					}catch (InterruptedException e) {
						// TODO: handle exception
					}
					return "Avinash";
				}).thenApply(name->{
					return name+" Welcome to learn Completable Future";
				});
		
		System.out.println("calling get \n"+welcome.get());

	}

}
