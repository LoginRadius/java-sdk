/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Sports Property
	 */
	public class Sports {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Id of sport
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of sport
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of sport
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of sport
		 */
		public void setName(String name) {
			this.name = name;
		}
    }