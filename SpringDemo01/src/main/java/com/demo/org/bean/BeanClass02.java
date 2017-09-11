package com.demo.org.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 验证注解
 * @author xl
 *
 */
@Service("bc0222")
@Scope("prototype")
public class BeanClass02 {
	@Resource
	private BeanClass01 bc01;
	
	public void showMsg() {
		bc01.setMsg("This is bc0222222222");
		bc01.showMsg();
	}
}
