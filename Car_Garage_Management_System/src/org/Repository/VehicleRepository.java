package org.Repository;

import org.Model.VehicleModel;

public class VehicleRepository extends DBConn {
	public int isCustomerPresent(String name) {
		try {
			stmt=conn.prepareStatement("select cid from customer where cname=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isCustomerPresent in VehicleRepository "+ex);
			return 0;
		}
	}
	public boolean isAddVehicle(VehicleModel vmodel,String name) {
		try {
			int cid=this.isCustomerPresent(name);
			stmt=conn.prepareStatement("insert into vehicle values('0',?,?,?,?)");
			stmt.setString(1, vmodel.getVname());
			stmt.setString(2,vmodel.getModel());
			stmt.setString(3, vmodel.getNoplate());
			stmt.setInt(4, cid);
			int value=stmt.executeUpdate();
			return (value>0)? true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddVehicle in VehicleRepository "+ex);
		}
		return false;
	}
	public boolean isViewVehicle(VehicleModel vmodel) {
		try {
			  stmt=conn.prepareStatement("select *from vehicle");
			  rs=stmt.executeQuery();
			  System.out.println("id\tvname\tmodel\tnoplate\tcid");
			  while(rs.next()) {
			  int id=rs.getInt(1);
		      String vname=rs.getString(2);
		      String model=rs.getString(3);
		      String noplate=rs.getString(4);
		      String name=rs.getString(5);
			  System.out.println(id+"\t"+vname+"\t"+model+"\t"+noplate+"\t"+name);
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isViewVehicle in VehicleRepository"+ex);
			return false;
		}
		return false;
	}
	public boolean isDeleteVehicle(int id) {
		try {
			stmt=conn.prepareStatement("delete from vehicle where vid=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}
	public boolean isUpdateVehicle(int id,String name,String model,String noplate) {
		try {
			stmt=conn.prepareStatement("update vehicle set vname=?,vmodel=?,noplate=? where vid=?");
			stmt.setString(1,name);
			stmt.setString(2,model);
			stmt.setString(3,noplate);
			stmt.setInt(4, id);
			int value=stmt.executeUpdate();
			return (value>0)?true:false;	
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isUpdateVehicle in VehicleRepository "+ex);
		}
		return false;
	}
	public boolean isSearchVehicle(int id) {
		try {
			stmt=conn.prepareStatement("select *from vehicle where vid=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			System.out.println("id\tvname\tmodel\tnoplate\tcid");
			  while(rs.next()) {
			  int vid=rs.getInt(1);
		      String vname=rs.getString(2);
		      String model=rs.getString(3);
		      String noplate=rs.getString(4);
		      String name=rs.getString(5);
			  System.out.println(vid+"\t"+vname+"\t"+model+"\t"+noplate+"\t"+name);
			  return true;
			  
		}
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
		return false;
	}

}
