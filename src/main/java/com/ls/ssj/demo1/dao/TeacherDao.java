package com.ls.ssj.demo1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ls.ssj.entity.demo1.Teacher;

@Repository
public class TeacherDao {

	@Resource(name="jdbcTemplate1")
	JdbcTemplate jdbcTemplate;
	
	public Teacher get(int id){
		Teacher t = jdbcTemplate.query("select * from teacher where id = ?",new Object[]{id} , new ResultSetExtractor<Teacher>(){
			@Override
			public Teacher extractData(ResultSet rs) throws SQLException, DataAccessException {
				System.out.println(rs);
				Teacher t = null;
				if(rs.next()){
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					t = new Teacher(id, name);
				}
				return t;
			}
		});
		
		return t;
	}
	
	@Transactional
	public void update(Teacher t){
		String sql = "update teacher set name = '"+t.getName()+"' where id = "+t.getId();
		jdbcTemplate.execute(sql);
	}
}
