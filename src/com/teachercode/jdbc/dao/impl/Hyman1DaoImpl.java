package com.teachercode.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teachercode.jdbc.dao.Hyman1Dao;
import com.teachercode.jdbc.po.Hyman1;
import com.teachercode.jdbc.util.DbUtil;

public class Hyman1DaoImpl implements Hyman1Dao {

	private Connection con = null;
	private PreparedStatement pst = null;
	private int resultNum = 0;

	@Override
	public int addHyman1(Hyman1 hyman) {

		String sql = "insert into hyman1(myname,age) values(?,?)";
		int m = 0;
		try {
			con = DbUtil.connect();
			pst = con.prepareStatement(sql);
			pst.setString(1, hyman.getMyname());
			pst.setInt(2, hyman.getAge());
			con.setAutoCommit(false);
			m = pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtil.free(con, pst, null);
		}

		return m;
	}

	@Override
	public int deleteHyman1(String name) {
		con = DbUtil.connect();

		String sql = "delete from hyman1 where myname = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			con.setAutoCommit(false);
			resultNum = pst.executeUpdate();
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.free(con, pst, null);
		}
		return resultNum;
	}

	@Override
	public int updateHyman1(Hyman1 hyman) {
		con = DbUtil.connect();

		String sql = "update hyman1 set age = 100 where myname = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, hyman.getMyname());
			con.setAutoCommit(false);
			resultNum = pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.free(con, pst, null);
		}

		return resultNum;
	}

	@Override
	public List<Hyman1> showAllHyman1() {

		con = DbUtil.connect();
		List<Hyman1> hymanList = new ArrayList<Hyman1>();

		String sql = "select * from hyman1";
		ResultSet rs = null;

		try {
			pst = con.prepareStatement(sql);
//			pst.setString(1, hyman.getMyname());
//			con.setAutoCommit(false);
			rs = pst.executeQuery();
//			con.commit();
			while(rs.next()){
				hymanList.add(new Hyman1(rs.getString("myname"), rs.getInt("age")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.free(con, pst, rs);
		}

		return hymanList;
	}

}
