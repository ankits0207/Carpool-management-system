package com.car.daoImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.car.dao.*;
import com.car.pojo.RidePojo;
import com.car.pojo.TransactionPojo;

public class RideDaoImpl implements RideDao {

	File file=new File("Ride.txt");
	@Override
	public void insertRide(RidePojo obj1) {
		
		RidePojo ride=new RidePojo();
		ride=obj1;
		File file = new File("Ride.txt");
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try{
			if(file.exists()){
			fos=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fos){
			
		
				public void writeStreamHeader()
				{
					try {
						reset();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			};
			}
			else
			{
				fos=new FileOutputStream(file,true);
				oos=new ObjectOutputStream(fos);
					
			}
			oos.writeObject(ride);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
	
		}
		finally{
			try{
				oos.close();
				fos.close();
			}
			catch(IOException e){
				System.out.println(e.getMessage());
	
			}
		}		
	}
	
	@Override
	public ArrayList<RidePojo> displayAll() {
		File file=new File("Ride.txt");
		FileInputStream fis=null;
		ArrayList<RidePojo> allRides=new ArrayList<RidePojo>();
		ObjectInputStream ois=null;
		try{
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			while(fis.available()>0){
				allRides.add((RidePojo)ois.readObject());
			}
			return allRides;
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			try{
				ois.close();
				fis.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean updateRide(int rid) {
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
					{r1.setSeatsAvailable((r1.getSeatsAvailable()-1));
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
		
	

}
