package com.car.daoImpl;
import com.car.connection.ConnectionClass;
import com.car.dao.*;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.car.pojo.PersonPojo;

public class PersonDaoImpl implements PersonDao {
	
	private static Logger personlogger=Logger.getLogger("PersonDaoImpl");
	//File file=new File("Person.txt");
	Connection conncatch=ConnectionClass.connReturn();
	@Override
	public PersonPojo searchPerson(int pId, String password) {
		PersonPojo per=new PersonPojo();
		try{
		conncatch.setAutoCommit(false);
		PreparedStatement pstmtn=conncatch.prepareStatement("select * from FANTASTIC5_PERSON where PID=? AND PWD=?");
		pstmtn.setInt(1, pId);
		pstmtn.setString(2, password);
		pstmtn.executeQuery();
		ResultSet rs = pstmtn.executeQuery();
		while(rs.next())
		{
			per.setpId(rs.getInt("PID"));
			per.setName(rs.getString("NAME"));
			per.setContactNo(rs.getString("PHNO"));
			per.setPassword(rs.getString("PWD"));
			return per;

		}
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}
//		try {
//			conncatch.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return null;
	}
		
		
		
		
		
		
//		FileInputStream fis = null;
//		ObjectInputStream ois = null;
//		try
//		{	
//			fis=new FileInputStream(file);
//			ois=new ObjectInputStream(fis);
//			while(fis.available()>0)
//			{
//				per=(PersonPojo) ois.readObject();
//				if((per.getpId()==pId)&&(per.getPassword().equals(password)))
//					return per;
//				 personlogger.info("user authentication requested");
//			}
//			
//		} 
//		
//		catch(FileNotFoundException e){
//			personlogger.trace("person File Not Found",e);
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
//			personlogger.info("generic catch in person dao impl called");
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		
//		finally
//		{
//			try {
//				ois.close();
//				fis.close();
//			} 
//			
//			catch(FileNotFoundException e){
//				personlogger.trace("File Not Found",e);
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			catch(IOException e){
//				System.out.println(e.getMessage());
//				System.exit(0);
//			}
//			
//		}
//			
//		
//		return null;
	
	@Override
	public int insertPerson(PersonPojo obj1) {
		int temp_pid=0;
		
		PersonPojo per=new PersonPojo();
		per.setpId(obj1.getpId());
		per.setName(obj1.getName());
		per.setContactNo(obj1.getContactNo());
		per.setPassword(obj1.getPassword());
		try{
		PreparedStatement pstmtn=conncatch.prepareStatement("select MAX(PID) from FANTASTIC5_PERSON");
		pstmtn.executeQuery();
		ResultSet rs = pstmtn.executeQuery();
		while(rs.next())
		{
			temp_pid=rs.getInt("MAX(PID)");
		}
		if(temp_pid==0)
		{
			temp_pid=100;
		}
		PreparedStatement pstmt=conncatch.prepareStatement("insert into FANTASTIC5_PERSON values(?,?,?,?)");
		pstmt.setInt(1,(temp_pid+1));
		pstmt.setString(2, per.getName());
		pstmt.setString(3, per.getContactNo());
		pstmt.setString(4, per.getPassword());
		int rows=pstmt.executeUpdate();
		if(rows>0)
		{
				
		}
		else
		{
				return 0;		}
				
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return temp_pid+1;
		
	}
}
	
//	@Ovveride
//	public boolean insertPerson(PersonPojo obj1)
//	{
//		
//				PersonPojo per=new PersonPojo();
//				per=obj1;
//				File file = new File("Person.txt");
//				FileOutputStream fos=null;
//				ObjectOutputStream oos=null;
//				try{
//					if(file.exists()){
//					fos=new FileOutputStream(file,true);
//					oos=new ObjectOutputStream(fos){
//					
//					@Override
//						public void writeStreamHeader()
//						{
//							try {
//								reset();
//							} catch (IOException e) {
//								
//								e.printStackTrace();
//							}
//						}
//					};
//					}
//					else
//					{
//						fos=new FileOutputStream(file,true);
//						oos=new ObjectOutputStream(fos);
//							
//					}
//					oos.writeObject(per);
//					return true;
//					
//				}
//				catch(FileNotFoundException e){
//					System.out.println(e.getMessage());
//					System.exit(0);
//				}
//				catch(IOException e){
//					System.out.println(e.getMessage());
//					System.exit(0);
//				}
//				catch(Exception e)
//				{
//					System.out.println(e.getMessage());
//					System.exit(0);
//				}
//				finally{
//					try{
//						oos.close();
//						fos.close();
//					}
//					catch(FileNotFoundException e){
//						System.out.println(e.getMessage());
//						System.exit(0);
//					}
//					catch(IOException e){
//						System.out.println(e.getMessage());
//			
//					}
//				}
//				return true;
//	}
	



