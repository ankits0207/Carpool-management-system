package com.car.dao;

import java.util.List;

import com.car.pojo.RidePojo;

public interface RideDao {

	void insertRide(RidePojo obj1);
	public List<RidePojo> displayAll();
	boolean updateRide(int rid);
}
