package org.Model;

public class VehicleModel {
private String vname;
private String model;
private String noplate;
private int id;
public VehicleModel() {
	
}
public VehicleModel(String vname,String model,String noplate) {
	this.vname=vname;
	this.model=model;
	this.noplate=noplate;
}
public String getVname() {
	return vname;
}
public void setVname(String vname) {
	this.vname = vname;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getNoplate() {
	return noplate;
}
public void setNoplate(String noplate) {
	this.noplate = noplate;
}
public void setId(int id) {
	this.id=id;
}
public int getId() {
	return 0;
}
}
