package com.apisero.exception;

public class InvalidConsumerNum extends Exception{

	public InvalidConsumerNum(String getConsumerId)
	{
		System.out.println("Invalid Consumer Number "+getConsumerId);
	}
}
