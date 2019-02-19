package com.car.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.car.connection.ConnectionClass;
import com.car.dao.*;
import com.car.pojo.PersonPojo;
import com.car.pojo.TransactionPojo;


public class TransactionDaoImpl implements TransactionDao {
	private static Logger logger=Logger.getLogger("TransactionDaoImpl");
	ConnectionClass con;
	Connection catchcon;
	@Override
	public boolean insertTransaction(TransactionPojo obj1) {
		
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(obj1);
			tx.commit();
			return true;
			
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			session.close();
		}
				
//		boolean result=false;
//		try
//		{
//			con=new ConnectionClass();
//		    catchcon =con.connReturn();	
//		    catchcon.setAutoCommit(false);
//		    
//		    PreparedStatement ps=catchcon.prepareStatement("insert into fantastic5_transaction values(?,?,?)");
//		    ps.setInt(1,obj1.getTempPId());
//	        ps.setInt(2,obj1.getrId());
//	        ps.setString(3,obj1.getStatus());
//	        	           
//	        int row=ps.executeUpdate();
//	        if(row>0)
//	        {
//	        	 
//	        	   result=true;
//	        }
//	        else
//	        {
//	        	   System.out.println("There was some error");
//	        	   result=false;
//	        }
//		}
//		
//		catch(SQLException e)
//		{
//			System.out.println("There is sql exception");
//		}
//		finally{
//			try
//			{
//			   catchcon.close();
//			}
//			catch(SQLException e)
//			{
//				System.out.println("There was problem in close connection(Transaction)");
//			}
//		}
//       return result;
	}
	@Override
	public boolean deleteTransaction(int pId, int rId) {
		boolean result=false;
		try
		{
			con=new ConnectionClass();
		    catchcon =con.connReturn();	
		    catchcon.setAutoCommit(false);
		    
		    PreparedStatement ps=catchcon.prepareStatement("delete from fantastic5_transaction where pid=? and rid=?");
		    ps.setInt(1,pId);
	        ps.setInt(2,rId);
	      	           
	        int row=ps.executeUpdate();
//	        System.out.println("Row "+row);
	        if(row>0)
	        {
	        	   result=true;
	        	   
	        }
	        else
	        {
	        	  result=false;
	        	   
	        }
		}
		
		catch(SQLException e)
		{
			System.out.println("There is sql exception");
		}
		finally{
			try
			{
			   catchcon.close();
			   
			}
			catch(SQLException e)
			{
				System.out.println("There was problem in close connection(Transaction)");
			}
		}
		return result;
	}

//	@Override
//	public boolean deleteTransaction(int pId, int rId) {
//		File f2=new File("Temp.dat");
//		
//		try{
//			
//			fos=new FileOutputStream(f2);
//
//			oos=new ObjectOutputStream(fos);
//			fis=new FileInputStream(f);
//			ois=new ObjectInputStream(fis);
//			while(fis.available()>0)
//			{
//				TransactionPojo tp = new TransactionPojo();
//				tp=(TransactionPojo) ois.readObject();
//				if((tp.getTempPId()==pId)&&tp.getrId()==rId)
//				{
//					
//				}
//				else
//				{
//					oos.writeObject(tp);
//					logger.info("transaction File entry is deleted");
//					return false;
//				}
//			}
//			oos.close();
//			ois.close();
//			fis.close();
//			fos.close();
//			
//			String name = f.getName();
//			f.delete();
//			f2.renameTo(new File(name));
//		}
//		catch(FileNotFoundException e){
//			logger.trace("transaction File Not Found",e);
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		catch (IOException e)
//		{
//			System.out.println("deleteCategory "+e.getMessage());
//			return false;
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println("deleteCategory "+e.getMessage());
//			return false;
//			//	e.printStackTrace();
//
//		}
//
//
//
//		return true;
//	}
//	
	public void listTransaction()
	{
		boolean result=false;
		try
		{
			con=new ConnectionClass();
		    catchcon =con.connReturn();	
		    catchcon.setAutoCommit(false);
		    
		    Statement stmt=catchcon.createStatement();       
	        ResultSet rs=stmt.executeQuery("select * from fantastic5_transaction");
	        while(rs.next())
	        {
	        	System.out.println("PID : "+rs.getInt("PID")+" RID : "+rs.getInt("RID")+" STATUS : "+rs.getString("STATUS"));
	        }
		}
		
		catch(SQLException e)
		{
			System.out.println("There is sql exception");
		}
		finally{
			try
			{
			   catchcon.close();
			   
			}
			catch(SQLException e)
			{
				System.out.println("There was problem in close connection(Transaction)");
			}
		}
		
	}

	
	
	
	

}
