package com.car.dao;

import com.car.pojo.TransactionPojo;

public interface TransactionDao {

	boolean insertTransaction(TransactionPojo obj1);
	
	boolean deleteTransaction(int pId , int rId);
	
}
