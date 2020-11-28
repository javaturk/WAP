package org.javaturk.wap.ch08.temperatureConverter.domain;

public class InvalidArgumentException extends Exception {
	private static String message = "Invalid value passed: ";
	
	public InvalidArgumentException(){
		super(message);
	}

}
