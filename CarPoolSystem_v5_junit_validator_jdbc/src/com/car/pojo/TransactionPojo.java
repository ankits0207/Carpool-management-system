package com.car.pojo;

import java.io.Serializable;

public class TransactionPojo implements Serializable {
	
	private int tempPId, rId;
	private String Status;
	
	public TransactionPojo()
	{
		
	}
	public TransactionPojo(int tempID,int rId, String status) {
		super();
		this.rId = rId;
		Status = status;
		this.tempPId = tempID;
	}

	public int getTempPId() {
		return tempPId;
	}

	public void setTempPId(int tempPId) {
		this.tempPId = tempPId;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	

}
