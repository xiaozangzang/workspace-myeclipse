package com.weimob.sync;

import org.junit.Test;

public class ProducConsumDemo {
	public static void main(String[] args){
		Factory factory = new Factory();
	    ProductThread productThread = new ProductThread("��������", factory);
	    ConsumThread consumThread = new ConsumThread("������", factory);
	    productThread.start();
	    consumThread.start();
	}
}
