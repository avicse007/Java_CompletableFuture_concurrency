package com.avinash.futurecomplete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture_thenRun {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future =
				CompletableFuture.supplyAsync(()->{
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "Just Run";
				}).thenRun(()->{
					System.out.println("Running without the return value from completable future ");
				});
            System.out.println(future.get());
	}

}
