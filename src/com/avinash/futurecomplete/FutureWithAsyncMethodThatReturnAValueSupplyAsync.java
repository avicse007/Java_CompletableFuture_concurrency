package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class FutureWithAsyncMethodThatReturnAValueSupplyAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				System.out.println("Running in another thread async ");
				System.out.println("Name of thread "+Thread.currentThread().getName());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Done running async");
				return "done";
			}
			
		});
		System.out.println("In main");
		System.out.println("Block and get the result of the Future ");
		String result = future.get();
		System.out.println("The result is "+result);
	
	
	CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
		System.out.println("Running in another thread async with lambda function ");
		System.out.println("Name of thread in lambda"+Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done running async in lambda ");
		return "done Async";
	});
	
	System.out.println("In main again ");
	System.out.println("Block and get the result of the Future ");
	String result1 = future1.get();
	System.out.println("The result is "+result1);
	
	}

}
