package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FutureCompletableWithExecutorAsync {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Executor executor = (Executor)Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
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
		},executor);
		
		System.out.println("Running In main with thread "+Thread.currentThread().getName());
		System.out.println("Block and get the result of the Future ");
		String result = future.get();
		System.out.println("The result is "+result);
		
	}

}
