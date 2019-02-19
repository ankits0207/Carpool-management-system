package com.car.dao;

import com.car.pojo.PersonPojo;


public interface PersonDao {

	void insertPerson(PersonPojo obj1);
	
	PersonPojo searchPerson(int pId , String password);
}
