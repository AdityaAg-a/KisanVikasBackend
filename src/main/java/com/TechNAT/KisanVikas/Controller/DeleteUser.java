package com.TechNAT.KisanVikas.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.TechNAT.KisanVikas.Service.FarmerService;

@RestController
@RequestMapping("/userdelete")
@CrossOrigin(origins = "https://adityaag-a.github.io/EaseTechBridge.github.io/")
public class DeleteUser {
	
	@Autowired
    private FarmerService farmerservice;
	
	@DeleteMapping("/delete/{mobileNumber}")
    public ResponseEntity<String> deleteUserByMobileNumber(@PathVariable String mobileNumber) {
        try {
            farmerservice.deleteUserByMobileNumber(mobileNumber);
            return new ResponseEntity<>("User with mobile number " + mobileNumber + " deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete user with mobile number " + mobileNumber, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
