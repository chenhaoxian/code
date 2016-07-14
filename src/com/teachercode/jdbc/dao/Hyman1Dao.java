package com.teachercode.jdbc.dao;

import java.util.List;

import com.teachercode.jdbc.po.Hyman1;

public interface Hyman1Dao {
	
	public int addHyman1(Hyman1 hyman);
	
	public int deleteHyman1(String name);
	
	public int updateHyman1(Hyman1 hyman);
	
	public List<Hyman1> showAllHyman1();
	

}
