package com.avinash.racecondition;

public class FirstRunnable {
	
	public static void main(String[] args) {
	
		Runnable runnable =()->{
			String name = Thread.currentThread().getName();
			System.out.println("I am Running in thread "+name);
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
		
	}
}
