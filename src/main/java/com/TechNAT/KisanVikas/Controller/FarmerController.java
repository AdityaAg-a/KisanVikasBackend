package com.TechNAT.KisanVikas.Controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TechNAT.KisanVikas.DAO.AuthUser;
import com.TechNAT.KisanVikas.DAO.FarmerUser;
import com.TechNAT.KisanVikas.Repositories.FarmerRepository;
import com.TechNAT.KisanVikas.Repositories.FarmerRepositoryCustom;
import com.TechNAT.KisanVikas.Service.AuthenticateLogin;

import org.json.JSONException;
import org.json.JSONObject;


@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	private FarmerRepository farmerRepository;
	private final FarmerRepositoryCustom farmerRepositoryCustom;


	
    public FarmerController(FarmerRepository farmerRepository, FarmerRepositoryCustom farmerRepositoryCustom) {
        this.farmerRepository = farmerRepository;
        this.farmerRepositoryCustom = farmerRepositoryCustom;
    }
	
	@GetMapping(path="/testapi")
	public String test() {
		Map<String,String> mp=new HashMap<>();
		mp.put("Name", "Kiasn Vikas");
		mp.put("Org","TechNAT" );
		return mp.toString();
	}
	
//	@PostMapping(path = "/SignUp")
//	public String userRegister(@RequestBody FarmerUser farmeruser) {
//		String msg="";
//		try {
//			long userexist=this.farmerRepository.countByusrmobileno(farmeruser.getUsrmobileno());
//			if(userexist==0) {
//				this.farmerRepository.save(farmeruser);
//				return msg;
//			}
//			msg="User Already Exist";
//			return msg;
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//	        return msg;
//	
//		}
//	}
//	@PostMapping(path = "/Farmerinfo")
//	public String saveFarmerInfo(@RequestBody FarmerUser farmeruser) {
//		String msg="";
//		try {
//	
//			farmerRepositoryCustom.updateFieldsByMobileNumber(farmeruser.getUsrmobileno(),farmeruser);
//			System.out.println("Used data Updated");
//			msg="User Data Saved";
//			return msg;
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			msg="Expception While saving data";
//	        return msg;
//	
//		}
//	}
//	@CrossOrigin(origins = "*")
//	@PostMapping(path="/sendEmailOTP")
//	public String SendEmailOTP(@RequestBody AuthUser authUser) {
//		String msg="";
//		String mobileno=authUser.getMobileno();
//		if(mobileno.length()==10 && !mobileno.startsWith("0")) {
//			String data=this.sendemailotp.sendOTPemail(mobileno);
//			if(data.equalsIgnoreCase("Success")) {
//				msg="OTP Sent Successfully";
//			}
//			else {
//				msg="OTP Cannot be Sent";
//			}
//		}
//		else {
//			msg="Enter Correct Mobile Number";
//		}
//		return msg;
//	}
//	
	@Autowired 
	private AuthenticateLogin authenticatelogin;
	
	@PostMapping(path="/authOTP")
	public String AuthOTP(@RequestBody AuthUser authUser ) {
		String msg="Sucess";
		String mobileno=authUser.getMobileno();
		String otp=authUser.getOtp();
		if(mobileno.length()==10 && !mobileno.startsWith("0")) {
			if(otp.length()==6) {
				String data=this.authenticatelogin.AuthenciateUser(authUser);
				System.out.println(data);
				msg="Success";
//				String data1=this.authenticatelogin.CheckUserExsist(authUser);
//				System.out.println(data);
			}
		}
		return msg;
	}
	
	@GetMapping(path="/userdata")
	public String UserData(@RequestParam String uid) {
	
		Optional<FarmerUser> ls=this.farmerRepository.findById(uid);
		System.out.println(ls);
		return ls.toString();
	}
	
	@PostMapping(path="/addNewUser")
	public String AddNewUser(@RequestBody FarmerUser farmerUser) {
		String msg="";
		
		String userIdLogging=farmerUser.getLoginDetails().getUserid();
		try {
            long userExist = farmerRepository.countByLoginDetails_Userid(userIdLogging);
            if(userExist == 0) {
				farmerRepository.save(farmerUser);
				msg="User Added Sucessfully";
            }
            else {
            	msg="User Alreay Exist";
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@PostMapping(path="/userStatus")
	public ResponseEntity<String> checkUserExist(@RequestBody String userid) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		try {
			long userExist= farmerRepository.countByLoginDetails_Userid(userid);
			boolean exists = userExist > 0;
			jsonObj.put("status", "Success");
			JSONObject dataJson = new JSONObject();
	         dataJson.put("userExist", exists);
	         jsonObj.put("data", dataJson);
			
	         return ResponseEntity.ok(jsonObj.toString());

		}
		catch(Exception ex) {
			ex.printStackTrace();
			jsonObj.put("status", "Failed");
            return ResponseEntity.ok(jsonObj.toString());
		}
	}
	
	@PostMapping(path="/getUserData")
	public ResponseEntity<String> GetUserData(@RequestBody String userid) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		try {
			long userExist= farmerRepository.countByLoginDetails_Userid(userid);
			boolean exists = userExist > 0;
			if(exists) {
				jsonObj.put("status", "Success");
				FarmerUser userdetails=farmerRepository.findByLoginDetails_Userid(userid);
				JSONObject dataJson = new JSONObject(userdetails);
				System.out.println(dataJson);
				jsonObj.put("data", dataJson);
				
			}
			else {
				jsonObj.put("status", "Success");
				jsonObj.put("data", "User Does Not Exist");
			}
			
	         return ResponseEntity.ok(jsonObj.toString());

		}
		catch(Exception ex) {
			ex.printStackTrace();
			jsonObj.put("status", "Failed");
            return ResponseEntity.ok(jsonObj.toString());
		}
	}
}
