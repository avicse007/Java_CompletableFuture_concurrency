package com.avinash.racecondition;

public class LongWrapper {
	private Long l;
	
	Object key = new Object();
	
	public LongWrapper(long l1) {
		this.l = l1;
	}

	public Long getL() {
		return l;
	}

	public void incrementL() {
		/*synchronized (key) {
			this.l = this.l+1;
		}
		*/
		this.l = this.l+1;
	}
	
	

}