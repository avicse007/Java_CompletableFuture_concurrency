package com.avinash.lambda;

import java.util.concurrent.TimeUnit;

public class LambdaEx1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Runnable lambdaRunnable= ()->{
			for(int i=0;i<3;i++) {
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("Thread "+Thread.currentThread().getName());
			}
		};
		
		Thread t = new Thread(lambdaRunnable);
		t.start();
		t.join();

	}

}
