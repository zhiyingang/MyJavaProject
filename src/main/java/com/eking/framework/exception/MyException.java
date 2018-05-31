package com.eking.framework.exception;

public class MyException extends Exception{

	private static final long serialVersionUID = -9154565513392461405L;
	private Integer code;
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(Integer code) {
		this.code = code;
	}
	
	public MyException(String message,Throwable cause) {
		super(message,cause);
	}
	
	public MyException(Integer code,Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	public MyException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	public MyException(Integer code,String message,Throwable cause) {
		super(message,cause);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
