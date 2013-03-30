
package loginradiussdk;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author  LoginRadius Team
 */
public class ProxyAuthenticator extends Authenticator {
    private String user, password;  
  
    public ProxyAuthenticator(String user, String password) {  
        this.user = user;  
        this.password = password;  
    }  
  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(user, password.toCharArray());  
    }  
}
