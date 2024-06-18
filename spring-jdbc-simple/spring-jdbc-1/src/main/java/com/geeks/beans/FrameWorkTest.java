package com.geeks.beans; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class FrameWorkTest { 

	public static void main(String[] args) { 

		ApplicationContext con = new ClassPathXmlApplicationContext("src/main/resources/applicationContext.xml"); 
		FrameWorkDao dao = (FrameWorkDao) con.getBean("framework"); 
		FrameWork frame = dao.getDetail("social"); 
		System.out.println("Java Results"); 
		System.out.println(frame.getId()+". "+frame.getName()+": "+frame.getDescription()); 
		
	} 

} 
