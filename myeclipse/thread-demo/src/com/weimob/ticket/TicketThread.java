package com.weimob.ticket;

public class TicketThread implements Runnable{
	//����Ʊ
	private Ticket ticket;
	
	public TicketThread(int count){
		ticket = new Ticket(count);
	}
	
	@Override
	public void run() {
		while(true){
			String returnStr = ticket.run();
			if (returnStr.equals("����"))
				System.exit(0);
		}
		
	}
}
