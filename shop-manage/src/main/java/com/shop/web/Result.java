package com.shop.web;

public class Result {

	public static final String SUCCESS = "成功！";
	public static final String FAIL = "失败！";

	private String message;

	private boolean success;

	public Result() {

	}

	public Result(boolean success) {

		if (success)
			this.message = SUCCESS;
		if (!success)
			this.message = FAIL;

		this.success = success;
	}

	public Result( boolean success,String message) {
		this.message = message;
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
