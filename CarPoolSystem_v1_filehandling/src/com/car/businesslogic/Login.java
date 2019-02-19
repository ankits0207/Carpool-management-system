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

public class Login {
	
	static int pid=101;

	String name,phno,password;
	
	int upid;
	String pwd;
	
	Scanner sc = new java.util.Scanner(System.in);
	RideDaoImpl newobj=new RideDaoImpl();

	
	public void insert(){
		
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
		System.out.println("You Unique user id is "+pid);
		pid++;
		
		
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
		ArrayList<RidePojo> allRides=new ArrayList<RidePojo>();
		allRides=newobj.displayAll();
		System.out.println("List of all rides is: ");
		for(RidePojo p:allRides){
		System.out.println(p);
	}
	

	}
	
	public void insertTrans(int r)
	{
		System.out.println("Please Enter Transaction details");
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
		System.out.println("Please Enter Transaction details");
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
	
	public boolean updateRideC(int rid) {
		File file=new File("Ride.txt");
		File file2=new File("temp.txt");
		RidePojo r1;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		try{
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			fos=new FileOutputStream(file2);
			oos=new ObjectOutputStream(fos);
			while(fis.available()>0){
				r1=(RidePojo)ois.readObject();
				if(r1.getSeatsAvailable()==0)
				{
					System.out.println("No seats available");
					return false;
				}
				else if(r1.getrId()==rid)
				{r1.setSeatsAvailable((r1.getSeatsAvailable()+1));
					oos.writeObject(r1);
				}
				else
					oos.writeObject(r1);
				}	
				oos.close();
				ois.close();
				fis.close();
				fos.close();
				String name1 = file.getName();
				file.delete();
				file2.renameTo(new File(name1));
			
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return false;

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
	
	
	

	
	
}