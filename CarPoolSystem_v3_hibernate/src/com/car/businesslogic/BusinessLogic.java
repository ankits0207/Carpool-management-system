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

		
		public void insertPersonRegister(){
			
			PersonPojo o1=new PersonPojo();
			PersonDaoImpl o2=new PersonDaoImpl();
			System.out.println("Enter Name");
			name=sc.next();
			System.out.println("Enter your Contact Number");
			phno=sc.next();
			System.out.println("Enter your Password");
			password=sc.next();
			o1.setpId(pid);
			o1.setName(name);
			o1.setContactNo(phno);
			o1.setPassword(password);
			o2.insertPerson(o1);
			System.out.println("Your pid is: "+o1.getpId());
			
			
			
		}
		
		public boolean search(){
			
			PersonPojo o3 = new PersonPojo();
			PersonDaoImpl o2=new PersonDaoImpl();
			System.out.println("Enter pid and password");
			upid=sc.nextInt();
			pwd=sc.next();
			o3=o2.searchPerson(upid, pwd);
			if(o3==null)
			{
				//System.out.println("Not Found");
				return false;
			}
			else 
			{
				//System.out.println("Found");
				return true;
			}
		}
		
		public void displayRide()
		{
			System.out.println("List of all rides is: ");
			newobj.displayAll();
		
		}
		

		
		
		public void insertTransR(int r)
		{
			String status="R";
			System.out.println("Enter Person ID : ");
			int id= sc.nextInt();
			TransactionPojo tp =new TransactionPojo(id,r,status);
			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
			boolean x=tdimpl.insertTransaction(tp);
			if(x)
			{
				System.out.println("Successfully Inserted");
			}
			else
			{
				System.out.println("Not Successful");
			}
		}
		
		public void insertTransG(int r)
		{
			String status="G";
			System.out.println("Enter Person ID : ");
			int id= sc.nextInt();
			TransactionPojo tp =new TransactionPojo(id,r,status);
			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
			boolean x=tdimpl.insertTransaction(tp);
			if(x)
			{
				System.out.println("Successfully Inserted");
			}
			else
			{
				System.out.println("Not Successful");
			}
		}
		
		
		
		public void delTrans(int r)
		{
		
			System.out.println("Enter Person ID : ");
			int id= sc.nextInt();
			TransactionDaoImpl tdimpl = new TransactionDaoImpl();
			boolean x=tdimpl.deleteTransaction(id, r);
			if(x)
			{
				System.out.println("Transaction Successfully deleted");
			}
			else
			{
				System.out.println("Transaction not deleted");
			}
		}
		
		
		public void insertRide(){
			RidePojo o4=new RidePojo();
			System.out.println("Enter Car Name,Source,Destination,Distance,Total seats and Cost Per Km");
			carName=sc.next();
			src=sc.next();
			dest=sc.next();
			dist=sc.nextInt();
			totseats=sc.nextInt();
			costperkm=sc.nextInt();
			o4.setrId(rid);
			o4.setCarName(carName);
			o4.setPickUpPoint(src);
			o4.setDestination(dest);
			o4.setDistance(dist);
			o4.setTotalSeats(totseats);
			o4.setCostPerKm(costperkm);
			o4.setSeatsAvailable(totseats);
			o5.insertRide(o4);
			System.out.println("Successful");
		}

		
		

		
		
	}
	
	
	
	

