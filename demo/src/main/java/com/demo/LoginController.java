package com.demo;

import com.loginradius.sdk.resource.LoginRadiusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by LoginRadius Development Team on 09/23/2018
 */
@Controller
public class LoginController {

    @Autowired
    LoginRadiusService service;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(){
        return "redirect:/loginscreen";
    }

    @RequestMapping(value="/minimal", method=RequestMethod.GET)
    public String minimal(){
        return "index";
    }

    @RequestMapping(value="/loginscreen", method=RequestMethod.GET)
    public String loginScreen(){
        return "loginscreen";
    }

    @RequestMapping(value="/emailverification", method=RequestMethod.GET)
    public String emailverification(){
        return "emailverification";
    }

    @RequestMapping(value="/resetpassword", method=RequestMethod.GET)
    public String resetpassword(){
        return "resetpassword";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request){
        try {
            String result = service.login(request);
            System.out.println("LoginController.login::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.login::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/mfa", method=RequestMethod.POST)
    @ResponseBody
    public String mfaLogin(HttpServletRequest request){
        try {
            String result = service.mfaLogin(request);
            System.out.println("LoginController.mfaLogin::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.mfaLogin::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/mfa/verify", method=RequestMethod.PUT)
    @ResponseBody
    public String mfaVerify(HttpServletRequest request){
        try {
            String result = service.mfaVerify(request);
            System.out.println("LoginController.mfaVerify::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.mfaVerify::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request){
        try {
            String result = service.register(request);
            System.out.println("LoginController.register::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.register::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/email/verify", method=RequestMethod.GET)
    @ResponseBody
    public String emailVerify(HttpServletRequest request){
        try {
            String result = service.emailVerify(request);
            System.out.println("LoginController.emailVerify::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.emailVerify::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/passwordless", method=RequestMethod.GET)
    @ResponseBody
    public String passwordlessLogin(HttpServletRequest request){
        try {
            String result = service.passwordlessLogin(request);
            System.out.println("LoginController.passwordlessLogin::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.passwordlessLogin::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/passwordless/verify", method=RequestMethod.GET)
    @ResponseBody
    public String passwordlessVerify(HttpServletRequest request){
        try {
            String result = service.passwordlessVerify(request);
            System.out.println("LoginController.passwordlessVerify::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.passwordlessVerify::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/password/forgot", method=RequestMethod.POST)
    @ResponseBody
    public String forgotPassword(HttpServletRequest request){
        try {
            String result = service.forgotPassword(request);
            System.out.println("LoginController.forgotPassword::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.forgotPassword::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }

    @RequestMapping(value="/password/reset", method=RequestMethod.PUT)
    @ResponseBody
    public String resetPassword(HttpServletRequest request){
        try {
            String result = service.resetPassword(request);
            System.out.println("LoginController.resetPassword::" + result);
            return result;
        } catch (LoginRadiusException e) {
            System.out.println("Err::LoginController.resetPassword::" + e.getErrorResponse().getDescription());
            return e.getErrorResponse().getDescription();
        }
    }
}
