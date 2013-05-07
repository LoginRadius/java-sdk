package loginradiussdk;

import java.net.*;
import java.io.*;
import java.util.regex.*;

/**
 *
 * @author LoginRadius Team
 */
public class Utility {

    public String httpGetRequest(final String url, Proxy proxy) throws IOException {
        BufferedReader in = null;
        String res = null;
        StringBuilder lrresponse = new StringBuilder();
        try {

            URL LoginRadiusRestUrl = new URL(url);

            HttpURLConnection yc;


            if (proxy != null) {
                yc = (HttpURLConnection)LoginRadiusRestUrl.openConnection(proxy);
            } else {
                yc = (HttpURLConnection)LoginRadiusRestUrl.openConnection();
            }
            yc.setRequestProperty("Accept", "application/json");
            yc.setRequestProperty("Accept-Charset", "UTF-8");

            in = new BufferedReader(
                    new InputStreamReader(
                    yc.getInputStream()));
           
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                lrresponse.append(inputLine);
            }

            res = new String(lrresponse.toString().getBytes(), "UTF-8");

        } catch (Exception ex) {
            String message = ex.getMessage();
            String m = message;
        } finally {
            in.close();
        }

        return res;
    }

    public static boolean isValidGuid(String guid) {

        String pattern = "^(\\{){0,1}[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}(\\}){0,1}$";
        return Pattern.matches(pattern, guid);
    }
}
