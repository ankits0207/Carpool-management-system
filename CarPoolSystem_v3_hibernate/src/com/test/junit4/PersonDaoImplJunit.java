package com.test.junit4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.car.daoImpl.PersonDaoImpl;
import com.car.pojo.PersonPojo;


public class PersonDaoImplJunit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertPersonPositive()
	{	
		PersonPojo obj=new PersonPojo();
		PersonDaoImpl pdio=new PersonDaoImpl();
		obj.setpId(101);
		obj.setName("Ankit");
		obj.setContactNo("9999600207");
		obj.setPassword("qwerty");
		assertEquals(true, pdio.insertPerson(obj));
	}
	@Test
	public void testSearchPersonPositive() {
		PersonPojo ppo=new PersonPojo(101, "Ankit", "9999600207", "qwerty");
		PersonDaoImpl pdio=new PersonDaoImpl();
		assertEquals(ppo,pdio.searchPerson(101, "qwerty"));
	}
	@Test
	public void testSearchPersonNegative() {
		PersonPojo ppo=new PersonPojo(101, "Ankit", "9999600207", "qwerty");
		PersonDaoImpl pdio=new PersonDaoImpl();
		assertEquals(null,pdio.searchPerson(102, "qwerty"));
	}
}
