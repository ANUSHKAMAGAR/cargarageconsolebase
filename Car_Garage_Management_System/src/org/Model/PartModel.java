package org.Model;

public class PartModel {
	private String pname;
	private int price;
	private ServiceModel smodel;
	public ServiceModel getService() {
		return smodel;
	}
	public void setService(ServiceModel smodel)
	{
		this.smodel=smodel;
	}
	public PartModel() {
		
	}
	public PartModel(String pname,int price) {
		this.pname=pname;
		this.price=price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
