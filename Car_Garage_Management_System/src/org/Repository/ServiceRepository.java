package org.Repository;

import java.sql.*;

import org.Model.MechanicModel;
import org.Model.PartModel;
import org.Model.ServiceModel;
import org.Repository.DBConn;



public class ServiceRepository extends DBConn {
	public boolean isAddMechanicInfo(MechanicModel mmodel) {
		try {
			stmt=conn.prepareStatement("insert into Mechanic values('0',?,?,?)");
			stmt.setString(1, mmodel.getMname());
			stmt.setString(2,mmodel.getSpec());
			stmt.setString(3, mmodel.getExp());
			int value=stmt.executeUpdate();
	        return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddMechanicInfo in serviceRepository"+ex);
		}
		return false;
	}
	public boolean isAddPartInfo(PartModel pmodel) {
		try {
			stmt=conn.prepareStatement("insert into part values('0',?,?)");
			stmt.setString(1,pmodel.getPname());
			stmt.setInt(2, pmodel.getPrice());			
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddPartInfo in serviceRepository"+ex);
		}
		return false;
	}
	public int isSetVehicle(String noplate) {
		try {
			stmt=conn.prepareStatement("select vid from vehicle where noplate=?");
			stmt.setString(1, noplate);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in issetVehicle in serviceRepository "+ex);
			return 0;
		}
	}
	public int isSetMechanic(String depname) {
		try {
			stmt=conn.prepareStatement("select Mid from Mechanic where specialization=?");
			stmt.setString(1, depname);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetMechanic in serviceRepository "+ex);
			return 0;
		}
	}
	public int isSetSpId(int spid) {
		try {
			stmt=conn.prepareStatement("select spid from spjoin where spid=?");
			stmt.setInt(1, spid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetSpId in serviceRepository "+ex);
			return 0;
		}
	}
		public int isSetPart(String partname) {
			try {
				stmt=conn.prepareStatement("select pid from part where pname=?");
				stmt.setString(1, partname);
				rs=stmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
				else {
					return -1;
				}
			}
			catch(Exception ex) {
				System.out.println("Exception occure in isSetPart in serviceRepository "+ex);
				return 0;
			}
		}
		
		public int isSetService(Date sdate) {
				try {
					stmt=conn.prepareStatement("select sid from Service where sdate=?");
					stmt.setDate(1, sdate);
					rs=stmt.executeQuery();
					if(rs.next()) {
						return rs.getInt(1);
					}
					else {
						return -1;
					}
				}
				catch(Exception ex) {
					System.out.println("Exception occure in isSetService in serviceRepository "+ex);
					return 0;
				}
			}
	
	public boolean isAddService(PartModel pmodel,String partname,String noplate,String spec) {
		try {
				 int vid=this.isSetVehicle(noplate);
				 ServiceModel smodel=pmodel.getService();
				 String serviceDate=smodel.getSdate().toLocaleString();
				 String d[]=serviceDate.split(",");
				 String []dateSplit=d[0].split("-");
				 //System.out.println(dateSplit[0]+"\t"+dateSplit[1]+"\t"+dateSplit[2]);
				 int months[]=new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
				 int m=0;
				 switch(dateSplit[1]) {
				 case "Jan":
					 m=0;
					 break;
				 case "Feb":
					 m=1;
					 break;
				 case "Mar":
					 m=2;
					 break;
				 case "April":
					 m=3;
					 break;
				 case "May":
					 m=4;
					 break;
				 case "June":
					 m=5;
					 break;
				 case "July":
					 m=6;
					 break;
				 case "Aug":
					 m=7;
					 break;
				 case "Sap":
					 m=8;
					 break;
				 case "Oct":
					 m=9;
					 break;
				 case "Nov":
					 m=10;
					 break;
				 case "Dec":
					 m=11;
					 break;
				 }
				String newYear=dateSplit[2].substring(2,dateSplit[2].length());
				Date d1=new Date((Integer.parseInt(newYear)+100),m,Integer.parseInt(dateSplit[0]));
				stmt=conn.prepareStatement("insert into service values('0',?,?,?,?)");
				stmt.setDate(1, d1);
				stmt.setInt(2,smodel.getScharge());
				stmt.setString(3, smodel.getDistance());
				stmt.setInt(4, vid);
				int value=stmt.executeUpdate();
				int sid=this.isSetService(d1);
				if(value>0) {
					int pid=this.isSetPart(partname);
					int mid=this.isSetMechanic(spec);
					if(pid!=-1 && mid!=-1) {
						stmt=conn.prepareStatement("insert into spmjoin values(?,?,?)");
						stmt.setInt(1, pid);
						stmt.setInt(2, mid);
						stmt.setInt(3, sid);
						return stmt.executeUpdate()>0?true:false;
					}
					else if(pid==-1 && mid==-1) {
						System.out.println("Part and mechanic not found");
					}
					return true;
				}
				else {
					System.out.println("Servicing not added...............................................................");
					return false;
				}
			}
			catch(Exception ex) {
				System.out.println("Exception occure in isAddService in serviceRepository "+ex);
				return false;
			}
		
		}
}
