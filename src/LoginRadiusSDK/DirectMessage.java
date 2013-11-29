
package loginradiussdk;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;

/**
 *DirectMessage class
 * 
 * DirectMessage class which is  containing overload function for send message by user 
 */
public class DirectMessage {

    Utility util = new Utility();

    
  /**
 *sendMessage
 *
 * this function used for send message by user 
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param sendto User id which will Receive message
 * @param subject Message subject
 * @param message Message text  
 */
    public boolean sendMessage(String token, String secret, String sendto, String subject, String message) throws IOException, Exception {
        return UpdateProcessRequest(token, secret, sendto, subject, message, null);
    }

    /**
 *sendMessage
 *
 * this function used for send message by user (If proxy is enabled).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param sendto User id which will Receive message
 * @param subject Message subject
 * @param message Message text  
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 */
    public boolean sendMessage(String token, String secret, String sendto, String subject, String message, String proxyHost, int proxyPort) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        return UpdateProcessRequest(token, secret, sendto, subject, message, proxy);
    }

    /**
 *sendMessage
 *
 * this function used for send message by user (If proxy is enabled with security).
 *  
 * @param token Authentication token
 * @param secret LoginRadius apikey Secret
 * @param sendto User id which will Receive message
 * @param subject Message subject
 * @param message Message text  
 * @param proxyHost Proxy host
 * @param proxyPort Proxy server port
 * @param userName Proxy server username
 * @param password Proxy server password
 */
    public boolean sendMessage(String token, String secret, String sendto, String subject, String message, String proxyHost, int proxyPort, String username, String password) throws IOException, Exception {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        Authenticator.setDefault(new ProxyAuthenticator(username, password));
        return UpdateProcessRequest(token, secret, sendto, subject, message, proxy);
    }

    private boolean UpdateProcessRequest(String token, String secret, String sendto, String subject, String message, Proxy proxy) throws IOException, Exception {
        boolean issuccess;

        if (Utility.isValidGuid(token) && Utility.isValidGuid(secret)) {

            String url = String.format(Config.ApiBaseUrl+"/directmessage/%s/%s?sendto=%s&subject=%s&message=%s", URLEncoder.encode(secret), URLEncoder.encode(token), URLEncoder.encode(sendto), URLEncoder.encode(subject),URLEncoder.encode( message));

            String interfaceresponse = util.httpGetRequest(url, proxy);

            issuccess = Boolean.parseBoolean(interfaceresponse.toLowerCase());

        } else {
            throw new Exception("Invalid Api key please use valid Guid format api key");
        }

        return issuccess;
    }
}
