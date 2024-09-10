package org.Repository;

import java.sql.ResultSet;
import org.Model.CustomerModel;

public class CustomerRepository extends DBConn {
	public boolean isAddCustomer(CustomerModel cmodel ) {
		try {
			stmt=conn.prepareStatement("insert into customer values('0',?,?,?,?)");
			stmt.setString(1, cmodel.getCname());
			stmt.setString(2, cmodel.getEmail());
			stmt.setString(3,cmodel.getContact());
			stmt.setString(4, cmodel.getAddress());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddCustomer method in CustomerRepository"+ex);
		}
		return false;
	}
	public boolean isViewCustomer(CustomerModel cmodel) {
		try {
		stmt=conn.prepareStatement("select *from customer");
		ResultSet rs=stmt.executeQuery();
		System.out.println("id\tname\temail\t\t\tconatct\t\t\taddress\t");
		while(rs.next()) {
		int id=rs.getInt(1);
		String name=rs.getString(2);
		String email=rs.getString(3);
		String contact=rs.getString(4);
		String addreass=rs.getString(5);
		System.out.println(id+"\t"+name+"\t"+email+"\t\t"+contact+"\t\t"+addreass+"\t");
		   }
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isViewCustomer method in CustomerRepository"+ex);
		}
		return false;
	}
	public boolean isUpdateCustomer(int id,String name,String email,String contact,String address) {
		try {
		stmt=conn.prepareStatement("update customer set cname=?,email=?,contact=?,address=? where cid=?");
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setString(3, contact);
		stmt.setString(4, address);
		stmt.setInt(5,id);
		int value=stmt.executeUpdate();
		return value>0?true:false;
		}
		catch(Exception ex){
			System.out.println("Exception occure in isUpdateCustomer method in CustomerRepository"+ex);
		}
		return false;
	}
	public boolean isDeleteCustomer(int id) {
		try {
			stmt=conn.prepareStatement("delete from customer where cid=?");
			stmt.setInt(1,id);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isDeleteCustomer method in CustomerRepository"+ex);
		}
		return false;
	}
}

