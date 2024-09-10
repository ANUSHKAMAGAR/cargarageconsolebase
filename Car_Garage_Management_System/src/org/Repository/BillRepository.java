package org.Repository;

import java.sql.*;

import org.Model.BillModel;
import org.Model.ServiceModel;

public class BillRepository extends DBConn {
	public int isgetChargePrice(int sid) {
		try {
			stmt=conn.prepareStatement("select sum(p.price)+sum(s.scharge) from service s inner join spmjoin spm on s.sid=spm.sid inner join part p on spm.pid=p.pid where spm.sid=?");
			
			stmt.setInt(1, sid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isgetChargePrice method in billRepository"+ex);
			
		}
		return 0;
	}
	public int isSetService(int sid) {
		try {
			stmt=conn.prepareStatement("select vid from Service where sid=?");
			stmt.setInt(1, sid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetService Method in billRepository "+ex);
			return 0;
		}
		
	}
	public boolean isAddBill(BillModel bmodel,int sid) {
		try {
			int totalAmount=this.isgetChargePrice(sid);
			ServiceModel smodel=bmodel.getService();
			 String billDate=bmodel.getBdate().toLocaleString();
			 //System.out.println(billDate);
			 String d[]=billDate.split(",");
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
			int sid1=this.isSetService(sid);
			stmt=conn.prepareStatement("insert into bill value('0',?,?,?)");
			stmt.setInt(1,totalAmount);
			stmt.setDate(2, d1);
			stmt.setInt(3, sid1); 
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddBill Method in billRepository "+ex);
		}
		return false;
	}
	public boolean isViewAllCustomerDateWise(BillModel bmodel) {
		try {
			stmt=conn.prepareStatement("select c.cname,v.vname,b.amount,b.bdate,c.address from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid");
			rs=stmt.executeQuery();
			System.out.println("Customer Name\tVehicle Name\tAmount\t\tbdate\t\t\tAddress");
			while(rs.next()) {
			      String cname=rs.getString(1);
			      String vname=rs.getString(2);
			      int totalamount=rs.getInt(3);
			      Date bdate=rs.getDate(4);
			      String address=rs.getString(5);
			      System.out.println(cname+"\t\t"+vname+"\t\t"+totalamount+"\t\t"+bdate+"\t\t"+address);
			}
		}
		catch(Exception ex) {
			System.out.println("Exception in isViewAllCustomerDateWise is  "+ex);
		
		}
		return false;
	}
	public boolean isCountCustomerMonthWise(BillModel bmodel) {
		try {
		stmt=conn.prepareStatement("select month(b.bdate),count(distinct c.cid),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid group by month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount");
		rs=stmt.executeQuery();
		System.out.println("Month\t\tCustomer_Count\t customer name\t\t\temail\t\tconatct\t\t\taddress\t\tvname\t\tnoplate\t\tservicedate\t\tbill date\t\tAmount");
		while(rs.next()) {
		      int bdate=rs.getInt(1);
		      int cid=rs.getInt(2);
		      String name=rs.getString(3);
		      String email=rs.getString(4);
		      String conatct=rs.getString(5);
		      String address=rs.getString(6);
		      String vname=rs.getString(7);
		      String noplate=rs.getString(8);
	          Date date=rs.getDate(9);
	          Date bdate1=rs.getDate(10);
		      int amount=rs.getInt(11);
		      System.out.println(bdate+"\t\t"+cid+"\t\t"+name+"\t\t\t"+email+"\t\t"+conatct+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+date+"\t\t"+bdate1+"\t\t"+amount);
		}
	}
	catch(Exception ex) {
		System.out.println(" Exception in isCountCustomerMonthWise is "+ex);
	
	}
	return false;
	}
	public boolean isViewCustomerMonthWise(BillModel bmodel,int month) {
		try {
			stmt=conn.prepareStatement("select month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid where month(b.bdate)=? group by month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount");
			stmt.setInt(1, month);
			rs=stmt.executeQuery();
			System.out.println("Month\t\tname\t\temail\t\t\tcontact\t\t\taddress\t\tvname\t\tnoplate\t\tsdate\t\t\tbdate\t\t\tamount\t\t");
			while(rs.next()) {
			      int bdate=rs.getInt(1);
			      String cname=rs.getString(2);
			      String email=rs.getString(3);
			      String contact=rs.getString(4);
			      String address=rs.getString(5);
			      String vname=rs.getString(6);
			      String noplate=rs.getString(7);
			      Date sdate=rs.getDate(8);
			      Date bdate1=rs.getDate(9);
			      int amount=rs.getInt(10);
			      System.out.println(bdate+"\t\t"+cname+"\t\t"+email+"\t\t"+contact+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+sdate+"\t\t"+bdate1+"\t\t"+amount);
			}
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		}
		return false;
	}
	public boolean isViewCustomerDateWise(BillModel bmodel,int date) {
		try {
			stmt=conn.prepareStatement("select day(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid where day(b.bdate)=? group by month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount;");
			stmt.setInt(1, date);
			rs=stmt.executeQuery();
			System.out.println("day\t\tname\t\temail\t\t\tcontact\t\t\taddress\t\tvname\t\tnoplate\t\tsdate\t\t\tbdate\t\t\tamount\t\t");
			while(rs.next()) {
			      int bdate=rs.getInt(1);
			      String cname=rs.getString(2);
			      String email=rs.getString(3);
			      String contact=rs.getString(4);
			      String address=rs.getString(5);
			      String vname=rs.getString(6);
			      String noplate=rs.getString(7);
			      Date sdate=rs.getDate(8);
			      Date bdate1=rs.getDate(9);
			      int amount=rs.getInt(10);
			      System.out.println(bdate+"\t\t"+cname+"\t\t"+email+"\t\t"+contact+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+sdate+"\t\t"+bdate1+"\t\t"+amount);
			}
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		}
		return false;
	}
	public boolean isViewQuartorWise(BillModel bmodel,int Quarter) {
		try {
			stmt=conn.prepareStatement("select quarter(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid where quarter(b.bdate)=? group by month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount");
			stmt.setInt(1, Quarter);
			rs=stmt.executeQuery();
			System.out.println("quarter\t\tname\t\temail\t\t\tcontact\t\t\taddress\t\tvname\t\tnoplate\t\tsdate\t\t\tbdate\t\t\tamount\t\t");
			while(rs.next()) {
			      int bdate=rs.getInt(1);
			      String cname=rs.getString(2);
			      String email=rs.getString(3);
			      String contact=rs.getString(4);
			      String address=rs.getString(5);
			      String vname=rs.getString(6);
			      String noplate=rs.getString(7);
			      Date sdate=rs.getDate(8);
			      Date bdate1=rs.getDate(9);
			      int amount=rs.getInt(10);
			      System.out.println(bdate+"\t\t"+cname+"\t\t"+email+"\t\t"+contact+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+sdate+"\t\t"+bdate1+"\t\t"+amount);
			}
		}
		catch(Exception ex) {
			System.out.println("Error is "+ex);
		
		}
		return false;
	}
		public boolean isViewYearWise(BillModel bmodel,int year) {
			try {
				stmt=conn.prepareStatement("select year(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount from vehicle v inner join service s on s.vid=s.sid inner join bill b on b.vid=v.vid inner join customer c on v.cid=c.cid where year(b.bdate)=? group by month(b.bdate),c.cname,c.email,c.contact,c.address,v.vname,v.noplate,s.sdate,b.bdate,b.amount;");
				stmt.setInt(1, year);
				rs=stmt.executeQuery();
				System.out.println("Month\t\tname\t\temail\t\t\tcontact\t\t\taddress\t\tvname\t\tnoplate\t\tsdate\t\t\tbdate\t\t\tamount\t\t");
				while(rs.next()) {
				      int bdate=rs.getInt(1);
				      String cname=rs.getString(2);
				      String email=rs.getString(3);
				      String contact=rs.getString(4);
				      String address=rs.getString(5);
				      String vname=rs.getString(6);
				      String noplate=rs.getString(7);
				      Date sdate=rs.getDate(8);
				      Date bdate1=rs.getDate(9);
				      int amount=rs.getInt(10);
				      System.out.println(bdate+"\t\t"+cname+"\t\t"+email+"\t\t"+contact+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+sdate+"\t\t"+bdate1+"\t\t"+amount);
				}
			}
			catch(Exception ex) {
				System.out.println("Error is "+ex);
			
			}
			return false;
			}
		public boolean isViewCustomerVehicleWise(BillModel bmodel) {
			try {
				stmt=conn.prepareStatement("select c.cname,c.address,v.vname,v.noplate,v.vmodel from customer c inner join vehicle v on c.cid=v.cid");
				rs=stmt.executeQuery();
				System.out.println("name\t\taddress\t\tvname\t\tnoplate\t\tvmodel");
				while(rs.next()) {
				      String cname=rs.getString(1);
				      String address=rs.getString(2);
				      String vname=rs.getString(3);
				      String noplate=rs.getString(4);
				      String vmodel=rs.getString(5);
				      System.out.println(cname+"\t\t"+address+"\t\t"+vname+"\t\t"+noplate+"\t\t"+vmodel);
				}
			}
			catch(Exception ex) {
				System.out.println("Exception in isViewCustomerVehicleWise is"+ex);
			}
			return false;
}
}
