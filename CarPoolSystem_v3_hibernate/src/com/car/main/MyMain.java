package com.car.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.car.businesslogic.BusinessLogic;
import com.car.daoImpl.*;
import com.car.pojo.*;

public class MyMain {

	public static void main(String[] args) {
		boolean flag=true;
		int key;
		String ch;
		int dist,totseats,costperkm;
		Scanner sc = new java.util.Scanner(System.in);
		
		TransactionDaoImpl ooo = new TransactionDaoImpl();
		RideDaoImpl xxx=new RideDaoImpl();
		
		BusinessLogic obj = new BusinessLogic();
		
		while(flag){
		try{
		System.out.println("Press 1 for NEW USER ");
		System.out.println("Press 2 for EXISTING USER");
		key = sc.nextInt();
		switch (key) {
		case 1:
			obj.insertPersonRegister();
			break;
			
		case 2:
			if(obj.search()){
				System.out.println("Login Successful");
				System.out.println("For GIVER press 1");
				System.out.println("For REQUESTER press 2");
				key = sc.nextInt();
				
				switch (key) {
				case 1:
					obj.insertRide();
					System.out.println("ENTER RID");
					int ride_id=sc.nextInt();
					obj.insertTransG(ride_id);
					ooo.listTransaction();
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
							obj.insertTransR(rideId);
							xxx.updateRideB(rideId);
							
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
						xxx.updateRideC(r);
                        ooo.listTransaction();
						
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
			System.out.println("Enter either 1 or 2");
			break;
				}
			}
		catch(InputMismatchException ex)
		{
			System.out.println("Please Enter in correct format!!");
			flag=false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		}
	}
}
		
		
		
		
