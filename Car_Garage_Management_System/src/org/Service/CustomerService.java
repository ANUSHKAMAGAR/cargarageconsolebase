package org.Service;

import org.Model.CustomerModel;
import org.Repository.CustomerRepository;

public class CustomerService {
	CustomerRepository crepo=new CustomerRepository();
	public boolean isAddCustomer(CustomerModel cmodel) {
		if(crepo.isAddCustomer(cmodel)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isViewCustomer(CustomerModel cmodel) {
		if(crepo.isViewCustomer(cmodel)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isUpdateCustomer(int id,String name,String email,String contact,String address) {
		if(crepo.isUpdateCustomer(id, name, email, contact, address)) {
			return true;
		}
		else {
			return false;
		}
	}
    public boolean deleteCustomer(int id) {
    	if(crepo.isDeleteCustomer(id)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
