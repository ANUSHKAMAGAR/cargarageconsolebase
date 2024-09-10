package org.Service;

import org.Model.AdminModel;
import org.Repository.AdminRepository;

public class AdminService {
public boolean isAddUserPass(AdminModel amodel) {
	AdminRepository arepo=new AdminRepository(); 
	if(arepo.isAddUserPassword(amodel)) {
		return true;
	}
	else {
		return false;
	}
}
}
