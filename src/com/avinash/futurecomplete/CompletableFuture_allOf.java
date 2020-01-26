package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFuture_allOf {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
			CompletableFuture<String> future1 = 
					CompletableFuture.supplyAsync(()->{
						System.out.println("Inside Future1");
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return "FUTURE1_DONE";
						
					});

			
			CompletableFuture<String> future2 = 
					CompletableFuture.supplyAsync(()->{
						System.out.println("Inside Future2");
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return "FUTURE2_DONE";
						
					});
			
			
			CompletableFuture<String> future3 = 
					CompletableFuture.supplyAsync(()->{
						System.out.println("Inside Future3");
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return "FUTURE3_DONE";
						
					});
			
			CompletableFuture<Void> combined = 
					CompletableFuture.allOf(future1,future2,future3);
			System.out.println("If we use allOf to combine");
			System.out.println("The combined value "+combined.get());
			
			String combined1 = Stream.of(future1, future2, future3)
					  .map(CompletableFuture::join)
					  .collect(Collectors.joining(" "));
			
			System.out.println("Combined "+combined1);
	}

}
