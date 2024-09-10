package org.Model;

public class CustomerModel {
	private String cname;
	private String email;
	private String contact;
	private String address;
	private int id;
	public CustomerModel() {
		
	}
	public CustomerModel(String cname,String email,String contact,String address) {
		this.cname=cname;
		this.email=email;
		this.contact=contact;
		this.address=address;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return 0;
	}
}
