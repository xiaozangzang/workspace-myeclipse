package com.weimob.sync;

import org.junit.Test;

public class ProducConsumDemo {
	public static void main(String[] args){
		Factory factory = new Factory();
	    ProductThread productThread = new ProductThread("生产工厂", factory);
	    ConsumThread consumThread = new ConsumThread("消费者", factory);
	    productThread.start();
	    consumThread.start();
	}
}
