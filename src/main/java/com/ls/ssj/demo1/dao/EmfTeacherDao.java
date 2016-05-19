package com.ls.ssj.demo1.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ls.ssj.entity.demo1.Teacher;

@Repository
public class EmfTeacherDao {
	
	@Resource(name="entityManagerFactory1")
	private EntityManagerFactory emf;
	
	@PersistenceContext
	protected EntityManager em;
	
	public Teacher get(int id){
		Teacher t = em.find(Teacher.class, 1);
		return t;
	}
	
	@Transactional
	public void update(Teacher t){
		em.merge(t);
		System.out.println("方法中:"+t.getName());
	}
}
