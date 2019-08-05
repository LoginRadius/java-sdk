package com.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LoginRadius Development Team on 09/23/2018
 */
@Controller
public class UserController {

    @Autowired
    LoginRadiusService service;

    @RequestMapping(value="/profile", method={RequestMethod.GET,RequestMethod.POST})
    public String profile(HttpServletRequest request){
        return "profile";
    }

    @RequestMapping(value="/user", method=RequestMethod.GET)
    @ResponseBody
    public String getUserProfile(HttpServletRequest request){
            String result = service.getUserProfile(request);
            System.out.println("UserController.getUserProfile::" + result);
            return result;

    }

    @RequestMapping(value="/password/change", method=RequestMethod.PUT)
    @ResponseBody
    public String changePassword(HttpServletRequest request){
      
            String result = service.changePassword(request);
            System.out.println("UserController.changePassword::" + result);
            return result;
    }
    
    @RequestMapping(value="/password/set", method=RequestMethod.PUT)
    @ResponseBody
    public String setPassword(HttpServletRequest request){
      
            String result = service.setPassword(request);
            System.out.println("UserController.setPassword::" + result);
            return result;
    }
    
    @RequestMapping(value="/account", method=RequestMethod.PUT)
    @ResponseBody
    public String accountUpdate(HttpServletRequest request){
       
            String result = service.accountUpdate(request);
            System.out.println("UserController.accountUpdate::" + result);
            return result;
    }

    @RequestMapping(value="/customobject", method={RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
    @ResponseBody
    public String customObject(HttpServletRequest request){
        String result = null;
      
            if (request.getMethod().equals(RequestMethod.POST.toString())) {
                result = service.createCustomObject(request);
            } else if (request.getMethod().equals(RequestMethod.GET.toString())) {
                result = service.getCustomObject(request);
            } else if (request.getMethod().equals(RequestMethod.PUT.toString())) {
                result = service.updateCustomObject(request);
            } else if (request.getMethod().equals(RequestMethod.DELETE.toString())) {
                result = service.deleteCustomObject(request);
            }
            System.out.println("UserController.customObject::" + result);
            return result;
       
    }

    @RequestMapping(value="/mfa/reset", method=RequestMethod.DELETE)
    @ResponseBody
    public String mfaReset(HttpServletRequest request){
      
            String result = service.mfaReset(request);
            System.out.println("UserController.mfaReset::" + result);
            return result;
       
    }

    @RequestMapping(value="/role", method={RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
    @ResponseBody
    public String role(HttpServletRequest request){
        String result = null;
       
            if (request.getMethod().equals(RequestMethod.POST.toString())) {
                result = service.createRole(request);
            } else if (request.getMethod().equals(RequestMethod.GET.toString())) {
                result = service.getAllRoles(request);
            } else if (request.getMethod().equals(RequestMethod.DELETE.toString())) {
                result = service.deleteRole(request);
            }
            System.out.println("UserController.role::" + result);
            return result;
       
    }

    @RequestMapping(value="/role/user", method={RequestMethod.GET,RequestMethod.PUT})
    @ResponseBody
    public String userRole(HttpServletRequest request){
        String result = null;
       
            if (request.getMethod().equals(RequestMethod.GET.toString())) {
                result = service.getUserRoles(request);
            } else if (request.getMethod().equals(RequestMethod.PUT.toString())) {
                result = service.assignRole(request);
            }
            System.out.println("UserController.userRole::" + result);
            return result;
        
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    @ResponseBody
    public String logout(HttpServletRequest request){
      
            String result = service.logout(request);
            System.out.println("UserController.logout::" + result);
            return result;
       
    }
}