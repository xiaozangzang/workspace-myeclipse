package com.weimob.sync;

import java.util.Vector;
/**
 * �����߷��ֻ����Ѵ����ޣ���Ӧwait()���ͷ����������߳̾�������δ������������������������������������߳����ѣ�
 * �����߷���û�л�������ѣ���Ӧwait()���ͷ������������߳̾����������л�����������ѣ����ѽ��������������̡߳�
 * @author ��־��
 * @date  2018-3-15 ����3:15:18	
 *
 */
public class Factory {
	private Vector<String> goods;
	   // ��־��������
	   private int goodFlag = 1;

	   public Factory()
	   {
	      goods = new Vector<String>();
	   }

	   public synchronized void production()
	   {
	      if (goods.size() < goodFlag)
	      {
	         goods.addElement("����" + (goods.size() + 1));
	         System.out.printf("%s�����������%d�����л���������%d\n", Thread.currentThread().getName(),
	             (goods.size() + 1),
	               goods.size());
	         // ���������߳�
	         notifyAll();
	      }
	      else
	      {
	         System.out.println("������������ȡ��");
	         try
	         {
	            // �������ȴ�����
	            wait();
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("�����¹�...");
	         }
	      }
	   }

	   public synchronized void getProduction()
	   {
	      if (goods.size() < 1)
	      {
	         try
	         {
	            System.out.println("������ȡ��...");
	            // �ȴ�����
	            wait();
	         }
	         catch (InterruptedException e)
	         {
	            System.out.println("�˻�����...");
	         }
	      }
	      else
	      {
	         System.out.printf("%sȡ�߻��%s�����л���������%d\n", Thread.currentThread().getName(),
	             goods.elementAt(goods.size() - 1),
	               goods.size());
	         goods.remove(goods.size() - 1);
	         // ���������߳�
	         notifyAll();
	      }
	   }
}
