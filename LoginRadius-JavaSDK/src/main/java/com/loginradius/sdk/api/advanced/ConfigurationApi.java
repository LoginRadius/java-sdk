/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.models.responsemodels.configobjects.ConfigResponseModel;
import com.loginradius.sdk.models.responsemodels.otherobjects.ServiceInfoModel;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class ConfigurationApi {
   private static Gson gson =new Gson();

   public ConfigurationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   // <summary>
   // This API is used to get the configurations which are set in the LoginRadius Dashboard for a particular LoginRadius site/environment
   // </summary>
   // <param name="apiKey">LoginRadius API Key
   // <returns>Response containing LoginRadius App configurations which are set in the LoginRadius Dashboard for a particular LoginRadius 
   // site/environment</returns>
   // 100
        
   public void getConfigurations(final AsyncHandler<ConfigResponseModel> handler)
   {

      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      String resourcePath = "ciam/appinfo";
            
   LoginRadiusRequest.execute("GET",resourcePath,queryParameters,null,new AsyncHandler<String>()
   {
 
      @Override
	  public void onSuccess(String response) {
        TypeToken<ConfigResponseModel> typeToken = new TypeToken<ConfigResponseModel>() {};
	    ConfigResponseModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
	    handler.onSuccess(successResponse);
      }
      @Override
      public void onFailure(ErrorResponse errorResponse) {
		handler.onFailure(errorResponse);
      }
   });
   }
	
   
   
   // <summary>
   // This API allows you to query your LoginRadius account for basic server information and server time information which is useful when generating an SOTT token.
   // </summary>
   // <param name="timeDifference">The time difference you would like to pass, If you not pass difference then the default value is 10 minutes</param>
   // <returns>Response containing Definition of Complete service info data</returns>
   // 3.1	    
		
		
   public void getServerInfo(Integer timeDifference, final AsyncHandler<ServiceInfoModel> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (timeDifference != null) {
        queryParameters.put("timeDifference", String.valueOf(timeDifference));
      }

      String resourcePath = "identity/v2/serverinfo";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ServiceInfoModel> typeToken = new TypeToken<ServiceInfoModel>() {};
          ServiceInfoModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
