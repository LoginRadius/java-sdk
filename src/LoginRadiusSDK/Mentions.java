
package loginradiussdk;
import loginradiusdataobject.status.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
/**
 *Mentions class
 * 
 * Mentions class which is  containing overload  function for get user Mentions
 */
public class Mentions {
    
    Utility util = new Utility();

 /**
 *getMentions
 *
 * this function used for  get user mentions
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 */
    public LoginRadiusStatuses[] getMentions(String token, String secret) throws IOException, Exception {
        return ProcessRequest(token, secret, null);
    }

  /**
 *getMentions
 *
 * this function used for  get user mentions (If proxy is enabled).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public LoginRadiusStatuses[] getMentions(String token, String secret, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return ProcessRequest(token, secret, proxy);
    }

    /**
 *getMentions
 *
 * this function used for  get user mentions (If proxy is enabled with security).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 * @param userName Proxy server username
 * @param password Proxy server password
 */
    public LoginRadiusStatuses[] getMentions(String token, String secret, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return ProcessRequest(token, secret, proxy);
    }

    private LoginRadiusStatuses[] ProcessRequest(String token, String secret, Proxy proxy) throws IOException, Exception {
        
        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format(Config.ApiBaseUrl+"/status/mentions/%s/%s", secret, token);

            String interfaceresponse = util.httpGetRequest(url, proxy);


            return new Gson().fromJson(interfaceresponse, LoginRadiusStatuses[].class);


        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }
    }
}
