package com.weimob.ticket;

public class TicketThread implements Runnable{
	//创建票
	private Ticket ticket;
	
	public TicketThread(int count){
		ticket = new Ticket(count);
	}
	
	@Override
	public void run() {
		while(true){
			String returnStr = ticket.run();
			if (returnStr.equals("售完"))
				System.exit(0);
		}
		
	}
}
