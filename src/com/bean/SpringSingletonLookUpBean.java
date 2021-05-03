package com.bean;

import java.time.LocalTime;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SpringSingletonLookUpBean {
	
	@Autowired
	ObjectFactory<SpringPrototypeForLookUpBean> prototypeFactory;
	
	private String msg="Hello";
	public boolean isModified;
	
	public SpringSingletonLookUpBean() {
		System.out.println("SpringSingletonLookUpBean instance created");
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
	
	public SpringPrototypeForLookUpBean getPrototypeBean() {
		System.out.println(String.valueOf(LocalTime.now()));
        return prototypeFactory.getObject();
    }
	
}
