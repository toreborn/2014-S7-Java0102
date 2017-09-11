package com.demo.org.bean;

/**
 * bean生成方式与参数配置
 * @author xl
 *
 */
public class BeanClass01 {
	private String msg;

	public BeanClass01() {
		super();
	}
	
	public BeanClass01(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void showMsg() {
		System.out.println(msg);
	}
}
