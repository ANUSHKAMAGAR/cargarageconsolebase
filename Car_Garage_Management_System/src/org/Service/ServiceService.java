package org.Service;

import java.util.Date;

import org.Model.MechanicModel;
import org.Model.PartModel;
import org.Model.ServiceModel;
import org.Repository.ServiceRepository;
public class ServiceService {
	ServiceRepository srepo=new ServiceRepository();
	public int isSetMechanic(String name) {
		return srepo.isSetMechanic(name);
	}
	public int isSetPart(String name) {
		return srepo.isSetPart(name);
	}
	public boolean isAddMechanic(MechanicModel mmodel) {
		if(srepo.isAddMechanicInfo(mmodel)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isAddPart(PartModel pmodel) {
		if(srepo.isAddPartInfo(pmodel)) {
			return true;
		}
		else {
			return false;
		}
	}
	public int isSetVehicle(String name) {
		return srepo.isSetVehicle(name);
	}
	public int isSetSpId(int spid) {
		return srepo.isSetSpId(spid);
	}
	 
	public boolean isSetService(PartModel pmodel,String partname,String noplate,String spec) {
		
		Date d=new Date();
		String []s=d.toLocaleString().split(",");
		String dsplit[]=s[0].split("-");
		ServiceModel smodel=pmodel.getService();
		Date userDate=smodel.getSdate();
	    String userDateArr[]=userDate.toLocaleString().split(",");
		String userDates[]=userDateArr[0].split("-");
		if(Integer.parseInt(userDates[2])>=Integer.parseInt(dsplit[2]) && userDates[1].equals(dsplit[1])) {
			if(Integer.parseInt(userDates[0])>=Integer.parseInt(dsplit[0])) {
				boolean b=srepo.isAddService(pmodel,partname,noplate,spec);
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

}
