package com.weimob.service;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
	 public static void main(String[] args) {  
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(    
	                new String[]{"applicationProvider.xml"});   
	        //发布服务
	        context.start();   
	        System.out.println("提供者服务已注册成功");    
	        System.out.println("请按任意键取消提供者服务");    
	        try {  
	            System.in.read();//让此程序一直跑，表示一直提供服务  
	        } catch (IOException e) {         
	            e.printStackTrace();  
	        }    
	  }  
}
