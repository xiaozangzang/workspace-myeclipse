package com.weimob.ticket;
/**
 * 
 * @author ��־��
 * @date  2018-3-14 ����4:52:43	
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
				System.out.println("Ʊ������");
				return "����";
			}
			System.out.println(Thread.currentThread().getName() + "���򵽵�" + (101 - count) + "��Ʊ��");
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
