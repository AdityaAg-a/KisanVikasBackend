package com.TechNAT.KisanVikas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TechNAT.KisanVikas.DAO.AuthUser;
import com.TechNAT.KisanVikas.Repositories.AuthUserRepository;

@Component
public class AuthenticateLogin {

	@Autowired
	private AuthUserRepository authuserrepo;
	
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
}
