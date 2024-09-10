package org.Model;

import java.util.Date;

public class ServiceModel {
private Date sdate;
private int scharge;
private String distance;
public ServiceModel() {
	
}
public ServiceModel(Date sdate,int scharge,String distance) {
	this.sdate=sdate;
	this.scharge=scharge;
	this.distance=distance;
}
public Date getSdate() {
	return sdate;
}
public void setSdate(Date sdate) {
	this.sdate = sdate;
}
public int getScharge() {
	return scharge;
}
public void setScharge(int scharge) {
	this.scharge = scharge;
}
public String getDistance() {
	return distance;
}
public void setDistance(String distance) {
	this.distance = distance;
}
}
