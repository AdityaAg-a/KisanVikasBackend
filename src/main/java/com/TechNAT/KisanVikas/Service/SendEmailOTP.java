package com.TechNAT.KisanVikas.Service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.TechNAT.KisanVikas.DAO.AuthUser;
import com.TechNAT.KisanVikas.Repositories.AuthUserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

@Component
public class SendEmailOTP {
	@Autowired
	AuthUserRepository authUserrepo;
	@Autowired
    private JavaMailSender emailSender;
	
	public String generateOTP(int length){
		String allowedcharater="0123456789";
		StringBuilder otp = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(allowedcharater.length());
            otp.append(allowedcharater.charAt(randomIndex));
        }
		return otp.toString();
	}
	public String sendOTPemail(String mobileno){
		String msg="";
		int otplength=6;
		try{
			String data=generateOTP(otplength);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			AuthUser user=new AuthUser(mobileno,data,dtf.format(now));
			long count=this.authUserrepo.countBymobileno(mobileno);
			if(count >=1 ) {
				this.authUserrepo.deleteAllBymobileno(mobileno);
			}
			this.authUserrepo.save(user);
			String subject="Verfiy OTP - Kisan Vikas";
			String text=data+" "+"is your OTP for Verfication Account number: "+mobileno;
			String to="250agarwal.2@gmail.com";
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("noreply@kisanVikas.com");
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
			
			msg="Success";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
