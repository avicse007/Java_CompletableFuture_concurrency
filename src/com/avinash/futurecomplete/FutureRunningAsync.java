package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureRunningAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(()-> {
						System.out.println("I am running in another thread");
						System.out.println("Thread name "+Thread.currentThread().getName());
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Done running");
					});
				
		System.out.println("I am rumming in different Thread");
		System.out.println("Thread name "+Thread.currentThread().getName());
		future.get();

	}

}
