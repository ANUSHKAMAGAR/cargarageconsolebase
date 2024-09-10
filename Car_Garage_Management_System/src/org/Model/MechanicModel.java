package org.Model;

public class MechanicModel {
private String mname;
private String spec;
private String exp;
public MechanicModel() {
	
}
public MechanicModel(String mname,String spec,String exp) {
	this.mname=mname;
	this.spec=spec;
	this.exp=exp;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getSpec() {
	return spec;
}
public void setSpec(String spec) {
	this.spec = spec;
}
public String getExp() {
	return exp;
}
public void setPrice(String exp) {
	this.exp = exp;
}
}
