package com.weimob.jwt;

public class TestJwt {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String token = JwtDemo.createToken();
		System.out.println(token);
		
		JwtDemo.verifyToken(token, "zwz");

	}

}
