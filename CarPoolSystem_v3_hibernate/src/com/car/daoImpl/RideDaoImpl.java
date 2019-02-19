package com.car.daoImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.car.connection.ConnectionClass;
import com.car.dao.*;
import com.car.pojo.PersonPojo;
import com.car.pojo.RidePojo;
import com.car.pojo.TransactionPojo;

public class RideDaoImpl implements RideDao {
	ConnectionClass conn=new ConnectionClass();
	private static Logger logger=Logger.getLogger("RideDaoImpl");

	//File file=new File("Ride.txt");
	@Override
	public void insertRide(RidePojo obj1) {
		
		int temp_rid=0;
		Connection conncatch;
		conncatch=conn.connReturn();
		RidePojo ride=new RidePojo();
		ride.setrId(obj1.getrId());
		ride.setCarName(obj1.getCarName());
		ride.setPickUpPoint(obj1.getPickUpPoint());
		ride.setDestination(obj1.getDestination());
		ride.setDistance(obj1.getDistance());
		ride.setTotalSeats(obj1.getTotalSeats());
		ride.setCostPerKm(obj1.getCostPerKm());
		ride.setSeatsAvailable(obj1.getTotalSeats());
		try{
		PreparedStatement pstmtn=conncatch.prepareStatement("select MAX(RID) from FANTASTIC5_RIDE");
		pstmtn.executeQuery();
		ResultSet rs = pstmtn.executeQuery();
		while(rs.next())
		{
			temp_rid=rs.getInt("MAX(RID)");
			if(temp_rid==0)
			{
				temp_rid=1000;
			}
			temp_rid=temp_rid+1;
		}
		PreparedStatement pstmt=conncatch.prepareStatement("insert into FANTASTIC5_RIDE values(?,?,?,?,?,?,?,?)");
		pstmt.setInt(1,(temp_rid));
		pstmt.setString(2, ride.getCarName());
		pstmt.setString(3, ride.getPickUpPoint());
		pstmt.setString(4, ride.getDestination());
		pstmt.setInt(5, ride.getDistance());
		pstmt.setInt(6, ride.getSeatsAvailable());
		pstmt.setInt(7, ride.getTotalSeats());
		pstmt.setInt(8, ride.getCostPerKm());
		
		
		int rows=pstmt.executeUpdate();
		if(rows>0)
		{
				System.out.println(rows+" Records inserted");
				System.out.println("Unique Rid is "+(temp_rid));

		}
		else
		{
				System.out.println("Insert failed");
		}
				
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
//		RidePojo ride=new RidePojo();
//		ride=obj1;
//		File file = new File("Ride.txt");
//		FileOutputStream fos=null;
//		ObjectOutputStream oos=null;
//		try{
//			if(file.exists()){
//			fos=new FileOutputStream(file,true);
//			oos=new ObjectOutputStream(fos){
//			
//		
//				public void writeStreamHeader()
//				{
//					try {
//						reset();
//					} catch (IOException e) {
//						System.out.println("io exception occured");
//						logger.info("io exception in ride dao impl ");
//					}
//				}
//			};
//			}
//			else
//			{
//				fos=new FileOutputStream(file,true);
//				oos=new ObjectOutputStream(fos);
//					
//			}
//			oos.writeObject(ride);
//			 logger.info("new ride added ");
//			
//		}
//		
//		catch(FileNotFoundException e){
//			logger.trace("ride File Not Found",e);
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch(IOException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//			System.exit(0);
//	
//		}
//		finally{
//			try{
//				oos.close();
//				fos.close();
//			}
//			
//			catch(FileNotFoundException e){
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			catch(IOException e){
//				System.out.println(e.getMessage());
//				System.exit(0);
//	
//			}
//		}		
	}
	
	@Override
	public void displayAll() {
		RidePojo ride=new RidePojo();
		Connection conncatch;
		conncatch=conn.connReturn();
		try{
			conncatch.setAutoCommit(false);
			PreparedStatement pstmtn=conncatch.prepareStatement("select * from FANTASTIC5_RIDE");
			pstmtn.executeQuery();
			ResultSet rs = pstmtn.executeQuery();
			while(rs.next())
			{
				ride.setrId(rs.getInt("RID"));
				ride.setCarName(rs.getString("CNAME"));
				ride.setPickUpPoint(rs.getString("SRC"));
				ride.setDestination(rs.getString("DEST"));
				ride.setDistance(rs.getInt("DIST"));
				ride.setSeatsAvailable(rs.getInt("SEATSAVAIL"));
				ride.setTotalSeats(rs.getInt("SEATSTOT"));
				ride.setCostPerKm(rs.getInt("COSTPKM"));
				System.out.println("RID: "+ride.getrId()+" CAR_NAME: "+ride.getCarName()+" SOURCE: "+ride.getPickUpPoint()+" DEST: "+ride.getDestination()+" DISTANCE: "+ride.getDistance()+" SEATS_AVAILABLE: "+ride.getSeatsAvailable()+" TOTAL_SEATS: "+ride.getTotalSeats()+" COST_PER_KM "+ride.getCostPerKm());
			}
			
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}
		try {
			conncatch.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		File file=new File("Ride.txt");
//		FileInputStream fis=null;
//		ArrayList<RidePojo> allRides=new ArrayList<RidePojo>();
//		ObjectInputStream ois=null;
//		try{
//			fis=new FileInputStream(file);
//			ois=new ObjectInputStream(fis);
//			
//			while(fis.available()>0){
//				allRides.add((RidePojo)ois.readObject());
//			}
//			return allRides;
//			
//		}
//		catch(FileNotFoundException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch(IOException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch(ClassNotFoundException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		finally{
//			try{
//				ois.close();
//				fis.close();
//			}
//			
//			catch(FileNotFoundException e){
//					System.out.println(e.getMessage());
//					System.exit(0);
//			}
//			
//			catch(IOException e){
//					System.out.println(e.getMessage());
//					System.exit(0);
//			}
//			
//		}
//		
//		return null;
	}

	@Override
	public boolean updateRideB(int rid) {
		Connection conncatch;
		int temp=0;
		conncatch=conn.connReturn();
		try{
//			conncatch.setAutoCommit(false);
			PreparedStatement pstmtn1=conncatch.prepareStatement("SELECT SEATSAVAIL FROM FANTASTIC5_RIDE WHERE RID=?");
			pstmtn1.setInt(1, rid);
			pstmtn1.executeQuery();
			ResultSet rs = pstmtn1.executeQuery();
			if(rs.next())
			{
				temp=rs.getInt("SEATSAVAIL");
				if(temp==0)
				{
					System.out.println("No seats left");
					return false;
				}
				temp=temp-1;
			}
			PreparedStatement pstmtn2=conncatch.prepareStatement("UPDATE FANTASTIC5_RIDE SET SEATSAVAIL =? WHERE RID=?");
			pstmtn2.setInt(1, temp);
			pstmtn2.setInt(2, rid);
			pstmtn2.executeUpdate();
			
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			return false;
			
		}
		
		try {
			conncatch.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
//			File file=new File("Ride.txt");
//			File file2=new File("temp.txt");
//			RidePojo r1;
//			FileInputStream fis=null;
//			FileOutputStream fos=null;
//			ObjectInputStream ois=null;
//			ObjectOutputStream oos=null;
//			try{
//				fis=new FileInputStream(file);
//				ois=new ObjectInputStream(fis);
//				fos=new FileOutputStream(file2);
//				oos=new ObjectOutputStream(fos);
//				while(fis.available()>0){
//					r1=(RidePojo)ois.readObject();
//					if(r1.getSeatsAvailable()==0)
//					{
//						System.out.println("No seats available");
//						return false;
//					}
//					else if(r1.getrId()==rid)
//					{r1.setSeatsAvailable((r1.getSeatsAvailable()-1));
//						oos.writeObject(r1);
//						 logger.info(" ride booked ");
//						float cost = ((r1.getCostPerKm() * r1.getDistance())/ r1.getTotalSeats());
//						System.out.println("The Estimated Cost of your booking is :" + cost);
//					}
//					else
//						oos.writeObject(r1);
//					}	
//					oos.close();
//					ois.close();
//					fis.close();
//					fos.close();
//					String name1 = file.getName();
//					file.delete();
//					file2.renameTo(new File(name1));
//				
//				
//			}
//			catch(FileNotFoundException e){
//				logger.trace("ride File Not Found",e);
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			catch(ClassNotFoundException e){
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			catch(IOException e){
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			
//			return false;

		}
	
	public boolean updateRideC(int rid) {
		Connection conncatch;
		int temp=0;
		conncatch=conn.connReturn();
		try{
//			conncatch.setAutoCommit(false);
			PreparedStatement pstmtn1=conncatch.prepareStatement("SELECT SEATSAVAIL FROM FANTASTIC5_RIDE WHERE RID=?");
			pstmtn1.setInt(1, rid);
			pstmtn1.executeQuery();
			ResultSet rs = pstmtn1.executeQuery();
			if(rs.next())
			{
				temp=rs.getInt("SEATSAVAIL");
				temp=temp+1;
			}
			PreparedStatement pstmtn2=conncatch.prepareStatement("UPDATE FANTASTIC5_RIDE SET SEATSAVAIL =? WHERE RID=?");
			pstmtn2.setInt(1, temp);
			pstmtn2.setInt(2, rid);
			pstmtn2.executeUpdate();
			
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			return false;
			
		}
		
		try {
			conncatch.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
		
//		File file=new File("Ride.txt");
//		File file2=new File("temp.txt");
//		RidePojo r1;
//		FileInputStream fis=null;
//		FileOutputStream fos=null;
//		ObjectInputStream ois=null;
//		ObjectOutputStream oos=null;
//		try{
//			fis=new FileInputStream(file);
//			ois=new ObjectInputStream(fis);
//			fos=new FileOutputStream(file2);
//			oos=new ObjectOutputStream(fos);
//			while(fis.available()>0){
//				r1=(RidePojo)ois.readObject();
//				if(r1.getSeatsAvailable()==0)
//				{
//					System.out.println("No seats available");
//					return false;
//				}
//				else if(r1.getrId()==rid)
//				{r1.setSeatsAvailable((r1.getSeatsAvailable()+1));
//					oos.writeObject(r1);
//				}
//				else
//					oos.writeObject(r1);
//				}	
//				oos.close();
//				ois.close();
//				fis.close();
//				fos.close();
//				String name1 = file.getName();
//				file.delete();
//				file2.renameTo(new File(name1));
//			
//			
//		}
//		catch(FileNotFoundException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch(ClassNotFoundException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch(IOException e){
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		
//		return false;

	}
		
	

}
