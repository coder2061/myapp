package com.web.myapp.core.exception;

/**
 * 系统业务异常机制
 * throw new BizException("XXXX")
 */
public class BizException extends RuntimeException{
	
	private static final long serialVersionUID = 497238450259322560L;
	
	private String code;
	
	public BizException() {
		super();
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
