package com.teachercode.jdbc.test.dao.impl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.teachercode.jdbc.dao.Hyman1Dao;
import com.teachercode.jdbc.dao.impl.Hyman1DaoImpl;
import com.teachercode.jdbc.po.Hyman1;

public class Hyman1DaoImplTest {
	
	private Hyman1Dao dao = new Hyman1DaoImpl();

	@Test
	public void testAddHyman1() {
		int m = dao.addHyman1(new Hyman1("hyman14",1));
		Assert.assertTrue(m==1);
	}

	@Test
	public void testDeleteHyman1() {
		int m = dao.deleteHyman1("hyman1");
		Assert.assertTrue(m>=1);
	}

	@Test
	public void testUpdateHyman1() {
		int m = dao.updateHyman1(new Hyman1("hyman100", 111));
		System.out.println(m);
		Assert.assertTrue(m>=1);
	}

	@Test
	public void testShowAllHyman1() {
		fail("Not yet implemented");
	}

}
