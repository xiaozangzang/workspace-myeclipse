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
			System.out.println(thread.getName() + "��" + i + "�μ�����countֵΪ:" + ++count);
			try {
				//˯��5���룬�������߳����л���
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
