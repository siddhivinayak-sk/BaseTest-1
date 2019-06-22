package com.basetest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class EncUtils{
	private static Cipher ecipher;
	private static Cipher dcipher;
	private static String ENCRYPTION_ALGORITHMS = "DES";

	private static String SK_STRING = "PiyushPr";

	private static SecretKey KEY = null;

	public static synchronized String encrypt(String paramString) throws Exception {
		try {
			byte[] arrayOfByte1 = paramString.getBytes("UTF8");


			byte[] arrayOfByte2 = ecipher.doFinal(arrayOfByte1);


			return new BASE64Encoder().encode(arrayOfByte2);
		} catch (IllegalStateException localIllegalStateException) {
			init();
		}
		return "";
	}

	public static synchronized String decrypt(String paramString) throws Exception{
		try {
			byte[] arrayOfByte1 = new BASE64Decoder().decodeBuffer(paramString);

			byte[] arrayOfByte2 = dcipher.doFinal(arrayOfByte1);


			return new String(arrayOfByte2, "UTF8");
		} catch (IllegalStateException localIllegalStateException) {
			init();
		}
		return "";
	}

	static {
		init();
	}

	private static void init() {
		try {
			KEY = new SecretKeySpec(SK_STRING.getBytes(), ENCRYPTION_ALGORITHMS);
			ecipher = Cipher.getInstance(ENCRYPTION_ALGORITHMS);
			dcipher = Cipher.getInstance(ENCRYPTION_ALGORITHMS);
			ecipher.init(1, KEY);
			dcipher.init(2, KEY);
		} catch (Exception localException) {
			System.out.println("EncUtil Initialaization Error : ");
			localException.printStackTrace();
		}
	}

	public EncUtils() {}
}
