package com.car.daoImpl;
import com.car.dao.*;

import java.io.*;

import com.car.pojo.PersonPojo;

public class PersonDaoImpl implements PersonDao {
	
	File file=new File("Person.txt");
	@Override
	public PersonPojo searchPerson(int pId, String password) {
		PersonPojo per=new PersonPojo();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try
		{	
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			while(fis.available()>0)
			{
				per=(PersonPojo) ois.readObject();
				if((per.getpId()==pId)&&(per.getPassword().equals(password)))
					return per;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		
		return null;
	}
	@Override
	public void insertPerson(PersonPojo obj1) {
		// TODO Auto-generated method stub
		PersonPojo per=new PersonPojo();
		per=obj1;
		File file = new File("Person.txt");
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try{
			if(file.exists()){
			fos=new FileOutputStream(file,true);
			oos=new ObjectOutputStream(fos){
			
			@Override
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
			oos.writeObject(per);
			
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
}


