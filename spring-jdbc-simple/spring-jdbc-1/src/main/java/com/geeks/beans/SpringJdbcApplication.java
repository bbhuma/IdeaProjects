package com.geeks.beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringJdbcApplication.class, args);
		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		FrameWorkDao dao = (FrameWorkDao) con.getBean("framework"); 
		FrameWork frame = dao.getDetail("social"); 
		System.out.println("Java FrameWork Object"); 
		System.out.println(frame.getId()+". "+frame.getName()+": "+frame.getDescription());
	}

}
