package com.weimob.sync;

public class ConsumThread extends Thread {
	 private Factory factory = null;

	   public ConsumThread(String name, Factory factory)
	   {
	      super(name);
	      this.factory = factory;
	   }

	   @Override
	   public void run()
	   {
	      while (true)
	      {
	         factory.getProduction();
	         try
	         {
	            Thread.sleep(10);
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("ÕË»§Óà¶î²»×ã...");
	         }
	      }
	   }
}
