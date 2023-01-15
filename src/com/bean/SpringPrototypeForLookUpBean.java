package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringPrototypeForLookUpBean {
	
	
	private String msg="Hello";
	public boolean isModified;
	
	public void printHello() {
		System.out.println(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private SpringPrototypeForLookUpBean() {
		System.out.println("SpringPrototypeForLookUpBean prototype instance created");
    }

	public boolean isModified() {
		return isModified;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}

}
