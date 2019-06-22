/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basetest;

/**
 *
 * @author sandeep.kumar
 */
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncUtil
{
  private static Cipher ecipher;
  private static Cipher dcipher;
  private static String ENCRYPTION_ALGORITHMS = "DES";
  private static String SK_STRING = "PiyushPr";
  private static SecretKey KEY = null;
  
  public static synchronized String encrypt(String paramString)
    throws Exception
  {
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("UTF8");
      
      byte[] arrayOfByte2 = ecipher.doFinal(arrayOfByte1);
      
      return new BASE64Encoder().encode(arrayOfByte2);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      init();
    }
    return "";
  }
  
  protected static synchronized String decrypt(String paramString)
    throws Exception
  {
    try
    {
      byte[] arrayOfByte1 = new BASE64Decoder().decodeBuffer(paramString);
      
      byte[] arrayOfByte2 = dcipher.doFinal(arrayOfByte1);
      
      return new String(arrayOfByte2, "UTF8");
    }
    catch (IllegalStateException localIllegalStateException)
    {
      init();
    }
    return "";
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("DES");
    SecretKey localSecretKey = localKeyGenerator.generateKey();
    byte[] arrayOfByte = localSecretKey.getEncoded();
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte, "DES");
    if ((paramArrayOfString != null) && ("Y".equals(paramArrayOfString[0])))
    {
      SK_STRING = new String(localSecretKeySpec.getEncoded());
      System.out.println(SK_STRING);
    }
    String str1 = encrypt("abc123");
    System.out.println(str1);
    String str2 = decrypt(str1);
    System.out.println(str2);
  }
  
  static
  {
    init();
  }
  
  private static void init()
  {
    try
    {
      KEY = new SecretKeySpec(SK_STRING.getBytes(), ENCRYPTION_ALGORITHMS);
      ecipher = Cipher.getInstance(ENCRYPTION_ALGORITHMS);
      dcipher = Cipher.getInstance(ENCRYPTION_ALGORITHMS);
      ecipher.init(1, KEY);
      dcipher.init(2, KEY);
    }
    catch (Exception localException)
    {
      System.out.println("EncUtil Initialaization Error : ");
      localException.printStackTrace();
    }
  }
}
