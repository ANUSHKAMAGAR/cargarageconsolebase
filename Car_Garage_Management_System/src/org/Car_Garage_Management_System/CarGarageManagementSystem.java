package org.Car_Garage_Management_System;

import java.util.*;

import org.Model.AdminModel;
import org.Model.BillModel;
import org.Model.CustomerModel;
import org.Model.MechanicModel;
import org.Model.PartModel;
import org.Model.ServiceModel;
import org.Model.VehicleModel;
import org.Service.AdminService;
import org.Service.BillService;
import org.Service.CustomerService;
import org.Service.ServiceService;
import org.Service.VehicleService;

public class CarGarageManagementSystem {
public static void main(String x[]) {
	Scanner sc=new Scanner(System.in);
    AdminService as=new AdminService();
    CustomerService cs=new CustomerService();
    VehicleService vs=new VehicleService();
    ServiceService ss=new ServiceService();
    BillService bs=new BillService();
    System.out.println("Enter username and password for verification");
    String username=sc.nextLine();
    String password=sc.nextLine();
    AdminModel amodel=new AdminModel(username,password);
    boolean b=as.isAddUserPass(amodel);
    if(b) {
    	System.out.println("Verification Confirm");
    	System.out.println("=========================================================================================================================================");
    	System.out.println("\t\t\t\tWELCOME TO OUR GARAGE");
    	System.out.println("=========================================================================================================================================");
    	do {
    	System.out.println("1.Add New Customer /View/Update/Delete");
    	System.out.println("2.Add Customer Vehicle info /View/Delete/Update/Search");
    	System.out.println("3.Add Customer Vehicle Servicing information");
    	System.out.println("4.Create bill of customer vehicle servicing info"
    			+ "\n"+"5.View All customer bills date wise");
    	System.out.println("6.Count the month wise customer list");
    	System.out.println("7.show month wise customer list");
        System.out.println("8.show the date wise customer list");   
        System.out.println("9.Show the quarter wise customer list");
        System.out.println("10.show the year wise customer list");
        System.out.println("11.show the customer wise vehicle information");
    	System.out.println("Enter your choice");
    	int ch=sc.nextInt();
    	switch(ch) {
    	case 1:
    		do {
    		System.out.println("1.Add Customer information");
    		System.out.println("2.View Customer information");
    		System.out.println("3.Delete Customer information");
    		System.out.println("4.Update Customer information");
    		System.out.println("Enter your choice");
    		ch=sc.nextInt();
    		switch(ch) {
    		case 1:
    			sc.nextLine();
    			System.out.println("Enter Customer Name");
    			String name=sc.nextLine();
    			System.out.println("Enter Customer Email");
    			String email=sc.nextLine();
    			System.out.println("Enter Customer Contact");
    			String contact=sc.nextLine();
    			System.out.println("Enter Customer Address");
    			String address=sc.nextLine();
    			CustomerModel cmodel=new CustomerModel(name,email,contact,address);
    			b=cs.isAddCustomer(cmodel);
    			if(b) {
    				System.out.println("Customer add successfully...................");
    			}
    			else {
    				System.out.println("Customer not added...........................");
    			}
    			break;
    		case 2:
    			sc.nextLine();
    			CustomerModel cmodel1=new CustomerModel();
    			cs.isViewCustomer(cmodel1);
    			break;
    		case 3:
    			System.out.println("enter id you want to delete");
				int id=sc.nextInt();
				CustomerModel cmodel2=new CustomerModel();
				b=cs.deleteCustomer(id);
				if(b) {
					System.out.println("Customer Delete successfully..................");
				}
				else {
					System.out.println("Customer not Deleted...........................");
				}
				break;
    		case 4:
    			System.out.println("Enter id of customer you want to update");
				id=sc.nextInt();
				System.out.println("Enter name of customer");
				name=sc.next();
				System.out.println("Enter email of customer");
				email=sc.next();
				System.out.println("Enter contact of customer");
				contact=sc.next();
				System.out.println("Enter address of customer");
				address=sc.next();
				b=cs.isUpdateCustomer(id, name, email, contact, address);
				if(b) {
					System.out.println("customer update successfully............");
				}
				else {
					System.out.println("Customer not updated .................");
				}
				break;
    		}
    		}while(ch<5);
    		if(ch<5)
			{
				break;
			}
    		break;
    	case 2:
    		do {
    		sc.nextLine();
    		System.out.println("1.add vehicle information");
			System.out.println("2.view vehicle information");
			System.out.println("3.delete vehicle information");
			System.out.println("4.update vehicle information");
			System.out.println("5.search vehicle information");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter name of vehicle");
		        String name=sc.next();
		        System.out.println("Enter model of vehicle");
		        String model=sc.next();
		        sc.nextLine();
		        System.out.println("Enter noplate of vehicle");
		        String noplate=sc.next();
		        VehicleModel vmodel=new VehicleModel(name,model,noplate);
		        System.out.println("Enter customer name");
	            String cname=sc.next();
		        int id=vs.isCustomerPresent(cname);
		         if(id==-1)
		         {
		         	System.out.println("Plz Valid Customer");
		         }
		         else
		         {
	             boolean b1=vs.isAddVehicle(vmodel,cname);
		         if(b) {
		         	System.out.println("Vehicle add successs..................");
		         }
		         else {
		         	System.out.println("Vehicle not added.................");
		         }
		         }
		         break;
			case 2:
				VehicleModel vmodel1=new VehicleModel();
				b=vs.isViewVehicle(vmodel1);
				break;
			case 3:
				System.out.println("Enter id you want to delete");
				id=sc.nextInt();
				VehicleModel vmodel2=new VehicleModel();
				b=vs.isDeleteVehicle(id);
				if(b) {
					System.out.println("Vehicle deleted success..........");
				}
				else {
					System.out.println("Vehicle not delete............");
				}
				break;
			case 4:
				System.out.println("Enter vehicle name");
				name=sc.next();
				System.out.println("Enter vehicle model");
				model=sc.next();
				System.out.println("Enter vehicle noplate");
				noplate=sc.next();
				System.out.println("Enter vehicle id you want to update");
				id=sc.nextInt();
				b=vs.isUpdateVehicle(id,name, model, noplate);
				if(b) {
					System.out.println("Vehicle update success..........");
					
				}
				else {
					System.out.println("Some problem is there............");
				}
				break;
			case 5:
				System.out.println("enter vehicle id you want to search");
				id=sc.nextInt();
				b=vs.isSearchVehicle(id);
				if(b) {
					System.out.println("Vehicle found........................");
				}
				else {
					System.out.println("Vehicle not found....................");
				}
				break;
			}
			}while(ch<5);
		if(ch<5)
		{
			break;
		}
		break;
    	case 3:
    		do {
    			System.out.println("1.Add Mechanic information");
    			System.out.println("2.Add part information");
    			System.out.println("3.Add service information");
    			System.out.println("Enter your choice");
    		    ch=sc.nextInt();
    		    switch(ch) {
    		    case 1:
    		    	sc.nextLine();
    		    	System.out.println("Enter mechanic name");
    		    	String name=sc.nextLine();
    		    	System.out.println("Enter mechanic specialization");
    		    	String spec=sc.nextLine();
    		    	System.out.println("Enter mechanic experience");
    		    	String exp=sc.nextLine();
    		    	MechanicModel mmodel=new MechanicModel(name,spec,exp);
    		        b=ss.isAddMechanic(mmodel);
    		    	if(b) {
    		    		System.out.println("Mechanic added successfully...........");
    		    	}
    		    	else {
    		    		System.out.println("Mechanic not added....................");
    		    	}
    		    	break;
    		    case 2:
    		    	sc.nextLine();
    		    	System.out.println("Enter part name");
    		    	name=sc.nextLine();
    		    	System.out.println("Enter part price");
    		    	int price=sc.nextInt();
    		    	PartModel pmodel=new PartModel(name,price);
    		    	b=ss.isAddPart(pmodel);
    		    	break;
    		    case 3:
    		    	sc.nextLine();
    		        ServiceModel smodel=new ServiceModel();
    		        PartModel pmodel1=new PartModel();
    		    	System.out.println("Enter date");         
				    String dateFormat=sc.next();                                          
				    Date d1=new Date(dateFormat); 
				    System.out.println("Enter service charge");
				    int scharge=sc.nextInt();
				    sc.nextLine();
				    System.out.println("Enter distance");
				    String distance=sc.nextLine();
				    ServiceModel smodel1=new ServiceModel(d1,scharge,distance);
				    System.out.println("Enter vehicle plateno you want to service now");
				    String vpno=sc.nextLine();
				    int b1=ss.isSetVehicle(vpno);
				    pmodel1.setService(smodel1);
				    if(b1==-1) {
				    	System.out.println("Vehicle not found plz valid vehicle");
				    }
				    else {
				    	System.out.println("Enter part name for vehicle");
					    String pname=sc.nextLine();
					    int pid=ss.isSetPart(pname);
					    if(pid==-1) {
					    	System.out.println("Plz Enter valid part");
					    }
					    else {
					    	System.out.println("Enter mechanic specialization for servicing");
						    String mname=sc.nextLine();
						    int mid=ss.isSetMechanic(mname);
						    if(mid==-1 ) {
						    	System.out.println("Mechanic not found");
						    }
						    else {
					    	b=ss.isSetService(pmodel1,pname,vpno,mname);
				    	if(b) {
				    		System.out.println("Service added successfully..................");
				    	}
			
				    	else {
				    		System.out.println("Service not added...........................");
				    	}
				    }
				    }
				    }
				    break;
    		   }  
    		}while(ch<4);
    		if(ch>4)
    		{
    			break;
    		}
    		break;
    	case 4:
    		sc.nextLine();
    		BillModel bmodel=new BillModel();
    		ServiceModel smodel=new ServiceModel();
    		System.out.println("Enter vid you want to generate Bill");
    		int vid1=sc.nextInt();
    		int b4=bs.isSetService(vid1);
    		if(b4==-1) {
    			System.out.println("Plz valid service id");
    		}
    		else {
    		int b1=bs.isgetChargePrice(vid1);
    		System.out.println("Enter date");
			String dateFormat=sc.next();
			Date d3=new Date(dateFormat);
			bmodel.setBdate(d3);
			bmodel.getBdate();
			bmodel.setService(smodel);
			boolean bill=bs.isSetBill(bmodel,vid1);
			bmodel.setService(smodel);
			if(b) {
				System.out.println("Bill added");
			}
			else {
				System.out.println("Not added");
			}
    		}
    		break;
    	case 5:
    		BillModel bmodel1=new BillModel();
		    bs.isViewAllCustomerDateWise(bmodel1);
		    break;
    	case 6:
    		BillModel bmodel2=new BillModel();
		    bs.isCountCustomerMonthWise(bmodel2);
		    break;
    	case 7:
    		BillModel bmodel3=new BillModel();
			System.out.println("Enter month");
			int month=sc.nextInt();
		    bs.isViewCustomerMonthWise(bmodel3,month);
		    break;
    	case 8:
    		BillModel bmodel4=new BillModel();
			System.out.println("Enter date");
			int date1=sc.nextInt();
		    bs.isViewCustomerDateWise(bmodel4,date1);
		    break;
    	case 9:
    		BillModel bmodel5=new BillModel();
    		System.out.println("Enter Quarter");
    		int Quarter=sc.nextInt();
			bs.isViewQuartorWise(bmodel5,Quarter);
			break;
    	case 10:
    		BillModel bmodel6=new BillModel();
			System.out.println("Enter year");
			int year=sc.nextInt();
			bs.isViewYearWise(bmodel6, year);
			break;
    	case 11:
    		BillModel bmodel7=new BillModel();
    		bs.isViewCustomerVehicleWise(bmodel7);
    		break;
			}
    	}while(true);
    }
    else {
    	System.out.println("not valid");
    }
    }
}
