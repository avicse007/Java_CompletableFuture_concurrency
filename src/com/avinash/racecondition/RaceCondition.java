package com.avinash.racecondition;

public class RaceCondition {
	
	public static void main(String[] args) throws InterruptedException {
		LongWrapper longWrapper =new LongWrapper(0L);
		Runnable r =() -> {
			for(int i = 0;i<1000;i++) {
				longWrapper.incrementL();
			}
		};
		
		Thread t[] = new Thread[1000];
		for(int i =0;i<1000;i++) {
			t[i] = new Thread(r);
			t[i].start();
		}
		
		for(int i =0;i<t.length;i++) {
			t[i].join();
		}
		
		System.out.println("Value = "+longWrapper.getL());
	}

}
