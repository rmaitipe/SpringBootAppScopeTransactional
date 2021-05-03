package com.bean;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("SpringSingletonBean instance created");
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
	
	public SpringPrototypeBean getPrototypeBean() {
		System.out.println(String.valueOf(LocalTime.now()));
        return prototype;
    }
	
}
