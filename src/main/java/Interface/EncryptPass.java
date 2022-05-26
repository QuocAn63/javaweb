package Interface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public interface EncryptPass {
	public static String md5(String USER_PASSWORD) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte[] messageDigest = md.digest(USER_PASSWORD.getBytes());
		
		String hashedString = Base64.getEncoder().encodeToString(messageDigest);
		
		return hashedString;
	}
}
