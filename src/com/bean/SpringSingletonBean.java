package com.bean;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SpringSingletonBean {
	
	@Autowired
	SpringPrototypeBean prototype;
	
	private String msg="Hello";
	public boolean isModified;
	
	public SpringSingletonBean() {
		System.out.println("SpringSingletonBean singleton instance created");
    }
	
	public void printHello() {
		System.out.println(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isModified() {
		return isModified;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}

	//@Lookup solution using Lookup Method
	public SpringPrototypeBean getPrototypeBean() {
		System.out.println(String.valueOf(LocalTime.now()));
        return prototype;
		//return BeanUtil.getBean(SpringPrototypeBean.class); solution using Application context
    }
	
}
