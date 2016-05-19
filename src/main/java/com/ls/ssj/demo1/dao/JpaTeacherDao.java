package com.ls.ssj.demo1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ls.ssj.entity.demo1.Teacher;

public interface JpaTeacherDao extends JpaRepository<Teacher, Integer>{

}
