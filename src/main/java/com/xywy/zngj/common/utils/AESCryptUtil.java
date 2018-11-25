package com.xywy.zngj.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Encrypt and decrypt messages using AES 256 bit encryption that are compatible with AESCrypt-ObjC and AESCrypt Ruby.
 * <p/>
 * Created by lipr on 04/04/2018.
 */
public final class AESCryptUtil {

    private static final String TAG = "bigdata_TEST1";

    //AESCrypt-ObjC uses CBC and PKCS7Padding
    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final String CHARSET = "UTF-8";

    //AESCrypt-ObjC uses SHA-256 (and so a 256-bit key)
    private static final String HASH_ALGORITHM = "SHA-256";

    /**
     * Generates SHA256 hash of the password which is used as key
     *
     * @param password used to generated key
     * @return SHA256 of the password
     */
    private static SecretKeySpec generateKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
        digest.update(TAG.getBytes("UTF-8"));
        byte[] keyBytes = new byte[32];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        return secretKeySpec;
    }
    public static AlgorithmParameterSpec getIV() {
        byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        IvParameterSpec ivParameterSpec;
        ivParameterSpec = new IvParameterSpec(iv);
        return ivParameterSpec;

    }

    /**
     * Encrypt and encode message using 256-bit AES with key generated from password.
     *
     *
     * @param password used to generated key
     * @param message the thing you want to encrypt assumed String UTF-8
     * @return Base64 encoded CipherText
     * @throws GeneralSecurityException if problems occur during encryption
     */
    public static String encrypt( String message)
            throws GeneralSecurityException {
        try {
            final SecretKeySpec key = generateKey();
            byte[] cipherText = encrypt(key,  message.getBytes(CHARSET));
            String encoded = new String(Base64.encodeBase64(cipherText), CHARSET);
            return encoded;
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }


    /**
     * More flexible AES encrypt that doesn't encode
     * @param key AES key typically 128, 192 or 256 bit
     * @param iv Initiation Vector
     * @param message in bytes (assumed it's already been decoded)
     * @return Encrypted cipher text (not encoded)
     * @throws GeneralSecurityException if something goes wrong during encryption
     */
    public static byte[] encrypt(final SecretKeySpec key, final byte[] message)
            throws GeneralSecurityException {
        final Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, key, getIV());
        byte[] cipherText = cipher.doFinal(message);
        return cipherText;
    }


    /**
     * Decrypt and decode ciphertext using 256-bit AES with key generated from password
     *
     * @param password used to generated key
     * @param base64EncodedCipherText the encrpyted message encoded with base64
     * @return message in Plain text (String UTF-8)
     * @throws GeneralSecurityException if there's an issue decrypting
     */
    public static String decrypt(String base64EncodedCipherText)
            throws GeneralSecurityException {
        try {
            final SecretKeySpec key = generateKey();
            byte[] decodedCipherText = Base64.decodeBase64(base64EncodedCipherText);
            byte[] decryptedBytes = decrypt(key, decodedCipherText);
            String message = new String(decryptedBytes, CHARSET);
            return message;
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }


    /**
     * More flexible AES decrypt that doesn't encode
     *
     * @param key AES key typically 128, 192 or 256 bit
     * @param iv Initiation Vector
     * @param decodedCipherText in bytes (assumed it's already been decoded)
     * @return Decrypted message cipher text (not encoded)
     * @throws GeneralSecurityException if something goes wrong during encryption
     */
    public static byte[] decrypt(final SecretKeySpec key, final byte[] decodedCipherText)
            throws GeneralSecurityException {
            final Cipher cipher = Cipher.getInstance(AES_MODE);
            cipher.init(Cipher.DECRYPT_MODE, key, getIV());
            byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
            return decryptedBytes;
    }
    private AESCryptUtil() {
    }
    
    public static void main(String[] args) throws Exception {
		 //String d=AESCryptUtil.decrypt("LtiaEIvMC/+LaYW7Ky9bIPZzjNVXRtYnFlyEd4nFnL/ethVSi4eF4YK4TrySvLa0mwaFAEfydmHaFU3gTWO1mq+VpOAvqXis0XQmtJNLmUPm9MYyZnqkAReLbxMDDh5Ja6C220jfuUtxJEilOHEIt8/pwZN04teu9XEDYddiEd4S2PCqVqbeAkgy+CyVcA+YpGZY9gjbPofUnKHs1YvrDzf5duI8HX2P6PoNRd/srTfbEa12hzEfF2wMtM+LWU6SoMPES4Bxg6UU07wgDSKt8xulHwF/EoymZHeWoV8uytFs8VrS4om/Evyx/6IAugJpJgjQuh/C0XmVOgyLdpLTxkWU9Ydgad4sbMvxF+wZyTsGp0mclXLTxyN9En6IHl7ag/qAAVSCxzhTe+s2k+XDUg");
		 //System.out.println(d);
		 String encrypt = AESCryptUtil.encrypt("{\"msg\":\"该手机号已注册!\",\"data\":\"1111\",\"status\":\"305\"}");
		 //String encrypt1 = AESCryptUtil.encrypt(d);
		 System.out.println(encrypt);
		 
		 
	}
}