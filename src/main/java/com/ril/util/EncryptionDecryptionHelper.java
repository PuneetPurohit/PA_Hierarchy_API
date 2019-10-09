package com.ril.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionDecryptionHelper {
	private static final String characterEncoding = "UTF-8";
	private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
	private static final String aesEncryptionAlgorithm = "AES";
	
	private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
		byte[] keyBytes = new byte[16];
		byte[] parameterKeyBytes = key.getBytes(characterEncoding);
		System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
		return keyBytes;
	}
	
	public static String encrypt(String plainText, String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		byte[] plainTextbytes = plainText.getBytes(characterEncoding);
		
		byte[] keyBytes = getKeyBytes(key);
		return Base64.getEncoder().encodeToString(encrypt(plainTextbytes, keyBytes, keyBytes));
	}
	
	public static String decrypt(String encryptedText, String key)throws KeyException, GeneralSecurityException,GeneralSecurityException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
		byte[] cipheredBytes = Base64.getDecoder().decode(encryptedText);
		byte[] keyBytes = getKeyBytes(key);
		return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
				
	}
	
	public static byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		plainText = cipher.doFinal(plainText);
		return plainText;
	}
	
	public static byte[] decrypt(byte[] cipherText, byte[] key, byte[] initialVector) throws NoSuchAlgorithmException,NoSuchPaddingException, InvalidKeyException,InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		SecretKeySpec secretKeySpecy = new SecretKeySpec(key,aesEncryptionAlgorithm);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
		cipherText = cipher.doFinal(cipherText);
		return cipherText;
	}

	public static String encryptUtilities(String enc) {
		enc = enc.replace("<", "%3C");
		enc = enc.replace(">", "%3E");
		enc = enc.replace("#", "%23");
		enc = enc.replace("%", "%25");
		enc = enc.replace("{", "%7B");
		enc = enc.replace("}", "%7D");
		enc = enc.replace("|", "%7C");
		enc = enc.replace("\\", "%5C");
		enc = enc.replace("^", "%5E");
		enc = enc.replace("~", "%7E");
		enc = enc.replace("[", "%5B");
		enc = enc.replace("]", "%5D");
		enc = enc.replace("'", "%60");
		enc = enc.replace(";", "%3B");
		enc = enc.replace("/", "%2F");
		enc = enc.replace("?", "%3F");
		enc = enc.replace(":", "%3A");
		enc = enc.replace("@", "%40");
		enc = enc.replace("=", "%3D");
		enc = enc.replace("&", "%26");
		enc = enc.replace("$", "%24");
		enc = enc.replace("+", "%2B");
		enc = enc.replace("\"", "%22");
		enc = enc.replace(" ", "%20");

		return enc;
	}
	
	public static String decryptUtilities(String enc) {
		enc = enc.replace("%3C", "<");
		enc = enc.replace("%3E", ">");
		enc = enc.replace("%23", "#");
		enc = enc.replace("%25", "%");
		enc = enc.replace("%7B", "{");
		enc = enc.replace("%7D", "}");
		enc = enc.replace("%7C", "|");
		enc = enc.replace("%5C", "\\");
		enc = enc.replace("%5E", "^");
		enc = enc.replace("%7E", "~");
		enc = enc.replace("%5B", "[");
		enc = enc.replace("%5D", "]");
		enc = enc.replace("%60", "'");
		enc = enc.replace("%3B", ";");
		enc = enc.replace("%2F", "/");
		enc = enc.replace("%3F", "?");
		enc = enc.replace("%3A", ":");
		enc = enc.replace("%40", "@");
		enc = enc.replace("%3D", "=");
		enc = enc.replace("%26", "&");
		enc = enc.replace("%24", "$");
		enc = enc.replace("%2B", "+");
		enc = enc.replace("%22", "\"");
		enc = enc.replace("%20", " ");

		return enc;
	}

}
