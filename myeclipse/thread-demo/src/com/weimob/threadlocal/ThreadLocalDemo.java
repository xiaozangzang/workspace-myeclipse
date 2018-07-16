package com.weimob.threadlocal;

import org.junit.Test;
/**
 * ThreadLocal�����ж���̲߳���ͬһ�����ر�����ThreadLocal���Ա�֤ÿ���߳��õ��ñ����Ķ���������ÿ���߳��޸Ķ�����������Ӱ������
 * �̵߳Ķ���������ʵ�����̰߳�ȫ��û��ʵ���߳�ͬ����sychronized�Ǵ�ʱ���ϻ��ռ䣬ThreadLocal�Ǵӿռ��ϻ�ʱ�䡣
 * @author ��־��
 * @date  2018-3-15 ����10:33:13	
 *
 */

public class ThreadLocalDemo {
	// ��ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// �ڻ�ȡ��һ������ֵ
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	@Test
	public void test() {
		ThreadLocalDemo sn = new ThreadLocalDemo();
		// �� 3���̹߳���sn�����Բ������к�
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class TestClient extends Thread {
		private ThreadLocalDemo sn;
	
		public TestClient(ThreadLocalDemo sn) {
			this.sn = sn;
		}
		
		public void run() {
			for (int i = 0; i < 3; i++) {
			// ��ÿ���̴߳��3������ֵ
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
				+ sn.getNextNum() + "]");
			}
		}
	}
}