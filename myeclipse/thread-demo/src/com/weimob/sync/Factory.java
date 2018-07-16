package com.weimob.sync;

import java.util.Vector;
/**
 * 生产者发现货物已达上限，则应wait()，释放锁让其他线程竞争，若未达上限则进行生产，生产结束唤醒消费者线程消费；
 * 消费者发现没有货物可消费，则应wait()，释放所锁让其他线程竞争，若仍有货物则进行消费，消费结束唤醒生产者线程。
 * @author 张志鹏
 * @date  2018-3-15 下午3:15:18	
 *
 */
public class Factory {
	private Vector<String> goods;
	   // 标志货物上限
	   private int goodFlag = 1;

	   public Factory()
	   {
	      goods = new Vector<String>();
	   }

	   public synchronized void production()
	   {
	      if (goods.size() < goodFlag)
	      {
	         goods.addElement("货物" + (goods.size() + 1));
	         System.out.printf("%s生产货物：货物%d，现有货物数量：%d\n", Thread.currentThread().getName(),
	             (goods.size() + 1),
	               goods.size());
	         // 唤醒消费线程
	         notifyAll();
	      }
	      else
	      {
	         System.out.println("货物已满可以取货");
	         try
	         {
	            // 货物满等待消费
	            wait();
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("生产事故...");
	         }
	      }
	   }

	   public synchronized void getProduction()
	   {
	      if (goods.size() < 1)
	      {
	         try
	         {
	            System.out.println("货物已取完...");
	            // 等待生产
	            wait();
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("账户余额不足...");
	         }
	      }
	      else
	      {
	         System.out.printf("%s取走货物：%s，还有货物数量：%d\n", Thread.currentThread().getName(),
	             goods.elementAt(goods.size() - 1),
	               goods.size());
	         goods.remove(goods.size() - 1);
	         // 唤醒生产线程
	         notifyAll();
	      }
	   }
}
