package com.bmw.news.common.utils;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by 通子 on 2017/9/5.
 */

public class RSAUtil {
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
    private static final String ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";//SHA1WithRSA 或者 MD5withRSA
    
    /**
     * 得到公钥
     *
     * @param algorithm
     * @param bysKey
     * @return
     */
    private static PublicKey getPublicKeyFromX509(String algorithm,
                                                  String bysKey) throws NoSuchAlgorithmException, Exception {
        byte[] decodedKey = Base64.decodeBase64(bysKey);
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        return keyFactory.generatePublic(x509);
    }

    /**
	 * 校验数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            数字签名
	 * 
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 * 
	 */
	public static boolean verify(byte[] data, String sign)
			throws Exception {

		// 解密由base64编码的公钥
		byte[] keyBytes = Base64Utils.decode(RSA_PUBLICE);

		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);

		// 取公钥匙对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);

		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);

		// 验证签名是否正常
		return signature.verify(Base64Utils.decode(sign));
	}
    
    /**
     * 使用公钥加密
     *
     * @param content
     * @return
     */
    public static String encryptByPublic(String content) {
        try {
            PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubkey);

            byte plaintext[] = content.getBytes("UTF-8");
            byte[] output = cipher.doFinal(plaintext);

            String s = new String(Base64.encodeBase64(output));

            return s;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用公钥解密
     *
     * @param content 密文
     * @return 解密后的字符串
     */
    public static String decryptByPublic(String content) {
        try {
            PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, RSA_PUBLICE);
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
//            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, pubkey);
            InputStream ins = new ByteArrayInputStream(Base64Utils.decode(content));
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            byte[] buf = new byte[128];
            int bufl;
            while ((bufl = ins.read(buf)) != -1) {
                byte[] block = null;
                if (buf.length == bufl) {
                    block = buf;
                } else {
                    block = new byte[bufl];
                    for (int i = 0; i < bufl; i++) {
                        block[i] = buf[i];
                    }
                }
                writer.write(cipher.doFinal(block));
            }
            return new String(writer.toByteArray(), "utf-8");
        } catch (Exception e) {
            return null;
        }
    }
    
}
