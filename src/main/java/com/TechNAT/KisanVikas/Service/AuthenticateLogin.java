package com.TechNAT.KisanVikas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TechNAT.KisanVikas.DAO.AuthUser;
import com.TechNAT.KisanVikas.Repositories.AuthUserRepository;
import com.TechNAT.KisanVikas.Repositories.FarmerRepository;

@Component
public class AuthenticateLogin {

	@Autowired
	private AuthUserRepository authuserrepo;
	
	@Autowired
	private FarmerRepository farmerrepo;
	
	public String AuthenciateUser(AuthUser authUser) {
		String msg="";
		try {
			String data=this.authuserrepo.findBymobileno(authUser.getMobileno());
			System.out.println(data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
//	public String CheckUserExsist(AuthUser authUser) {
//		String msg="false";
//		try {
//			long data = this.farmerrepo.countByusrmobileno(authUser.getMobileno());
//			System.out.println(data);
//			if(data==1) {
//				msg="true";
//			}
//		}
//		catch(Exception ex) {
//			msg="SERVER SIDE ERROR";
//			ex.printStackTrace();
//		}
//		return msg;
//	}
}
