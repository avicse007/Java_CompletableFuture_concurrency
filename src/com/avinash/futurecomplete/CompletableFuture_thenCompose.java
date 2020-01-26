package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture_thenCompose {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<CompletableFuture<Double>> result =
			getUser("").thenApply(user->getUserCreditScore(user));
		
		System.out.println("The Credit Score is "+result.get().get());
		
		
		System.out.println("Use thenCompose to flatten the future result");
		
		CompletableFuture<Double> result1 =
				getUser("").thenCompose(user->getUserCreditScore(user));
		
		System.out.println("Rate "+result1.get());
		
	}
	
	public static CompletableFuture<String> getUser(String user){
		return 
				CompletableFuture.supplyAsync(()->{
					System.out.println("Returning user ");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "82169:Avinash:Singh:TYPE-7";
				});
	}
	
	public static CompletableFuture<Double> getUserCreditScore(String user){
		 return CompletableFuture.supplyAsync(()->{
			 System.out.println("Returning user Credit score "+user);
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(user.split(":")[3].split("-")[1]=="7")
				return 10.0D;
				else
					return 2.0D;
		 });
	}

}
