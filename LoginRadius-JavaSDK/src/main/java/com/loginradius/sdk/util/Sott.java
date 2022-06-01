/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.loginradius.sdk.api.advanced.ConfigurationApi;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.responsemodels.otherobjects.ServiceInfoModel;

public class Sott {

	private static String initVector = "tu89geji340t89u2";
	private static String plaintext="";
	// <summary>
	// Generate SOTT Manually.
	// </summary>
	// <param name="service">ServiceInfoModel Model Class containing Definition of payload for SOTT</param>
	// <param name="apiKey">LoginRadius Api Key.</param>
	// <param name="apiSecret">LoginRadius Api Secret.</param>
	// <param name="getLrServerTime">If true it will call LoginRadius Get Server Time Api and fetch basic server information and server time information which is useful when generating an SOTT token..</param>
	// <returns>Sott data</returns> 
	   
	public static String getSott(ServiceInfoModel service,String apiKey,String apiSecret,boolean getLrServerTime) throws java.lang.Exception {
		String secret = !LoginRadiusValidator.isNullOrWhiteSpace(apiSecret)? apiSecret:LoginRadiusSDK.getApiSecret();
		String key =  !LoginRadiusValidator.isNullOrWhiteSpace(apiKey)? apiKey:LoginRadiusSDK.getApiKey();
		String token = null;
		String timeDifference =(service!=null && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getTimeDifference())) ?service.getSott().getTimeDifference():"10";

		if (service != null && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getStartTime()) && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getEndTime()) ) {
			plaintext = service.getSott().getStartTime() + "#" + key + "#" + service.getSott().getEndTime();
		}
		
		if(getLrServerTime) {
			ConfigurationApi config = new ConfigurationApi();
			config.getServerInfo(Integer.parseInt(timeDifference), new AsyncHandler < ServiceInfoModel > () {
				
			  @Override
			  public void onFailure(ErrorResponse errorResponse) {}

			  @Override
			  public void onSuccess(ServiceInfoModel service) {
			      
				  if(service!=null && !LoginRadiusValidator.isNullOrWhiteSpace( service.getSott().getStartTime()) && !LoginRadiusValidator.isNullOrWhiteSpace( service.getSott().getEndTime()) ) {
					  plaintext = service.getSott().getStartTime() + "#" + key + "#" + service.getSott().getEndTime();
				  }
				  
			  }

			});
		}
		
		if(plaintext.isEmpty()) {
			TimeZone timeZone = TimeZone.getTimeZone("UTC");
			Calendar calendar = Calendar.getInstance(timeZone);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m:s", Locale.US);
			dateFormat.setTimeZone(timeZone);
			plaintext = dateFormat.format(calendar.getTime()) + "#" + key + "#";
			calendar.add(Calendar.MINUTE, Integer.parseInt(timeDifference));
			plaintext += dateFormat.format(calendar.getTime());
		}
		token = encrypt(plaintext, secret);

		String finalToken = token + "*" + createMd5(token);
		return finalToken;
	}

	
	// <summary>
		// Generate SOTT Manually.
		// </summary>
		// <param name="service">ServiceInfoModel Model Class containing Definition of payload for SOTT</param>
		// <param name="apiKey">LoginRadius Api Key.</param>
		// <param name="apiSecret">LoginRadius Api Secret.</param>
		// <returns>Sott data</returns> 
		@Deprecated
		public static String getSott(ServiceInfoModel service,String apiKey,String apiSecret) throws java.lang.Exception {
			String secret = !LoginRadiusValidator.isNullOrWhiteSpace(apiSecret)? apiSecret:LoginRadiusSDK.getApiSecret();
			String key =  !LoginRadiusValidator.isNullOrWhiteSpace(apiKey)? apiKey:LoginRadiusSDK.getApiKey();
			String token = null;
			
			if (service != null && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getStartTime()) && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getEndTime()) ) {
				String plaintext = service.getSott().getStartTime() + "#" + key + "#" + service.getSott().getEndTime();
				token = encrypt(plaintext, secret);	
			} else {
				
				String timeDifference =(service!=null && !LoginRadiusValidator.isNullOrWhiteSpace(service.getSott().getTimeDifference())) ?service.getSott().getTimeDifference():"10";
				TimeZone timeZone = TimeZone.getTimeZone("UTC");
				Calendar calendar = Calendar.getInstance(timeZone);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m:s", Locale.US);
				dateFormat.setTimeZone(timeZone);
				String plaintext = dateFormat.format(calendar.getTime()) + "#" + key + "#";
				calendar.add(Calendar.MINUTE, Integer.parseInt(timeDifference));
				plaintext += dateFormat.format(calendar.getTime());
				token = encrypt(plaintext, secret);
				
			}
			
			String finalToken = token + "*" + createMd5(token);
			return finalToken;
		}
	
	private static String encrypt(final String plaintext, final String passPhrase) throws NoSuchAlgorithmException,
			InvalidKeySpecException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		int iterations = 10000;
		int keysize = 256;
		char[] chars = passPhrase.toCharArray();

		byte[] salt = new byte[8];

		PBEKeySpec pbeSpec = new PBEKeySpec(chars, salt, iterations, keysize);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		Key secretKey = skf.generateSecret(pbeSpec);
		byte[] key = new byte[32];

		System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32);

		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
		byte[] result = cipher.doFinal(plaintext.getBytes("UTF-8"));

		return Base64.getEncoder().encodeToString(result);

	}

	/*
	 * private static String decrypt(String cipherText, String passPhrase) throws
	 * NoSuchAlgorithmException, InvalidKeySpecException,
	 * UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException,
	 * InvalidAlgorithmParameterException, IllegalBlockSizeException,
	 * BadPaddingException { int iterations = 10000; int keysize = 256; char[] chars
	 * = passPhrase.toCharArray(); String token= cipherText.substring(0,
	 * cipherText.lastIndexOf('*')).replace("%2B","+");
	 * 
	 * byte[] salt = new byte[8]; System.out.println(salt);
	 * 
	 * PBEKeySpec pbeSpec = new PBEKeySpec(chars, salt, iterations, keysize);
	 * SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	 * Key secretKey = skf.generateSecret(pbeSpec); byte[] key = new byte[32];
	 * 
	 * System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32); SecretKeySpec
	 * secretKeySpec = new SecretKeySpec(key, "AES"); AlgorithmParameterSpec ivSpec
	 * = new IvParameterSpec(initVector.getBytes("UTF-8")); Cipher cipher =
	 * Cipher.getInstance("AES/CBC/PKCS5Padding"); cipher.init(Cipher.DECRYPT_MODE,
	 * secretKeySpec, ivSpec); byte[] result =
	 * cipher.doFinal(token.getBytes("UTF-8"));
	 * 
	 * return new String(result); }
	 */

	private static String createMd5(final String token) throws NoSuchAlgorithmException {
		byte[] asciiBytes = token.getBytes(StandardCharsets.US_ASCII);
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hashBytes = md.digest(asciiBytes);
		final StringBuilder builder = new StringBuilder();
		for (byte b : hashBytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

}