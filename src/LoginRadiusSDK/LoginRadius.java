package loginradiussdk;


import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import javax.servlet.http.*;
import loginradiusdataobject.userprofile.*;


     /**
     * LoginRadius
     *
     * LoginRadius SDK class which is containing user profile function and overloaded Constructor .
     * 
     */
public class LoginRadius {

    public boolean IsAuthenticated = false;
    public String Resonse;
    private String TOKEN = "token";
    public String Token = "";
    public String lrjsonresponse = "";
    /**
     * LoginRadius
     *
     * Load Constructor.
     *
     * @param request the original entity
     * @param Api_Secrete LoginRadius App API Secret
     * 
     */
    
    public LoginRadius(HttpServletRequest request, String Api_Secrete) throws Exception {
        ProcessRequest(request, Api_Secrete, null);
    }
    /**
     * LoginRadius
     *
     * Load Constructor (If proxy is enabled).
     *
     * @param request the original entity
     * @param Api_Secrete LoginRadius App API Secret
     * @param proxyHost Proxy host
     * @param proxyPort Proxy server port
     */
    public LoginRadius(HttpServletRequest request, String Api_Secrete, String proxyHost, int proxyPort) throws Exception {
        //110.11.12.30 is your proxy port
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        ProcessRequest(request, Api_Secrete, proxy);


    }
    /**
     * LoginRadius
     *
     * Load Constructor (If proxy is enabled with security).
     *
     * @param request the original entity
     * @param Api_Secrete LoginRadius App API Secret
     * @param proxyHost Proxy Host
     * @param proxyPort Proxy Server port
     * @param userName Proxy server username
     * @param password Proxy server password
     */
    public LoginRadius(HttpServletRequest request, String Api_Secrete, String proxyHost, int proxyPort, String userName, String password) throws Exception {
        //110.11.12.30 is your proxy port
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        ProcessRequest(request, Api_Secrete, proxy);

        Authenticator.setDefault(new ProxyAuthenticator(userName, password));

    }

    private void ProcessRequest(HttpServletRequest request, String Api_Secrete, Proxy proxy) throws IOException {
        if (request.getParameter(TOKEN) != null) {
            if (!request.getParameter(TOKEN).isEmpty()) {
                Utility util =new Utility();
                Token = request.getParameter(TOKEN);
                final String url = Config.ApiBaseUrl+"/userprofile.ashx?token=" + Token + "&apisecrete=" + Api_Secrete;
                lrjsonresponse = util.httpGetRequest(url, proxy);

                if (lrjsonresponse != null) {
                    IsAuthenticated = true;
                } else {
                    IsAuthenticated = false;
                }


            } else {
                IsAuthenticated = false;
            }
        }
    }

    /**
     * getBasicUserprofile
     *
     * Returns basic profile data of the user.
     *
     */
    public BasicUserLoginRadiusUserProfile getBasicUserprofile() throws java.io.IOException {
        BasicUserLoginRadiusUserProfile data = new Gson().fromJson(lrjsonresponse, BasicUserLoginRadiusUserProfile.class);
        return data;
    }

    /**
     * getUltimateUserprofile
     *
     * Returns Ultimate profile data of the user, if premium plus package is enabled.
     *
     */
    public UltimateUserLoginRadiusUserProfile getExtendedUserprofile() {
        UltimateUserLoginRadiusUserProfile data = new Gson().fromJson(lrjsonresponse, UltimateUserLoginRadiusUserProfile.class);
        return data;
    }
    
}