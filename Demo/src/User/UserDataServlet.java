package User;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.loginradius.sdk.raas.api.*;
import com.loginradius.sdk.raas.models.*;

/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataServlet() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		if(request.getParameter("userid")!=null){
			String url = "/profile.jsp";
			//System.out.println(request);
			
			Enumeration params = request.getParameterNames(); 
			while(params.hasMoreElements()){
			 String paramName = (String)params.nextElement();
			 System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
			
			
			
			
			
			RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),
					LoginRadiusCredentials.apiSecret.toString());
			
			new RaaSClientConfig(configuration);
			UserProfileAPI userProfile = new UserProfileAPI();
			String userID = request.getParameter("userid"); 
			
			//System.out.println("UserDataServlet.doGet() userID  " + userID);
			RaaSUserDetails userDetails = userProfile.getUser(userID);
			
			System.out.println("UserDataServlet.doGet()  " + userDetails.getProvider());
			System.out.println("UserDataServlet.getProviderAccessCredential()  " + userDetails.getProviderAccessCredential().accessToken);


			
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			request.setAttribute("firstName", userDetails.getFirstName());
			request.setAttribute("provider", userDetails.getProvider());

			request.setAttribute("lastName", userDetails.getLastName());
			request.setAttribute("gender", userDetails.getGender());
			request.setAttribute("dateofbirth", userDetails.getBirthDate());
			request.setAttribute("emailID", userDetails.getEmail().get(0).Value);	
			request.setAttribute("userId", userID);
			request.setAttribute("RaasID", userDetails.getUid());
			request.setAttribute("imageurl", userDetails.ImageUrl);
			rd.forward(request, response);
		} else if(request.getParameter("raasId")!=null) {
			String url = "/accountproviders.jsp";
			RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
					
			new RaaSClientConfig(configuration);
			UserProfileAPI userProfile = new UserProfileAPI();
			AccountAPI accountApi = new AccountAPI();
			String userID = request.getParameter("raasId");
			RequestDispatcher rd = sc.getRequestDispatcher(url);			
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("userid")!=null){
		RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
		
		UserProfileAPI userProfile = new UserProfileAPI();
		new RaaSClientConfig(configuration);
        if(request.getParameter("password")!=null){
        	if(request.getParameter("oldpassword")!=null && request.getParameter("password")!=null && request.getParameter("confirmpassword")!=null)
        	{	if(request.getParameter("password").toString().equals(request.getParameter("confirmpassword").toString()))
        		{
        			RaaSResponse resp = userProfile.changePassword(
        					request.getParameter("userid").toString(), request.getParameter("oldpassword").toString(), 
        					request.getParameter("password").toString());      
        			response.sendRedirect("getProfile?userid"+request.getParameter("userid").toString());
        		}
        	else 
    			
    			response.sendRedirect(request.getRequestURL()+"?userId="+request.getParameter("userid").toString()+"&error="+"passwords dont match");
    		 
        	}else if(request.getParameter("password")!=null && request.getParameter("confirmpassword")!=null){
        			if(request.getParameter("password").toString().equals(request.getParameter("confirmpassword").toString()))
        			{        		
        				AccountAPI accountApi = new AccountAPI();
        				RaaSUserDetails userdetails = userProfile.getUser(request.getParameter("userid").toString());
        				if(userdetails!=null) {
        					RaaSResponse resp = accountApi.createRaaSProfile(
        					userdetails.getUid(),userdetails.getEmail().get(0).Value,
        					request.getParameter("password").toString());      
        			response.sendRedirect("getProfile?userid"+request.getParameter("userid").toString());
        				}
        			}
        			else 
            			response.sendRedirect(request.getRequestURL()+"?userId="+request.getParameter("userid").toString()+"&error="+"passwords dont match");
            		} 
        		
        		
		} else{
		
			RaaSUserDetails userDetails = new RaaSUserDetails();
		Map<String, String[]> data = request.getParameterMap();
		userDetails.setFirstName(request.getParameter("firstname").toString());
		userDetails.setLastName(request.getParameter("lastname").toString());
		userDetails.setBirthDate(request.getParameter("birthdate").toString());	
		userDetails.setGender(request.getParameter("gender").toString());
		RaaSResponse resp = userProfile.editUser(request.getParameter("userid").toString(), userDetails);		
		}       
        response.sendRedirect("getProfile?userid="+request.getParameter("userid"));  
        
		}
		
	}

}
