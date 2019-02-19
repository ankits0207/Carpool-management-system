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
import com.car.pojo.TransactionPojo;


public class TransactionDaoImpl implements TransactionDao {

	File f = new File("Transaction.dat");
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	@Override
	public boolean insertTransaction(TransactionPojo obj1) {
		
		try{
			if(f.exists()){
			fos=new FileOutputStream(f,true);
			oos=new ObjectOutputStream(fos){
			
			@Override
				public void writeStreamHeader()
				{
					try 
					{
						reset();
					} 
					catch(IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			}
			else
			{
				fos=new FileOutputStream(f,true);
				oos=new ObjectOutputStream(fos);
					
			}
			oos.writeObject(obj1);
		}
		catch(Exception e)
		{
			System.out.println("addCategory " +e.getMessage());
			return false;
		}
		finally{
			try{
				oos.close();
				fos.close();
				
			}
			catch(IOException e){
				//e.printStackTrace();
				System.out.println("addCategory"+e.getMessage());
				return false;
			}
		}


		return true;
	}

	@Override
	public boolean deleteTransaction(int pId, int rId) {
		File f2=new File("Temp.dat");
		
		try{
			
			fos=new FileOutputStream(f2);

			oos=new ObjectOutputStream(fos);
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			while(fis.available()>0)
			{
				TransactionPojo tp = new TransactionPojo();
				tp=(TransactionPojo) ois.readObject();
				if((tp.getTempPId()==pId)&&tp.getrId()==rId)
				{
					
				}
				else
				{
					oos.writeObject(tp);
				}
			}
			oos.close();
			ois.close();
			fis.close();
			fos.close();
			
			String name = f.getName();
			f.delete();
			f2.renameTo(new File(name));
		}
		catch (IOException e)
		{
			System.out.println("deleteCategory "+e.getMessage());
			return false;
		}
		catch(ClassNotFoundException e) {
			System.out.println("deleteCategory "+e.getMessage());
			return false;
			//	e.printStackTrace();

		}



		return true;
	}
	
	public ArrayList<TransactionPojo> listEmp()
	{
		  ArrayList<TransactionPojo> al=null;
		   try
	       {   al= new ArrayList<TransactionPojo>();
	    	   fis = new FileInputStream(f);
	    	   ois = new ObjectInputStream(fis);
	    	   
	    	   TransactionPojo ob = new TransactionPojo();
	    	   while(fis.available()>0)
	    	   {
	    		 ob=(TransactionPojo)ois.readObject();  
	    	     al.add(ob);
	    	   }
	    	   
	    	   fis.close();
	    	   ois.close();
	    
	       }
	       catch(IOException e)
	       {
	    	   e.printStackTrace();
	       }
		   catch(ClassNotFoundException e)
		   {
			   e.printStackTrace();
		   }
		   
		   return al;
		   
	   }

	
	
	
	

}
