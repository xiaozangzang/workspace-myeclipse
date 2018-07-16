package com.weimob.ticket;

import org.junit.Test;

public class TicketThreadDemo {
	public static void main(String[] args){
		//����Ʊ��100��
		TicketThread ticketThread = new TicketThread(100);
		//���������߳̽�����Ʊ
		Thread thread1 = new Thread(ticketThread,"thread-1");
		thread1.start();
		Thread thread2 = new Thread(ticketThread,"thread-2");
		thread2.start();
		Thread thread3 = new Thread(ticketThread,"thread-3");
		thread3.start();
		try {
			thread1.join(5);
			thread2.join(5);
			thread3.join(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
