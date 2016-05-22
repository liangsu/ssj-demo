package com.ls.ssj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ls.ssj.demo1.dao.EmfTeacherDao;
import com.ls.ssj.demo1.dao.JpaTeacherDao;
import com.ls.ssj.demo1.dao.TeacherDao;
import com.ls.ssj.demo1.service.TeacherService;
import com.ls.ssj.demo2.dao.StudentDao;
import com.ls.ssj.entity.demo1.Teacher;
import com.ls.ssj.entity.demo2.Student;
import com.ls.ssj.exception.ServiceException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classPath:spring-*.xml")
public class MainTest {

	//private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
	
	public static void main(String[] args) throws Exception {
		//test1();
		//test2(); 
		//test3();
//		test4();
		test5();
	}
	
	public static void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml","spring-jta.xml","spring-jpa1.xml","spring-jpa2.xml");
		JpaTeacherDao teacherDao = ac.getBean(JpaTeacherDao.class);
		Teacher t = teacherDao.findOne(1);
		System.out.println(t.getName());
		t.setName("emf教师");
		teacherDao.save(t);
		t = teacherDao.findOne(1);
		System.out.println(t.getName());
	}
	
	public static void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml","spring-jta.xml","spring-jpa1.xml","spring-jpa2.xml");
		EmfTeacherDao teacherDao = ac.getBean(EmfTeacherDao.class);
		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("emf教师");
		teacherDao.update(t);
		t = teacherDao.get(1);
		System.out.println(t.getName());
	}

	public static void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		TeacherDao teacherDao = ac.getBean(TeacherDao.class);
		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("aaa");
		teacherDao.update(t);
		t = teacherDao.get(1);
		System.out.println(t.getName());
	}

	/**
	 * 测试jdbcTemplate dao
	 */
	public static void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");
		StudentDao studentDao = ac.getBean(StudentDao.class);
		Student s = studentDao.get(1);
		System.out.println(s.getName());
		s.setName("学生2");
		studentDao.update(s);
		s = studentDao.get(1);
		System.out.println(s.getName());
	}

	/**
	 * 测试jdbcTemplate service
	 * @throws ServiceException 
	 */
	public static void test3() throws ServiceException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-*.xml");

		TeacherDao teacherDao = ac.getBean(TeacherDao.class);
		StudentDao studentDao = ac.getBean(StudentDao.class);
		TeacherService ts = ac.getBean(TeacherService.class);

		Teacher t = teacherDao.get(1);
		System.out.println(t.getName());
		t.setName("教师33");

		Student s = studentDao.get(1);
		System.out.println(s.getName());
		s.setName("学生33");

		ts.update(t, s);
		ts.print();
	}
}
