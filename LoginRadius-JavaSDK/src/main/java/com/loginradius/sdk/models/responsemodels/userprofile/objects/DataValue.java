/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response Model Class containing Definition of Registration Data
	 */
	public class DataValue {
	
		
		@SerializedName("DataSource")
        private String dataSource;
		
		@SerializedName("Value")
        private RegistrationDataValueObject value;



		/**
		 * Registration Data Source
		 */
		public String getDataSource() {
			return dataSource;
		}
		/**
		 * Registration Data Source
		 */
		public void setDataSource(String dataSource) {
			this.dataSource = dataSource;
		}
		/**
		 * Value of the dropdown member
		 */
		public RegistrationDataValueObject getValue() {
			return value;
		}
		/**
		 * Value of the dropdown member
		 */
		public void setValue(RegistrationDataValueObject value) {
			this.value = value;
		}
    }