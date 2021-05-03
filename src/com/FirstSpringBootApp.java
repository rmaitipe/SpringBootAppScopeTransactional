package com;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bean.SpringSingletonBean;
import com.bean.SpringSingletonLookUpBean;
import com.pojo.Student;
import com.services.ISpringService;

/*
 * NPE - Can't use the @Autowired services in constructor because
 * Autowiring happens only after the construction of an object and references in the object will null until then.
 * If you need to run some initialization code, pull the code in the constructor into a method, and annotate that method with @PostConstruct.
 */
@SpringBootApplication
public class FirstSpringBootApp{
  
	
    @Autowired 
	private ISpringService service;
	
	public static void main(String[] args) {
		System.out.println("part I");
		ApplicationContext context = SpringApplication.run(FirstSpringBootApp.class, args);
		SpringSingletonBean bean1 = context.getBean(SpringSingletonBean.class);
	    bean1.getPrototypeBean();
	    SpringSingletonBean bean2 = context.getBean(SpringSingletonBean.class);
	    bean2.getPrototypeBean();
	    System.out.println("part II");
	    SpringSingletonLookUpBean bean5 = context.getBean(SpringSingletonLookUpBean.class);
	    bean5.getPrototypeBean();
	    SpringSingletonLookUpBean bean6 = context.getBean(SpringSingletonLookUpBean.class);
	    bean6.getPrototypeBean();
	}
  
  	@PostConstruct
  	public void init() {
	    System.out.println("part III");
	    /*Student student1 = new Student(1, "Uno","Last");	    
	    service.update1(student1);
	    Student student2 = new Student(3, "Tres","Last");
		try {    
			service.update2(student2);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }*/
		Student student3= service.find(3);
	    System.out.println(student3.toString()+ "End part III");		
  	}
  
}