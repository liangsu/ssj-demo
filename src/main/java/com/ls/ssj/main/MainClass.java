package com.ls.ssj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ls.ssj.demo1.dao.EmfTeacherDao;
import com.ls.ssj.demo1.dao.TeacherDao;
import com.ls.ssj.demo1.service.TeacherService;
import com.ls.ssj.demo2.dao.StudentDao;
import com.ls.ssj.entity.demo1.Teacher;
import com.ls.ssj.entity.demo2.Student;

public class MainClass {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
		test4();
	}
	
	public static void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		EmfTeacherDao teacherDao = ac.getBean(EmfTeacherDao.class);
		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("emf教师");
		teacherDao.update(t);
		t = teacherDao.get(1);
		System.out.println(t.getName());
	}
	
	public static void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		TeacherDao teacherDao = ac.getBean(TeacherDao.class);
		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("aaa");
		teacherDao.update(t);
		t = teacherDao.get(1);
		System.out.println(t.getName());
	}
	
	public static void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		StudentDao studentDao = ac.getBean(StudentDao.class);
		Student s = studentDao.get(1);
		System.out.println(s.getName());
		s.setName("学生2");
		studentDao.update(s);
		s = studentDao.get(1);
		System.out.println(s.getName());
	}
	
	public static void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		
		TeacherDao teacherDao = ac.getBean(TeacherDao.class);
		StudentDao studentDao = ac.getBean(StudentDao.class);
		TeacherService ts = ac.getBean(TeacherService.class);
		
		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("教师55");
		
		Student s = studentDao.get(1);
		System.out.println(s.getName());
		s.setName("学生55");
		
		ts.update(t, s);
		ts.print();
	}
}
