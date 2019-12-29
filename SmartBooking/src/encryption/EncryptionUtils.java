package encryption;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class EncryptionUtils {
	
	public final static String FILENAME = "chiave.txt";
		
	private final static byte[] ivc = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
	
	
	
	public static String encryptMatricola(String msg) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, Exception{
		
		
	    // Cifratura con chiave simmetrica
	    Key key = EncryptionUtils.generateSymmetricKey();
	    //byte[] iv = EncryptionUtils.generateInitVector();		
	    String encripted = EncryptionUtils.base64Encode( EncryptionUtils.encrypt( key, ivc, msg.getBytes() ) );
	    System.out.println( encripted );
	    
	    
	    ObjectInputStream objInStream;
		ArrayList<Key> chiavi;
		
		try {
			FileInputStream inputStream = new FileInputStream(new File(FILENAME));
			
			objInStream = new ObjectInputStream(inputStream);
			
			chiavi = (ArrayList<Key>) objInStream.readObject();
			
			objInStream.close();
			inputStream.close();
			
			chiavi.add(key);
			
			FileOutputStream outputStream = new FileOutputStream(new File(FILENAME));
			    
			ObjectOutputStream objOutStream =  new ObjectOutputStream(outputStream);
			    
			objOutStream.writeObject(chiavi);
			    
			    
			outputStream.close();
			objOutStream.close();
			
		} catch (FileNotFoundException e1) {
			chiavi = new ArrayList<Key>();
			chiavi.add(key);
			FileOutputStream outputStream = new FileOutputStream(FILENAME);
			ObjectOutputStream objOutStream =  new ObjectOutputStream(outputStream);
		    
		    objOutStream.writeObject(chiavi);
		    outputStream.close();
		    objOutStream.close();
		}
	    
		
		return encripted;
	
		
	}
	
	
	
	public static String findKey(String encripted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, Exception{
		
		
		// byte[] iv = EncryptionUtils.generateInitVector();
		
		ArrayList<Key> chiavi = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(FILENAME));
			
			ObjectInputStream objInStream = new ObjectInputStream(inputStream);
			
			chiavi = (ArrayList<Key>) objInStream.readObject();
			
			objInStream.close();
			inputStream.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("Il file non estste");
			
		}catch(EOFException e){
			e.printStackTrace();
			System.out.println("Il file è vuoto");
			
		}
	    
	    
			
	    // -----------------------
	    // Invio messaggio cifrato
	    // -----------------------
	    
	    // Decifratura con chiave simmetrica
		
		for(Key k : chiavi){
			
			try {
				System.out.println(k);
				String decripted = new String( EncryptionUtils.decrypt( k, ivc, EncryptionUtils.base64Decode( encripted ) ) );
				System.out.println( "CHIAVE TROVATA" );
				System.out.println( decripted );
				return decripted;
			} catch (Exception e) {
				System.out.println( "NO" );
			}
			
		}
		
		return null;
		
		
	}
	
	
	
	

		/*public static byte [] generateInitVector() {
		    SecureRandom random = new SecureRandom();
		    byte [] iv = new byte [ SYM_KEY_SIZE / 8 ];
		    random.nextBytes( iv );
		    return iv;
		}*/
	
		public static byte [] decrypt( Key key,byte[] iv,  byte[] ciphertext ) throws 
	    NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	    IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
		cipher.init( Cipher.DECRYPT_MODE, key, new IvParameterSpec( iv ) );
		return cipher.doFinal( ciphertext );
		}			
		
		public static byte [] encrypt( Key key,byte[] iv,  byte[] plaintext ) throws
        NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
        IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
	    Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
	    cipher.init( Cipher.ENCRYPT_MODE, key, new IvParameterSpec( iv ) );
	    return cipher.doFinal( plaintext );
		}
		
		private static final String SYM_ALGORITHM 	= "AES";
		private static final Integer SYM_KEY_SIZE 	= 128;

		public static Key generateSymmetricKey() throws NoSuchAlgorithmException {
		    KeyGenerator generator = KeyGenerator.getInstance( SYM_ALGORITHM );
		    generator.init( SYM_KEY_SIZE );
		    SecretKey key = generator.generateKey();
		    return key;
		}
		
		private static final Encoder encoder = Base64.getEncoder();
		private static final Decoder decoder = Base64.getDecoder();

		public static String base64Encode( byte[] array ) {
		    return encoder.encodeToString(array);
		}
			
		public static byte[] base64Decode( String buffer ) throws Exception {
		    return decoder.decode(buffer);
		}

}
