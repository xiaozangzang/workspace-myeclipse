package com.weimob.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.BaseDescription;


public class Log4jDemo {
	
	//日志记录表
	public static Logger log = LogManager.getLogger(Log4jDemo.class);
	//循环次数
    public static long cycle = 102;


}
