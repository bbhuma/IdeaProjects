package com.geeks.test; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geeks.beans.FrameWork;
import com.geeks.beans.FrameWorkDao; 

public class FrameWorkTest { 

	public static void main(String[] args) { 

		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		FrameWorkDao dao = (FrameWorkDao) con.getBean("framework"); 
		FrameWork frame = dao.getDetail("social"); 
		System.out.println("Java Results"); 
		System.out.println(frame.getId()+". "+frame.getName()+": "+frame.getDescription()); 
		
	} 

} 
