package com.ls.ssj.demo1.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ls.ssj.demo1.dao.TeacherDao;
import com.ls.ssj.demo2.dao.StudentDao;
import com.ls.ssj.entity.demo1.Teacher;
import com.ls.ssj.entity.demo2.Student;
import com.ls.ssj.exception.ServiceException;

@Service
public class TeacherService {
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private StudentDao studentDao;
	
	public void print(){
		Teacher t = teacherDao.get(1);
		Student s = studentDao.get(1);
		
		System.out.println(t.getName() + "--" + s.getName());
	}
	
	@Transactional(rollbackFor=ServiceException.class)
	public void update(Teacher t, Student s) throws ServiceException{
		teacherDao.update(t);
//		int i = 9/0;
//		if(true){
//			throw new ServiceException("");
//		}
		studentDao.update(s);
	}
}
