package com;
import javax.annotation.PostConstruct;

import com.bean.SpringPrototypeBean;
import com.bean.SpringPrototypeForLookUpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bean.SpringSingletonBean;
import com.bean.SpringSingletonLookUpBean;
import com.pojo.Student;
import com.services.ISpringService;

import java.util.List;

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
		SpringPrototypeBean pb1 =bean1.getPrototypeBean();
	    SpringSingletonBean bean2 = context.getBean(SpringSingletonBean.class);
		SpringPrototypeBean pb2 =bean2.getPrototypeBean();
		if (pb1.equals(pb2)){
			System.out.println("The instances are same");
		}
	    System.out.println("part II");
	    SpringSingletonLookUpBean bean5 = context.getBean(SpringSingletonLookUpBean.class);
		SpringPrototypeForLookUpBean pb3 =bean5.getPrototypeBean();
	    SpringSingletonLookUpBean bean6 = context.getBean(SpringSingletonLookUpBean.class);
		SpringPrototypeForLookUpBean pb4 = bean6.getPrototypeBean();
		if (!pb3.equals(pb4)){
			System.out.println("The instances are not the same");
		}
	}
  
  	@PostConstruct
  	public void init() {
	    System.out.println("part III");
	    Student student1 = new Student(1, "Uno","Last");
	    service.update1(student1);
	    Student student2 = new Student(3, "Tres","Last");
		try {
			System.out.println("This update throws a NPE after save method");
			service.update2(student2);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }

		List<Student> studentAll= service.findAll();
	    System.out.println(studentAll.toString()+ "End part III");
  	}
  
}