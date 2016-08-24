package com.web.myapp.core.exception;

/**
 * 自定义异常处理,描述类..throw new ParameterException("XXXX")
 * @author Lipengfei
 */

public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

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