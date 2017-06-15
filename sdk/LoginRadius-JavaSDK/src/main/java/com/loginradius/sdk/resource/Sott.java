package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.spec.InvalidKeySpecException;
import java.security.InvalidKeyException;
import java.io.UnsupportedEncodingException;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Sott {

	private static String initVector = "tu89geji340t89u2";

	public static String main(String apisecret, String apikey, Map<String, String> map) throws java.lang.Exception {
		String secret = apisecret;
		String key = apikey;
		String token = null;
		if(map!=null && map.containsKey("StartTime") && map.containsKey("EndTime")){
		String plaintext = map.get("StartTime") + "#"+ key +"#" +map.get("EndTime");
		token = encrypt(plaintext, secret);
		}else{
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m:s", Locale.US);
		dateFormat.setTimeZone(timeZone);
		String plaintext = dateFormat.format(calendar.getTime()) + "#" + key + "#";
		calendar.add(Calendar.MINUTE, 10);
		plaintext += dateFormat.format(calendar.getTime());
		token = encrypt(plaintext, secret);
		}
       
		String hash = createMd5(token);
		String finalToken = token.replace("+", "%2B") + "*" + hash;

		return finalToken;
	}

	private static String encrypt(String plaintext, String passPhrase) throws NoSuchAlgorithmException,
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
	 * private static String decrypt(String cipherText, String passPhrase)
	 * throws NoSuchAlgorithmException, InvalidKeySpecException,
	 * UnsupportedEncodingException, NoSuchPaddingException,
	 * InvalidKeyException, InvalidAlgorithmParameterException,
	 * IllegalBlockSizeException, BadPaddingException { int iterations = 10000;
	 * int keysize = 256; char[] chars = passPhrase.toCharArray(); String token=
	 * cipherText.substring(0, cipherText.lastIndexOf('*')).replace("%2B","+");
	 * 
	 * byte[] salt = new byte[8]; System.out.println(salt);
	 * 
	 * PBEKeySpec pbeSpec = new PBEKeySpec(chars, salt, iterations, keysize);
	 * SecretKeyFactory skf =
	 * SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); Key secretKey =
	 * skf.generateSecret(pbeSpec); byte[] key = new byte[32];
	 * 
	 * System.arraycopy(secretKey.getEncoded(), 0, key, 0, 32); SecretKeySpec
	 * secretKeySpec = new SecretKeySpec(key, "AES"); AlgorithmParameterSpec
	 * ivSpec = new IvParameterSpec(initVector.getBytes("UTF-8")); Cipher cipher
	 * = Cipher.getInstance("AES/CBC/PKCS5Padding");
	 * cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec); byte[] result =
	 * cipher.doFinal(token.getBytes("UTF-8"));
	 * 
	 * return new String(result); }
	 */

	private static String createMd5(String token) throws NoSuchAlgorithmException {
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