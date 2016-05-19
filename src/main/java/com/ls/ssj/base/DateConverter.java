package com.ls.ssj.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	public Date convert(String dateStr) {
		Date date = parse(dateStr, "yyyy-MM-dd HH:mm:ss SSS");
		
		if(date == null){
			date = parse(dateStr, "yyyy-MM-dd HH:mm:ss");
		}
		
		if(date == null){
			date = parse(dateStr, "yyyy-MM-dd");
		}
		
		System.out.println("date:"+date);
		return date;
	}
	
	private Date parse(String dateStr, String pattern){
		Date date = null;
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			
		}
		return date;
	}
}
