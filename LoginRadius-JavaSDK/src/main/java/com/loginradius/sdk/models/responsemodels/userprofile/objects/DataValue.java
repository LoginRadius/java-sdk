/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response Model Class containing Definition of Registration Data
	// </summary>
	public class DataValue {
	
		
		@SerializedName("DataSource")
        private String dataSource;
		
		@SerializedName("Value")
        private RegistrationDataValueObject value;



		// <summary>
		//	Registration Data Source
		// </summary>
		public String getDataSource() {
			return dataSource;
		}
		// <summary>
		//	Registration Data Source
		// </summary>
		public void setDataSource(String dataSource) {
			this.dataSource = dataSource;
		}
		// <summary>
		//	Value of the dropdown member
		// </summary>
		public RegistrationDataValueObject getValue() {
			return value;
		}
		// <summary>
		//	Value of the dropdown member
		// </summary>
		public void setValue(RegistrationDataValueObject value) {
			this.value = value;
		}
    }