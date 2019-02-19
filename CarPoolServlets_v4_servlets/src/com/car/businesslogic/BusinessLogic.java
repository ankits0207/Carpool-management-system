	package com.car.businesslogic;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;
	import java.util.Scanner;

	import com.car.daoImpl.PersonDaoImpl;
	import com.car.daoImpl.RideDaoImpl;
	import com.car.daoImpl.TransactionDaoImpl;
	import com.car.pojo.PersonPojo;
	import com.car.pojo.RidePojo;
	import com.car.pojo.TransactionPojo;

public class BusinessLogic {

		
		int pid=0,rid=0;
		

		String name,phno,password;
		
		int upid;
		String pwd;
		
		int dist,totseats,costperkm,avseats;
		String carName,src,dest,date;
		
		Scanner sc = new java.util.Scanner(System.in);
		RideDaoImpl newobj=new RideDaoImpl();

		RideDaoImpl o5=new RideDaoImpl();

		
		public int insertPersonRegister(String name,String phno,String pwd){
			
			PersonPojo o1=new PersonPojo();
			PersonDaoImpl o2=new PersonDaoImpl();
			o1.setpId(pid);
			o1.setName(name);
			o1.setContactNo(phno);
			o1.setPassword(pwd);
			int i=o2.insertPerson(o1);
			return i;
			
			
			
		}
		
		public boolean search(int u,String p){
			
			PersonPojo o3 = new PersonPojo();
			PersonDaoImpl o2=new PersonDaoImpl();
			o3=o2.searchPerson(u,p);
			if(o3==null)
			{
				return false;
			}
			else 
			{
				return true;
			}
		}
		
		public ArrayList<RidePojo> displayRide()
		{
			ArrayList<RidePojo> rideList=new ArrayList<RidePojo>();
			rideList=newobj.displayAll();
			return rideList;
		}
		

		
		
		public int insertTransR(int r,int p)
		{
			String status="R";
			TransactionPojo tp =new TransactionPojo(p,r,status);
			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
			boolean x=tdimpl.insertTransaction(tp);
			if(x)
			{
				
			}
			else
			{
				return 0;
			}
			return 1;
		}
		
//		public int insertTransG(int r,int p)
//		{
//			String status="G";
//			TransactionPojo tp =new TransactionPojo(p,r,status);
//			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
//			boolean x=tdimpl.insertTransaction(tp);
//			if(x)
//			{
//			}
//			else
//			{
//				return 0;			
//			}
//			return 1;
//		}
//		
		
		public int delTrans(int r,int p)
		{
			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
			boolean x=tdimpl.deleteTransaction(p, r);
			if(x)
			{
				
			}
			else
			{
				return 0;
			}
			return 1;
		}
		
		
		public int insertRide(String carName,String src,String dest,int dist,int totseats,int costperkm){
			RidePojo o4=new RidePojo();
			int k=rid;
			o4.setrId(rid);
			o4.setCarName(carName);
			o4.setPickUpPoint(src);
			o4.setDestination(dest);
			o4.setDistance(dist);
			o4.setTotalSeats(totseats);
			o4.setCostPerKm(costperkm);
			o4.setSeatsAvailable(totseats);
			o5.insertRide(o4);
			return k;
		}

		
		

		
		
	}
	
	
	
	

