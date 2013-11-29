
package loginradiussdk;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import loginradiusdataobject.contact.*;

/**
 *Contacts class
 * 
 * Contacts class containing overload function for collect user contact 
 */
public class Contacts {

    Utility util = new Utility();

 /**
 *getContacts
 *
 * this function used for get user contact
 *
 * @param token Authentication token
 * @param secret LoginRadius App API Secret
 
 */
    public LoginRadiusContact[] getContacts(String token, String secret) throws IOException, Exception {
        return ProcessRequest(token, secret, null);
    }

 /**
 *getContacts
 *
 * this function used for get user contact(If proxy is enabled).
 *
 * @param token Authentication token
 * @param secret LoginRadius App API Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public LoginRadiusContact[] getContacts(String token, String secret, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return ProcessRequest(token, secret, proxy);
    }

  /**
 *getContacts
 *
 * this function used for get user contact(If proxy is enabled with security).
 *
 * @param token Authentication token
 * @param secret LoginRadius App API Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 * @param userName Proxy server username
 * @param password Proxy server password
 */
    public LoginRadiusContact[] getContacts(String token, String secret, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return ProcessRequest(token, secret, proxy);
    }

    private LoginRadiusContact[] ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception {
     

        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format(Config.ApiBaseUrl+"/contacts/%s/%s", URLEncoder.encode(secret),URLEncoder.encode(token));

            String interfaceresponse = util.httpGetRequest(url, proxy);


            return new Gson().fromJson(interfaceresponse, LoginRadiusContact[].class);


        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }

    }
}
