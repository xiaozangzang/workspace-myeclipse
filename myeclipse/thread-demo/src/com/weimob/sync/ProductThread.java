package com.weimob.sync;

public class ProductThread extends Thread {
	private Factory factory = null;

	   public ProductThread(String name, Factory factory)
	   {
	      super(name);
	      this.factory = factory;
	   }

	   @Override
	   public void run()
	   {
	      while (true)
	      {
	         factory.production();
	         try
	         {
	            Thread.sleep(10);
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("Éú²úÊÂ¹Ê...");
	         }
	      }
	   }
}
