package com.car.dao;

import javax.persistence.Entity;

import com.car.pojo.PersonPojo;

public interface PersonDao {
	
	boolean insertPerson(PersonPojo obj1);

	PersonPojo searchPerson(int pId , String password);
}
