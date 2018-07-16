package com.weimob.mutex;

public class NumCount {
	
	public int count = 0;
	
	public NumCount(){}
	
	public NumCount(String name){
		Thread.currentThread().setName(name);
	}
	
	public synchronized void run(){
		for(int i = 0;i < 100;i++){
			Thread thread = Thread.currentThread();
			System.out.println(thread.getName() + "第" + i + "次计数，count值为:" + ++count);
			try {
				//睡眠5毫秒，给其他线程运行机会
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
