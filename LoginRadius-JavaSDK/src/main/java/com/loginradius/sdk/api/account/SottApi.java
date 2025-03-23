/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.account;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.models.responsemodels.SottResponseData;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class SottApi {
   private static Gson gson =new Gson();

   public SottApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API allows you to generate SOTT with a given expiration time.
   // </summary>
   // <param name="timeDifference">The time difference you would like to pass, If you not pass difference then the default value is 10 minutes</param>
   // <returns>Sott data For Registration</returns>
   // 18.28	    
		
		
   public void generateSott(Integer timeDifference, final AsyncHandler<SottResponseData> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (timeDifference != null) {
        queryParameters.put("timeDifference", String.valueOf(timeDifference));
      }

      String resourcePath = "identity/v2/manage/account/sott";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SottResponseData> typeToken = new TypeToken<SottResponseData>() {};
          SottResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
