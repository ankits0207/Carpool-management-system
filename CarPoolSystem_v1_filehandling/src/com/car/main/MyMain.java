package com.car.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.car.businesslogic.Login;
import com.car.businesslogic.RideHandling;
import com.car.daoImpl.*;
import com.car.pojo.*;

public class MyMain {

	static int rid=1001;
	public static void main(String[] args) {
		
		int key;
		String ch;
		int dist,totseats,costperkm;
		Scanner sc = new java.util.Scanner(System.in);
		
		RideHandling objnew=new RideHandling();
		TransactionDaoImpl ooo = new TransactionDaoImpl();
		RideDaoImpl xxx=new RideDaoImpl();

		
		Login obj = new Login();
		
		while(true){
		System.out.println("Press 1 for NEW USER ");
		System.out.println("Press 2 for EXISTING USER");
		key = sc.nextInt();
		switch (key) {
		case 1:
			obj.insert();
			break;
			
		case 2:
			if(obj.search()){
				System.out.println("Login Successful");
				System.out.println("For GIVER press 1");
				System.out.println("For REQUESTER press 2");
				key = sc.nextInt();
				
				switch (key) {
				case 1:
					objnew.insertRide();
					obj.insertTransG(rid);
					rid++;
					ArrayList<TransactionPojo> al1 =new ArrayList<TransactionPojo>();
						al1=ooo.listEmp();
						for(TransactionPojo tp:al1)
						{
							System.out.println("Status : "+tp.getStatus()+" RID : "+tp.getrId()+" PID : "+tp.getTempPId());
						}
					break;
				case 2:
					System.out.println("1.SEARCH A RIDE\n2.CANCEL A RIDE");
					key=sc.nextInt();
					switch (key) {
					case 1:
						obj.displayRide();
						System.out.println("Do you wish to book?(Y/N)");
						ch=sc.next();
						if(ch.equals("Y"))
						{	System.out.println("Enter ride id");
							int rideId=sc.nextInt();
							obj.insertTrans(rideId);
							xxx.updateRide(rideId);
							
						}
						else
						{
							System.exit(0);
						}
						break;
					case 2:
						System.out.println("Enter ride id");
						int r=sc.nextInt();
						obj.delTrans(r);
						obj.updateRideC(r);
                        ArrayList<TransactionPojo> al2 =new ArrayList<TransactionPojo>();
						al2=ooo.listEmp();
						for(TransactionPojo tp:al2)
						{
							System.out.println("Status : "+tp.getStatus()+" RID : "+tp.getrId()+" PID : "+tp.getTempPId());
						}
						
						
						break;
					
					default:
						break;
					}
					break;

				default:
					break;
				}
			}
			else{
				System.out.println("Wrong Details");
			}
			break;

		default:
			break;
		}
		}
	}
}
		
		
		
		
//=============================================================
//		//int key;
//		String name,phno,password;
//		
//		int upid;
//		String pwd;
//
//		int dist,totseats,costperkm;
//		String carName,src,dest,date;
//		
//			
//		PersonDaoImpl o2=new PersonDaoImpl();
//		RideDaoImpl o5=new RideDaoImpl();
//
//	
//		while(true)
//		{
//			System.out.println("1.Insert person\n2.Search person\n3.Insert Ride\n4.Search Ride");
//			Scanner sc = new java.util.Scanner(System.in);
//			key = sc.nextInt();
//		switch (key) {
//		case 1:
//		PersonPojo o1=new PersonPojo();
//			System.out.println("Enter name,contact number and password");
//			name=sc.next();
//			phno=sc.next();
//			password=sc.next();
//			o1.setpId(pid);
//			o1.setName(name);
//			o1.setContactNo(phno);
//			o1.setPassword(password);
//			o2.insertPerson(o1);
//			pid++;
//			System.out.println("You Unique user id is "+pid);
//			break;
//		case 2:
//			PersonPojo o3 = new PersonPojo();
//			System.out.println("Enter pid and password");
//			upid=sc.nextInt();
//			pwd=sc.next();
//			o3=o2.searchPerson(upid, pwd);
//			if(o3==null)
//			{
//				System.out.println("Not Found");
//			}
//			else 
//			{
//				System.out.println("Found");
//			}
//			break;
//		case 3:
//			RidePojo o4=new RidePojo();
//			System.out.println("Enter Car name,Source,Destination,Date,distance,Total seats and cost per km");
//			carName=sc.next();
//			src=sc.next();
//			dest=sc.next();
//			date=(String)sc.next();
//			dist=sc.nextInt();
//			totseats=sc.nextInt();
//			costperkm=sc.nextInt();
//			o4.setrId(rid);
//			o4.setCarName(carName);
//			o4.setPickUpPoint(src);
//			o4.setDestination(dest);
//			o4.setDate(date);
//			o4.setDistance(dist);
//			o4.setTotalSeats(totseats);
//			o4.setCostPerKm(costperkm);
//			o5.insertRide(o4);
//			rid++;
//			System.out.println("Successful");
//			break;
//		case 4:
			
//				
//			}
//			break;
//		default:
//			break;
//		}
//		}
//		
//	}

//}
