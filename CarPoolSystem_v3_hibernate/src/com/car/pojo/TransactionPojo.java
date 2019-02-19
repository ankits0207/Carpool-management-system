package com.car.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="FANTASTIC5_TRANSACTION_E3423")
public class TransactionPojo implements Serializable {
	@Id
	@Column(name="PID")
	private int tempPId;
	@Column(name="RID")
	private int rId;
	@Column(name="STATUS")
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
