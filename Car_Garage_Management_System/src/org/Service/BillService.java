package org.Service;

import java.util.Date;

import org.Model.BillModel;
import org.Model.ServiceModel;
import org.Repository.BillRepository;



public class BillService {
	BillRepository brepo=new BillRepository();
	public int isgetChargePrice(int sid) {
		return brepo.isgetChargePrice(sid);
	}
	public int isSetService(int sid) {
		return brepo.isSetService(sid);
	}
	public boolean isSetBill(BillModel bmodel,int sid) {
		Date d=new Date();
		String []s=d.toLocaleString().split(",");
		String dsplit[]=s[0].split("-");
		ServiceModel smodel=bmodel.getService();
		Date userDate=bmodel.getBdate();
	    String userDateArr[]=userDate.toLocaleString().split(",");
		String userDates[]=userDateArr[0].split("-");
		if(Integer.parseInt(userDates[2])>=Integer.parseInt(dsplit[2]) && userDates[1].equals(dsplit[1])) {
			if(Integer.parseInt(userDates[0])>=Integer.parseInt(dsplit[0])) {
				boolean b=brepo.isAddBill(bmodel, sid);
				return b?true:false;
			}
			else {
				System.out.println("You may be insert date before system");
			}
		}
		else {
			System.out.println("You may be insert previous year or may be previous month");
		}
		return false;
	}
	public boolean isViewAllCustomerDateWise(BillModel bmodel) {
		return brepo.isViewAllCustomerDateWise(bmodel)?true:false;
	}
	
	public boolean isCountCustomerMonthWise(BillModel bmodel) {
		return brepo.isCountCustomerMonthWise(bmodel)?true:false;
	}
	public boolean isViewCustomerMonthWise(BillModel bmodel,int month) {
		return brepo.isViewCustomerMonthWise(bmodel, month)?true:false;
	}
    public boolean isViewCustomerDateWise(BillModel bmodel,int date) {
		return brepo.isViewCustomerDateWise(bmodel, date);
	}
    public boolean isViewQuartorWise(BillModel bmodel,int Quarter) {
    	return brepo.isViewQuartorWise(bmodel,Quarter);
    }
    public boolean isViewYearWise(BillModel bmodel,int year) {
    	return brepo.isViewYearWise(bmodel, year);
    }
    public boolean isViewCustomerVehicleWise(BillModel bmodel) {
    	return brepo.isViewCustomerVehicleWise(bmodel);
    }
}
