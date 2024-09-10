package org.Service;

import org.Model.VehicleModel;
import org.Repository.VehicleRepository;

public class VehicleService {
	VehicleRepository vrepo=new VehicleRepository();
	public int isCustomerPresent(String name) {
		return (vrepo.isCustomerPresent(name));
	}
	public boolean isAddVehicle(VehicleModel vmodel,String name) {
		if(vrepo.isAddVehicle(vmodel, name)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isViewVehicle(VehicleModel vmodel) {
		if(vrepo.isViewVehicle(vmodel)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isDeleteVehicle(int id) {
		if(vrepo.isDeleteVehicle(id)) {
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isUpdateVehicle(int id,String name,String model,String noplate) {
		if(vrepo.isUpdateVehicle(id, name, model, noplate)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isSearchVehicle(int id) {
		if(vrepo.isSearchVehicle(id)) {
			return true;
		}
		else {
			return false;
		}
	}

}
