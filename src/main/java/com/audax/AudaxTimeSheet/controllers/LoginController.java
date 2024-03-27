package com.audax.AudaxTimeSheet.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.audax.AudaxTimeSheet.entities.Resource;
import com.audax.AudaxTimeSheet.helper.ResourceHelper;
import com.audax.AudaxTimeSheet.services.LoginService;
import com.audax.AudaxTimeSheet.services.ResourceService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
    LoginService service;
    
	@Autowired
    private ResourceService resourceService;
	
	@RequestMapping(value="/uploadReport", method= RequestMethod.GET)
    public String viewUploadReportPage(Model model) {
        return "uploadReport";
    }
	@RequestMapping(value="/report", method= RequestMethod.GET)
    public String viewReportPage(Model model) {
        return "report";
    }
	
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String viewLoginPage(Model model) {
        return "login";
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(Model model, @RequestParam String name, @RequestParam String password) {
        String isValidUser = service.validateUser(name, password);

        if ("admin".equals(isValidUser)) {
            return "uploadReport";
        } else if ("user".equals(isValidUser)) {
            return "report";
        } else {
            model.addAttribute("errorMessage", "Access Denied, Invalid Credentials");
            // Set name and password attributes only when needed
            model.addAttribute("name", name);
            model.addAttribute("password", password);
            
            // Set a timeout to remove the error message after 5 seconds (5000 milliseconds)
            model.addAttribute("timeout", 5000);
            return "login";
        }
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String showLogoutPage(Model model){
        return "login";
    }
    
   
    
    //----------------------------------------------------------------------------------------------------------------
    
    
    @PostMapping("/resource/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (ResourceHelper.checkExcelFormat(file)) {
            //true

            this.resourceService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/resource")
    public List<Resource> getAllProduct() {
        return this.resourceService.getAllProducts();
    }

}
