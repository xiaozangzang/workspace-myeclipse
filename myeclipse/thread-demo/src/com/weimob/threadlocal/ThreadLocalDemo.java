package com.weimob.threadlocal;

import org.junit.Test;
/**
 * ThreadLocal：当有多个线程操作同一个本地变量，ThreadLocal可以保证每个线程拿到该变量的独立副本，每个线程修改独立副本，不影响其他
 * 线程的独立副本，实现了线程安全但没有实现线程同步；sychronized是从时间上换空间，ThreadLocal是从空间上换时间。
 * @author 张志鹏
 * @date  2018-3-15 上午10:33:13	
 *
 */

public class ThreadLocalDemo {
	// ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// ②获取下一个序列值
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	@Test
	public void test() {
		ThreadLocalDemo sn = new ThreadLocalDemo();
		// ③ 3个线程共享sn，各自产生序列号
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
			// ④每个线程打出3个序列值
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
				+ sn.getNextNum() + "]");
			}
		}
	}
}