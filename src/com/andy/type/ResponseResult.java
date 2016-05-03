package com.andy.type;

/**
 * 请求返回类
 * 
 * @author Andy
 */
public class ResponseResult {
	private Boolean success = true;
	private String msg = " ";
	private Object object = null;

	public Boolean getSuccess() {
		return success;
	}

	/**
	 * 请求是否成功
	 * 
	 * @param success
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * 请求提示
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	/**
	 * 请求结果
	 * 
	 * @param object
	 */
	public void setObject(Object object) {
		this.object = object;
	}
}
