package com.bmw.news.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSACryptoUtil {
	  private static final String RSA_PUBLICE = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsjEccJWGfX0NZvp8j/cCuUDtS" +
	            "D0fPE251wpmFzvdSxcCDzsC2csUz8/C4mnrgGTINX5VXZP2irY3wl0un/BIfIroS" +
	            "UT4aT/WIkXsjgsAD0Z7HCETrOBBEvnPC5iZQxM9Rs0nXU3L5LqhwPEkBX07B0u+A" +
	            "rolgP7n4hNimv5pGpwIDAQAB";
	    private static final String RSA_PRIVATE="MIICXAIBAAKBgQCsjEccJWGfX0NZvp8j/cCuUDtSD0fPE251wpmFzvdSxcCDzsC2" +
				"csUz8/C4mnrgGTINX5VXZP2irY3wl0un/BIfIroSUT4aT/WIkXsjgsAD0Z7HCETr" +
				"OBBEvnPC5iZQxM9Rs0nXU3L5LqhwPEkBX07B0u+ArolgP7n4hNimv5pGpwIDAQAB" +
				"AoGAckPTM4htxaTIbT4XFTaNyuHG5ujHnRI5LDLaiAovLtlWS/M3G5uVjHoXB6kF" +
				"hjIpO0H5HA79CCX2wUTwDSaYuH9PExkyWnOFlVGyLR7n1+dPNE/zS0uwc8xz8/3l" +
				"qFCI3rLvkXmBeOC2QQYVVubpg6dRFyzKgdV/x3EV/ZJvN4ECQQDW/AI78LsDpGTJ" +
				"3Mk4QsR7t947AlwwOOL+Zc9q8r9nRqfhGEACoza0S/zsTL152i6BrQrUsowIhjnW" +
				"zmUIrpzJAkEAzXekibt9Xrhub9mhBVQC5Dql/LwA/3d/NuCxvHQ6K74V9Kbgc8Lc" +
				"8CZclsdKMc37vdxOIV4gtXhgJ8FnpuUv7wJAaGnhU+dpjS1M3lXjTPXwo/37a0GM" +
				"MMeQR+p+wPzBRZGle8fhXuaSbSLy5nmnFQWIzOaUehV1ubYnZVK882iLMQJAYLGf" +
				"c1oSxBLTlju69YD142ZeWzQ23ALmkXLo8iFYhuFr/7jRBGl+BF5pUGP1XL7tbApT" +
				"koxzpDNEPTFdkENnbQJBAJQnR2wn0jznqthYMNcW5yET3oZ0gVVrrpkIawRJdtjb" +
				"R1qa6dnK+LWtKg2KY88JkfmhL8L304yt2co1hTemU7w=";
    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";
    /**
     * 填充方式
     */
    public static final String CIPHER_TRANSFORMAT = "RSA/ECB/PKCS1Padding";
    
    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;
    
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 256;
    
    /**
     * 公钥加密
     * @param content  原文
     * @param publicKey  公钥
     * @param inputCharset 字符编码
     * @return  加密后的字符串（base64）
     * @throws Exception
     */
    public static String encryptByPublicKey(String content, String publicKey, String inputCharset)
            throws Exception {

        byte[] data = content.getBytes(inputCharset);
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        
        // 对数据加密
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMAT);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        
        return Base64.encodeBase64String(encryptedData);
    }
    
    /**
     * 私钥解密
     * @param content  密文（base64）
     * @param privateKey  私钥
     * @param inputCharset  字符编码
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String content) throws Exception {
        
        byte[] encryptedData = Base64.decodeBase64(content);
        byte[] keyBytes = Base64.decodeBase64(RSA_PRIVATE);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMAT);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher
                        .doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher
                        .doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return new String(decryptedData, "UTF-8");
    }
    
    /**
     * 从文件中加载密钥字符串
     * @return 是否成功
     * @throws Exception
     */
    public static String loadKeyString(String keyFile){
        String keyString="";
        InputStream in=null;
        BufferedReader br=null;
        try {
            in=RSACryptoUtil.class.getResourceAsStream("/"+keyFile);
            br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            keyString=sb.toString();
        } catch (IOException e) {
        } catch (Exception e) {

        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return keyString;
    }
    
    /**
     * 从文件中加载密钥字符串  根据文件路径加载
     * @return 是否成功
     * @throws Exception
     */
    public static String loadKeyStringByPath(String keyFile){
        String keyString="";
        InputStream in=null;
        BufferedReader br=null;
        try {
            in = new FileInputStream(keyFile);
            br= new BufferedReader(new InputStreamReader(in));
            String readLine= null;
            StringBuilder sb= new StringBuilder();
            while((readLine= br.readLine())!=null){
                if(readLine.charAt(0)=='-'){
                    continue;
                }else{
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
            keyString=sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return keyString;
    }
}