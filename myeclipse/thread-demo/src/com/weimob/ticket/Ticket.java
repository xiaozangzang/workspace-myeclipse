package com.weimob.ticket;
/**
 * 
 * @author 张志鹏
 * @date  2018-3-14 下午4:52:43	
 *
 */
public class Ticket{
	
	private int count = 100;
	private Object obj = new Object();
	
	public Ticket(){
		
	}
	public Ticket(int count){
		this.count = count;
	}
	public String run() {
		synchronized (obj) {
			if(count <= 0){
				System.out.println("票已买完");
				return "售完";
			}
			System.out.println(Thread.currentThread().getName() + "购买到第" + (101 - count) + "张票！");
			count--;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
	}
}
