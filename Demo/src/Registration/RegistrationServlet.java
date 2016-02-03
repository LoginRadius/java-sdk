package Registration;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.LoginRadiusCredentials;
import com.loginradius.sdk.raas.api.UserProfileAPI;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.raas.models.*;
/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("sgdsfsdsdf");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseString="";		
		LoginRadiusRestErrorResponse errorResponse=null;
		RaaSResponse successresponse=null;
		RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
		
		new RaaSClientConfig(configuration);
		UserProfileAPI register = new UserProfileAPI();
		RaaSUserDetails user= new RaaSUserDetails();
		//RaaSUserProfile user = new RaaSUserProfile();
		
		
		
		/*Enumeration params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = (String)params.nextElement();
		 System.out.println("Attribute Name - "+paramName+", Value - "+request.getParameter(paramName));
		}*/
		
		
		
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		if(request.getParameter("password").equals(request.getParameter("confirmpassword"))){
			user.setPassword(request.getParameter("password"));	
			user.setEmailId(request.getParameter("emailid"));	
			user.setGender(request.getParameter("gender"));
			user.setBirthDate(request.getParameter("birthdate"));
			RaaSResponse resp = register.registerUser(user);
			if(responseString.contains("isPosted")){
				successresponse = new LoginRadiusJsonDeserializer().deserializeJson(responseString, RaaSResponse.class);
			}
			errorResponse = new LoginRadiusJsonDeserializer().deserializeJson(responseString, LoginRadiusRestErrorResponse.class);
		}
		else{
		responseString = "{'description': 'passwords dont match','errorCode': 908,'message': 'A parameter is not formatted correctly (Parameter name in Response)',  'isProviderError': false,  'providerErrorResponse': null}";
		errorResponse = new LoginRadiusJsonDeserializer().deserializeJson(responseString, LoginRadiusRestErrorResponse.class);
		}
		if(errorResponse!=null){
			response.sendRedirect("register.jsp?error="+errorResponse.description);
		}else{
			response.sendRedirect("index.jsp?success="+successresponse.isPosted);
		}		
	}

}
