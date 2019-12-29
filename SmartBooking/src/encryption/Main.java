package encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {
	
	public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, Exception {
		
		String mat = "sdfrgewtrewjqy	rqehwrnhq5y3hegw4q3	t4q35	wqt	WQHGFQ4	 3QY5T4R3QT4	YQ35HTERGET3R	4T";
		
		String matCriptata = EncryptionUtils.encryptMatricola(mat);
		
		System.out.println("oo");
		System.out.println(matCriptata);
		
		String matDecriptata = EncryptionUtils.findKey(matCriptata);
		
		System.out.println("oo");
		System.out.println(matDecriptata);
		
		
	}
	

}
