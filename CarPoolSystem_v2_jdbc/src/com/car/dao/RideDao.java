package com.car.dao;

import java.util.List;

import com.car.pojo.RidePojo;

public interface RideDao {

	void insertRide(RidePojo obj1);
	void displayAll();
	boolean updateRideB(int rid);
	boolean updateRideC(int rid);
}
