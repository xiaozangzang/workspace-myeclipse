package com.weimob.mutex;

public class SynchThread extends Thread{
	
	private NumCount numCount = null;
	
	public SynchThread(String name,NumCount numCount){
		super(name);
		this.numCount = numCount;
	}
	
	@Override
	public void run() {
		numCount.run();
	}

}
