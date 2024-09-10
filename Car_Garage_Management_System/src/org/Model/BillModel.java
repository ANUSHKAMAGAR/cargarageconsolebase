package org.Model;

import java.util.Date;

public class BillModel {
	private int id;
	private int totalAmount;
	private Date bdate;
	private ServiceModel smodel;
	public ServiceModel getService() {
		return smodel;
	}
	public void setService(ServiceModel smodel)
	{
		this.smodel=smodel;
	}
	public BillModel() {
		
	}
	public BillModel(int totalAmount,Date bdate) {
		this.totalAmount=totalAmount;
		this.bdate=bdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
}
