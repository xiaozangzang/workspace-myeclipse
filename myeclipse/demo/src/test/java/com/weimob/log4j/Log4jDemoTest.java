package com.weimob.log4j;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

public class Log4jDemoTest {
	
	@Test
	public void test(){
		long startTime = System.currentTimeMillis();
        //自动快速地使用缺省Log4j环境
        BasicConfigurator.configure();
        for(int i=0;i < Log4jDemo.cycle;i++){
            if(i<100){
                try{
                    Log4jDemo.log.info(new Person("godtrue",100/i,'M'));//打印对象的信息
                }catch(Exception e){
                	Log4jDemo.log.error(i+"岁的小孩还不存在嘛！");//打印对象的信息
                }finally{
                	Log4jDemo.log.warn("现在大部分人的年龄都在0到100岁之间的!");//打印对象的信息
                }
            }else{
            	Log4jDemo.log.info("我是一棵树，我今年活了"+i+"岁!哈哈，我厉害吧！");//打印对象的信息
            }
        }
        Log4jDemo.log.debug("此程序的运行时间是："+(System.currentTimeMillis()-startTime));//打印程序运行的时间
	}
}
