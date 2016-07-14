package com.teachercode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.teachercode.jdbc.dao.Hyman1Dao;
import com.teachercode.jdbc.dao.impl.Hyman1DaoImpl;
import com.teachercode.jdbc.po.Hyman1;
import com.teachercode.jdbc.util.DbUtil;

public class Test {



	public static void main(String[] args) {

		
		Hyman1Dao dao = new Hyman1DaoImpl();
		List<Hyman1> list = dao.showAllHyman1();
		System.out.println(list.get(0).getMyname());
	}

}
