package com.ls.ssj.demo2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ls.ssj.entity.demo2.Student;

@Repository
public class StudentDao {

	@Resource(name="jdbcTemplate2")
	JdbcTemplate jdbcTemplate;
	
	public Student get(int id){
		Student t = jdbcTemplate.query("select * from student where id = ?",new Object[]{id} , new ResultSetExtractor<Student>(){
			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				System.out.println(rs);
				Student t = null;
				if(rs.next()){
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					t = new Student(id, name);
				}
				return t;
			}
		});
		return t;
	}
	
	@Transactional
	public void update(Student t){
		String sql = "update student set name = '"+t.getName()+"' where id = "+t.getId();
		jdbcTemplate.execute(sql);
	}
}
