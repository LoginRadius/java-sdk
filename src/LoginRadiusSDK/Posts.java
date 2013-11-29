
package loginradiussdk;
import loginradiusdataobject.postcomman.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
/**
 *Posts class
 * 
 * Posts class which is  containing overload  function for get user posts
 */
public class Posts {
    Utility util = new Utility();

    
 /**
 *getPosts
 *
 * this function used for  get user posts
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 */
    public LoginRadiusPost[] getPosts(String token, String secret) throws IOException, Exception {
        return ProcessRequest(token, secret, null);
    }

    /**
 *getPosts
 *
 * this function used for  get user posts (If proxy is enabled).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public LoginRadiusPost[] getPosts(String token, String secret, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return ProcessRequest(token, secret, proxy);
    }

    /**
 *getPosts
 *
 * this function used for  get user posts (If proxy is enabled with security).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 * @param userName Proxy server username
 * @param password Proxy server password
 */
    public LoginRadiusPost[] getPosts(String token, String secret, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return ProcessRequest(token, secret, proxy);
    }

    private LoginRadiusPost[] ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception {
        
        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format(Config.ApiBaseUrl+"/GetPosts/%s/%s", URLEncoder.encode(secret), URLEncoder.encode(token));

            String interfaceresponse = util.httpGetRequest(url, proxy);


            return new Gson().fromJson(interfaceresponse, LoginRadiusPost[].class);


        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }

    }
}
