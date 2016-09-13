package com.web.myapp.core.exception;

/**
 * 系统业务异常机制（自定义异常处理,描述类..）
 * throw new ParameterException("XXXX")
 */

public class ParameterException extends RuntimeException {
	
	private static final long serialVersionUID = -5792689458341004637L;

	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}