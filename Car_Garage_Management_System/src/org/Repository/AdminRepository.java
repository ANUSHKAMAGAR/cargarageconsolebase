package org.Repository;

import org.Model.AdminModel;

public class AdminRepository extends DBConn {
	public boolean isAddUserPassword(AdminModel amodel)
	{
		try {
			stmt = conn.prepareStatement("select *from admin where username=? and password=?");
			stmt.setString(1,amodel.getUsername());
			stmt.setString(2,amodel.getPassword());
			rs=stmt.executeQuery();
			return rs.next();
		}
		catch(Exception ex)
		{
		System.out.println("Exception occure in isAddUserPassword method in AdminRepository "+ex);
			return false;
		}
		
	}

}
