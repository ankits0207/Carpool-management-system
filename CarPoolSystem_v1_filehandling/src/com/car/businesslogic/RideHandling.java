package com.car.businesslogic;

import java.util.Scanner;

import com.car.daoImpl.RideDaoImpl;
import com.car.pojo.RidePojo;

public class RideHandling {
	
	static int rid=1001;
	RideDaoImpl o5=new RideDaoImpl();

	
	Scanner sc=new Scanner(System.in);
	int dist,totseats,costperkm,avseats;
	String carName,src,dest,date;
	public void insertRide(){
		RidePojo o4=new RidePojo();
		System.out.println("Enter Car name,Source,Destination,distance,Total seats and cost per km");
		carName=sc.next();
		src=sc.next();
		dest=sc.next();
//		date=(String)sc.next();
		dist=sc.nextInt();
		totseats=sc.nextInt();
		costperkm=sc.nextInt();
		o4.setrId(rid);
		o4.setCarName(carName);
		o4.setPickUpPoint(src);
		o4.setDestination(dest);
//		o4.setDate(date);
		o4.setDistance(dist);
		o4.setTotalSeats(totseats);
		o4.setCostPerKm(costperkm);
		o4.setSeatsAvailable(totseats);
		o5.insertRide(o4);
		rid++;
		System.out.println("Successful");
	}
	
	public void insertTransaction()
	{
		
		
		
		
	}

}
