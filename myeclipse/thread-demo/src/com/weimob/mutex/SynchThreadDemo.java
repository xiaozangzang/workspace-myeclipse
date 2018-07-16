package com.weimob.mutex;

import org.junit.Test;

/**
 * 
 * @author 张志鹏
 * @date  2018-3-13 下午  4:29:13	
 * 
 * 线程间互斥
 *
 */
public class SynchThreadDemo {

	@Test
	public void test(){
		NumCount numCount = new NumCount();
		SynchThread synchThread1 = new SynchThread("Thread-1", numCount);
		SynchThread synchThread2 = new SynchThread("Thread-2", numCount);
		SynchThread synchThread3 = new SynchThread("Thread-3", numCount);
		synchThread1.start();
		synchThread2.start();
		synchThread3.start();
		try {
			synchThread1.join();
			synchThread2.join();
			synchThread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
