
package loginradiussdk;

import loginradiusdataobject.status.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;

/**
 *Status class
 * 
 * Status class which is  containing overload  function for get and update  user status
 */
public class Statuses {

    Utility util = new Utility();

 /**
 *getStatuses
 *
 * this function used for  get user Statuses
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 */
    public LoginRadiusStatuses[] getStatuses(String token, String secret) throws IOException, Exception {
        return GetStatusProcessRequest(token, secret, null);
    }

 /**
 *getStatuses
 *
 * this function used for  get user Statuses(If proxy is enabled).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public LoginRadiusStatuses[] getStatuses(String token, String secret, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return GetStatusProcessRequest(token, secret, proxy);
    }

  /**
 *getStatuses
 *
 * this function used for  get user Statuses(If proxy is enabled with security).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
  * @param userName Proxy server username
 * @param password Proxy server password
 */
    public LoginRadiusStatuses[] getStatuses(String token, String secret, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return GetStatusProcessRequest(token, secret, proxy);
    }

    private LoginRadiusStatuses[] GetStatusProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception {
        

        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format("http://"+Config.Domain+"/status/get/%s/%s", secret, token);

            String interfaceresponse = util.httpGetRequest(url, proxy);


            return new Gson().fromJson(interfaceresponse, LoginRadiusStatuses[].class);


        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }

    }

    /**
 *postStatus
 *
 * this function used for  post status by user on wall
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param to Proxy host
 * @param title Status title 
  * @param link Link which image user want to post on wall
 * @param imageurl Imageurl which image user want to post on wall
 * @param message Status message
 * @param caption Status caption
 * @param description Status description
 */
    public boolean postStatus(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description) throws IOException, Exception {
        return UpdateProcessRequest(token, secret, to, title, link, imageurl, message, caption, description, null);
    }

  /**
 *postStatus
 *
 * this function used for  post status by user on wall (If proxy is enabled with security).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param to Proxy host
 * @param title Status title 
  * @param link Link which image user want to post on wall
 * @param imageurl Imageurl which image user want to post on wall
 * @param message Status message
 * @param caption Status caption
 * @param description Status description
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
  * @param userName Proxy server username
 * @param password Proxy server password
 */
    public boolean postStatus(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return UpdateProcessRequest(token, secret, to, title, link, imageurl, message, caption, description, proxy);
    }

    /**
 *postStatus
 *
 * this function used for  post status by user on wall (If proxy is enabled).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param to Proxy host
 * @param title Status title 
  * @param link Link which image user want to post on wall
 * @param imageurl Imageurl which image user want to post on wall
 * @param message Status message
 * @param caption Status caption
 * @param description Status description
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public boolean postStatus(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return UpdateProcessRequest(token, secret, to, title, link, imageurl, message, caption, description, proxy);
    }

    private boolean UpdateProcessRequest(String token, String secret, String to, String title, String link, String imageurl, String message, String caption, String description, Proxy proxy) throws IOException, Exception {
        boolean issuccess;

        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format("http://"+Config.Domain+"/status/update/%s/%s?to=%s&title=%s&url=%s&imageurl=%s&status=%s&caption=%s&description=%s", URLEncoder.encode( secret),URLEncoder.encode( token), URLEncoder.encode(to), URLEncoder.encode(title), URLEncoder.encode(link), URLEncoder.encode(imageurl), URLEncoder.encode(message), URLEncoder.encode(caption),URLEncoder.encode( description));

            String interfaceresponse = util.httpGetRequest(url, proxy);

            issuccess = Boolean.parseBoolean(interfaceresponse.toLowerCase());

        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }

        return issuccess;
    }
}
