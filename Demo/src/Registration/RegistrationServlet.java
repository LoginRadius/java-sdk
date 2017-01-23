package Registration;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		
		/**
		 * Use this code to render and validate a  custom form if you need one
		 * 
		 * 
		 
		ServletContext sc = getServletContext();

		String url = "/register.jsp";
		RequestDispatcher rd = sc.getRequestDispatcher(url);

		rd.forward(request, response);
		*/
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * Use this code to post process your registration form
		 * This is just a demo and your implementation will depend on the technology 
		 * stack that you are using
		 */
		
		/**
		 * Some of the custom code that you may use will utilize the 
		 * user profile APIs as shown in the api documentation 
		 * http://apidocs.loginradius.com/docs/java-library#section-register-user
		 * See the documentation for all the details
		 * 
		 * 
		 * 	
		String responseString="";		
		LoginRadiusRestErrorResponse errorResponse=null;
		RaaSResponse successresponse=null;
		RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
	
		new RaaSClientConfig(configuration);
		UserProfileAPI register = new UserProfileAPI();
		RaaSUserDetails user= new RaaSUserDetails();		   
		      JsonObject userdetails = new JsonObject();
		      userdetails.addProperty("emailid", "john.doe@gmail.com");
		      userdetails.addProperty("password", "password");
		      // userDetails.put("address1", "freak@gmail.com");
		      userdetails.addProperty("gender", "M");
		      userdetails.addProperty("firstname", "RTT");
		      userdetails.addProperty("lastname", "R00T");

		      userdetails.addProperty("birthdate", "01-31-1980");
		      userdetails.addProperty("city", "KON");
		      JsonObject customfield = new JsonObject();
		      customfield.addProperty("iOS", 3314);
		      customfield.addProperty("Android", 4415);

		      userdetails.add("customfields", customfield);
		      userdetails.addProperty("nickname", "nick-name");
		      userdetails.addProperty("timezone", "PST);
		      userdetails.addProperty("Country", "Pakistan");
		      userdetails.addProperty("placeslived", "City-1, City-2 , City-3, City-4");
		      userdetails.addProperty("postalcode", "212-314-RR");
		      userdetails.addProperty("company", "mycompany");
		      userdetails.addProperty("about", "About-me");
		      userdetails.addProperty("phonenumber", "714-334-1334");
		 *    RaaSResponse details = upapi.registerUser(userdetails.toString());
		if(request.getParameter("password").equals(request.getParameter("confirmpassword"))){

			//RaaSResponse resp = register.registerUser(user);
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
			//response.sendRedirect("register.jsp?error="+errorResponse.description);
		}else{
			response.sendRedirect("index.jsp?success="+successresponse.isPosted);
		}
		 */
		

		
	}

}
