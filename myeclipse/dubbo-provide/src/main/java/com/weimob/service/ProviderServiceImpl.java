package com.weimob.service;

/**
 * 提供service实现层
 * @author dell
 *
 */
public class ProviderServiceImpl implements ProviderService {

	@Override
	public String sayHello(String name) {
		return "Hello.........." + name + "，你好你好~";
	}
}
