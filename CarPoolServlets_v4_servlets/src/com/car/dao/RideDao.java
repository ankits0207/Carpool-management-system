package com.car.dao;

import java.util.ArrayList;
import java.util.List;

import com.car.pojo.RidePojo;

public interface RideDao {

	boolean insertRide(RidePojo obj1);
	ArrayList<RidePojo> displayAll();
	boolean updateRideB(int rid);
	boolean updateRideC(int rid);
}
