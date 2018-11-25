package com.xywy.zngj.web.enumtype;

/**
 * Author: lyp
 * Create Date: 2017/10/30
 * Description:
 */
public enum ResponseStatus {
	Success(2000, "ok"),
	BadRequest(4000,"错误的请求"),
	InvalidParameterrror(4001, "参数错误"),
	ResourceNotFound(4004, "请求资源未找到"),
	RequestMethodNotSupported(4005,"请求方法不正确"),
	ServerInternalError(5000, "服务器错误，应该是我们遇到BUG了");

	private final int code;
	private final String message;

	private ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int value() {
		return this.code;
	}

	public String message() {
		return this.message;
	}

	public static ResponseStatus valueOf(int code) {
		for (ResponseStatus status : values()) {
			if (status.code == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + code + "]");
	}

	@Override
	public String toString() {
		return Integer.toString(code);
	}
}
