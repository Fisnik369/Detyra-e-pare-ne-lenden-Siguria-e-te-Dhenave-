import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64.*;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.Console;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class RsaKey{
	
	private Cipher cipher;
	private static Scanner x;
	
    public static void main(String[] args) throws Exception {
		
	
	    Scanner input = new Scanner(System.in);
    	String paraqit = args[0];
		 
    
    	if(paraqit.contains("create-user" )) {
			
    	  String user = args[1];
		
		
          String XML_PRIVATE_FILENAME =  "RSA2/" + user + "XmlPrivateKey.xml";
          String XML_PUBLIC_FILENAME = "RSA2/" + user + "PublicKey.pub.xml";
          File file = new File(XML_PRIVATE_FILENAME);
          File file1 = new File(XML_PUBLIC_FILENAME);
          boolean exists = file.exists();
          boolean exists1 = file1.exists();
		  
		  
        if(exists && exists1) {
			
        System.out.println("Keta celesa ekzistojne tashme!");
		
        }
        else {
			
		  System.out.print("Sheno fjalekalimin: ");
		  String pass1 = input.nextLine();
		
		
		  System.out.print("Sheno fjalekalimin perseri: ");
		  String pass2 = input.nextLine();
		
		  String n = ".*[0-9].*";
		  String a = ".*[a-zA-Z].*";
          String special = ".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*";
		
			
		if(pass1.length() >=6){
				
			if( pass1.matches(a) && ( pass1.matches(special) || pass1.matches(n))  ){
			
			    if(pass1.equals(pass2)){
			
                   String privateKeyAsEncoded = getPrivateKeyAsEncoded(getPrivateKey());
    
                   String publicKeyAdEncoded = getPublicKeyAsEncoded(getPublicKey());
                   System.out.println("Eshte krijuar shfrytezuesi: " + user);
                   System.out.println("Eshte krijuar celesi privat " + user + ".xml");
                   System.out.println("Eshte krijuar celesi publik " + user + ".pub.xml");
		
                   String privateKeyAsXml = getPrivateKeyAsXml(getPrivateKey());
                   String publicKeyAsXml = getPublicKeyAsXml(getPublicKey());
           
                   writeFile(privateKeyAsXml, XML_PRIVATE_FILENAME);
                   writeFile(publicKeyAsXml, XML_PUBLIC_FILENAME);
		
		           sendToDB(user, pass1);
			}
			    else {
				
				   System.out.println("Fjalekalimet nuk perputhen!");
				
			}
			
				}
		    else {
					
					System.out.println("Password-i duhet te permbaje numra dhe shkronja ose karaktere speciale!");
					
					
				}
		
			}
		else {
				
				System.out.println("Fjalekalimi duhet te jete me i gjate ose i barabarte me 6 karaktere!");
				
			}
			
			
        }
		  
		  
    	}
		
	
    	else if(paraqit.contains("export-key" )) {
				
        	String user = args[1];
		
              String ENCODED_PRIVATE_FILENAME =  user  + "EncodedPrivateKey.txt";
              String ENCODED_PUBLIC_FILENAME =  user + "EncodedPublicKey.txt";
              String XML_PRIVATE_FILENAME =  "RSA2/" + user + "XmlPrivateKey.xml";
              String XML_PUBLIC_FILENAME = "RSA2/" + user + "PublicKey.pub.xml";
			  
              File file = new File(XML_PRIVATE_FILENAME);
              File file1 = new File(XML_PUBLIC_FILENAME);
			  
              boolean exists = file.exists();
              boolean exists1 = file1.exists();
			  
            if(exists && exists1) {
            	
                 String privateKeyAsXml = getPrivateKeyAsXml(getPrivateKey());
                 String publicKeyAsXml = getPublicKeyAsXml(getPublicKey());
             	
             	 String xml = args[2];
             	
             	if(xml.contains("private")) {
                   
                 print("Private key in XML format:" + NL + privateKeyAsXml);
                 writeFile(privateKeyAsXml, XML_PRIVATE_FILENAME);
             	}
             	else if(xml.contains("public")) {
					
                 print("Public key in XML format: " + NL + publicKeyAsXml);
                 writeFile(publicKeyAsXml, XML_PUBLIC_FILENAME);
             	}
            }
            else {
				
            	System.out.println("Nuk ekziston nje celes i tille!");
            }
				
			
    	}
		
		
    	else if(paraqit.contains("delete-user" )) {
			
			String user = args[1];
    		DeleteUser(user);
    	}
		
		
    	else if(paraqit.contains("write-message" )) {
    		
    		String user = args[1];
    		String message = args[2];
			
    		Map<String, Object> keys = getRSAKeys();
			
            PrivateKey privateKey = (PrivateKey) keys.get("private");
            PublicKey publicKey = (PublicKey) keys.get("public");
			
    		sendMessage(user,message,publicKey, privateKey);
    	
    	}
		
		
		else if(paraqit.contains("read-message")){
			
			
			String messazhi = args[1];
			
			readFromAllFiles(messazhi);
			Map<String, Object> keys = getRSAKeys();
			
			PrivateKey privateKey = (PrivateKey) keys.get("private");
			PublicKey publicKey = (PublicKey) keys.get("public");
				
		}
		
		
		else if(paraqit.contains("import-key")){
			
    		String sheno = args[1];
    		
    		ImportPrivate(sheno);
			
					
		}
		
		
    }
	
	
    public static void sendMessage(String user, String message , PublicKey publicKey, PrivateKey privateKey) throws Exception {
	    
        String ENCODED_PRIVATE_FILENAME =  user  + "EncodedPrivateKey.txt";
        String ENCODED_PUBLIC_FILENAME =  user + "EncodedPublicKey.txt";
        String XML_PRIVATE_FILENAME =  "RSA2/" + user + "XmlPrivateKey.xml";
        String XML_PUBLIC_FILENAME = "RSA2/" + user + "PublicKey.pub.xml";
		
        File file = new File(XML_PRIVATE_FILENAME);
        File file1 = new File(XML_PUBLIC_FILENAME);
		
        boolean exists = file.exists();
        boolean exists1 = file1.exists();
		
      if(exists && exists1) {
		  
         System.out.println("Enkriptimi: ");
         String encryptedText = encryptMessage(message, privateKey);
         String descryptedText = decryptMessage(encryptedText, publicKey);
         String publicK =  getPublicKeyAsXml(publicKey);
    
         writeToFile("RSA2/" + user,encryptedText);
         System.out.println(encryptedText);
    
      }
      else {
    	  
    	  System.out.println("Ky celes publik nuk ekziston!");
    	  
      }
    }
	
	
	
	public static void sendToDB(String username, String passwordToHash)throws NoSuchAlgorithmException, NoSuchProviderException{
		
	
	      byte[] salt = getSalt();
	         
	      String securePassword = getSecurePassword(passwordToHash, salt);
	      String filepath = "RSA2/TeDhenat.txt";
		  String Tedhenat = username + "," + securePassword + "\n";
		
		  File file = new File(filepath);
		  boolean exists = file.exists();
		  
		try{
			
		 if(exists){
			
			
			FileWriter fw = new FileWriter(file, true);
			
            BufferedWriter bw = new BufferedWriter(fw);
		    System.out.println();
            
			bw.write(Tedhenat);
            bw.close();
			
			
		}
		 else {
			
			System.out.println("Fajlli i kerkuar nuk ekziston!");
			
		}
		
		}
		catch (IOException e) {
			
        e.printStackTrace();
    }
			
	}
	
	
	 private static String getSecurePassword(String passwordToHash, byte[] salt)
	    {
	        String generatedPassword = null;
			
	        try {
	            
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(salt);
	
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
				
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            
	            generatedPassword = sb.toString();
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
	     
	    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
	    {
	        
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
	        byte[] salt = new byte[16];
	        
	        sr.nextBytes(salt);
	        
	        return salt;
	    }
	
	
	
	
    private static String decryptMessage(String encryptedText, PublicKey publicKey) throws Exception {
	    
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
		
    }
	
	
    
    private static String encryptMessage(String plainText, PrivateKey privateKey) throws Exception {
	    
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
		
    }
	
	
	
	public static void writeToFile(String fileName, String message)
	{
		try
		{
			File file = new File("RSA2/" + fileName + ".txt");
			FileWriter theFile = new FileWriter(fileName);
			PrintWriter fileOut = new PrintWriter(theFile);
			
		    fileOut.println(message);
			fileOut.close( );
		}
		
		catch( IOException e ) {
			
			System.out.println( "Problem writing to the file" );
			
		}
		
	} 
	
	
	
	public static String readFromFile(String user) {
		
		String oneLine = null;
		String twoLine;
		String fileName = "RSA2/" + user;
		int counter = 0;
		try {
			
			FileReader theFile = new FileReader(fileName);
			FileReader the = new FileReader(fileName);
			
			BufferedReader fileIn = new BufferedReader(theFile);
			BufferedReader fileIn1 = new BufferedReader(the);
			
			oneLine = fileIn.readLine();
			twoLine = fileIn1.readLine();
			return oneLine;
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Unable to locate the file: " + fileName);
		}
		
		catch (IOException e) {
			System.out.println("There was a problem reading the file: " + fileName);
		}
		return oneLine;
	} 
	
	
	
	public RsaKey() throws NoSuchAlgorithmException, NoSuchPaddingException {
		this.cipher = Cipher.getInstance("RSA");
	}
	
	
	 static final String NL = System.getProperty("line.separator");
	 static KeyPair getKeyPair() throws Exception{
		 KeyPair keyPair = createKeyPair(1024);
		 return keyPair;
	 }
	 
	 
	 static PrivateKey getPrivateKey() throws Exception {
		 PrivateKey privateKey = getKeyPair().getPrivate();
		 return privateKey;
	 }
	 
	 
	 static PublicKey getPublicKey() throws Exception{
		 PublicKey publicKey = getKeyPair().getPublic();
		 return publicKey;
	 }
	 
	 
    static KeyPair createKeyPair(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        keygen.initialize(keyLength, new SecureRandom());
        KeyPair keyPair = keygen.generateKeyPair();
        return keyPair;
    }
	
	
    static KeyPair createKeyPair1(int keyLength) throws NoSuchAlgorithmException {
	    
        KeyPairGenerator keygen1 = KeyPairGenerator.getInstance("RSA");
        keygen1.initialize(keyLength, new SecureRandom());
        KeyPair keyPair1 = keygen1.generateKeyPair();
        return keyPair1;
    }
	
	
    static String getPrivateKeyAsEncoded(PrivateKey privateKey){
	    
        byte[] privateKeyEncodedBytes = privateKey.getEncoded();
        return getBase64(privateKeyEncodedBytes);
    }
	
	
    static String getPublicKeyAsEncoded(PublicKey publicKey){
	    
        byte[] publicKeyEncoded = publicKey.getEncoded();
        return getBase64(publicKeyEncoded);
    }
	
	
    static String getPrivateKeyAsXml(PrivateKey privateKey) throws Exception{
	    
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec spec = keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        StringBuilder sb = new StringBuilder();
        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append(getElement("P", spec.getPrimeP()));
        sb.append(getElement("Q", spec.getPrimeQ()));
        sb.append(getElement("DP", spec.getPrimeExponentP()));
        sb.append(getElement("DQ", spec.getPrimeExponentQ()));
        sb.append(getElement("InverseQ", spec.getCrtCoefficient()));
        sb.append(getElement("D", spec.getPrivateExponent()));
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }
	
	
    static String getPublicKeyAsXml(PublicKey publicKey) throws Exception{
	    
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec spec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        StringBuilder sb = new StringBuilder();
        sb.append("<RSAKeyValue>" + NL);
        sb.append(getElement("Modulus", spec.getModulus()));
        sb.append(getElement("Exponent", spec.getPublicExponent()));
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }
	
	
    static String getElement(String name, BigInteger bigInt) throws Exception {
	    
        byte[] bytesFromBigInt = getBytesFromBigInt(bigInt);
        String elementContent = getBase64(bytesFromBigInt);
        return String.format("  <%s>%s</%s>%s", name, elementContent, name, NL);
    }
	
	
    static byte[] getBytesFromBigInt(BigInteger bigInt){
	    
        byte[] bytes = bigInt.toByteArray();
        int length = bytes.length;
        if(length % 2 != 0 && bytes[0] == 0) {
            bytes = Arrays.copyOfRange(bytes, 1, length);
        }
        return bytes;
    }
	
	
    static String getBase64(byte[] bytes){
	    
        return Base64.getEncoder().encodeToString(bytes);
    }
	
	
    static void writeFile(String text, String filename) throws Exception{
	    
        try(PrintWriter writer = new PrintWriter(filename)){
            writer.write(text);
        }
    }
	
	
    static void writeFile1(String plainText, String filename) throws Exception {
	    
    	try(PrintWriter writer = new PrintWriter(filename)){
    		writer.write(plainText);
    	}
    }
	
    static void print(String line){
	    
        System.out.println(line);
    }
	
	
	
    static void DeleteUser(String user) {
    	
    	
    	String XML_PRIVATE_FILENAME =  "RSA2/" + user + "XmlPrivateKey.xml";
        String XML_PUBLIC_FILENAME = "RSA2/" + user + "PublicKey.pub.xml";
        String filepath = "RSA2/TeDhenat.txt";
		
        File file2 = new File(XML_PRIVATE_FILENAME);
        File file1 = new File(XML_PUBLIC_FILENAME);
		
        boolean exists = file2.exists();
        boolean exists1 = file1.exists();
		
		
		
		removeRecord(filepath, user);
		
		
		
		
        if(file2.delete() && file1.delete()) {
        	System.out.println("Fajllat jane fshire!");
        }
        else {
        	System.out.println("Keta fajlla nuk ekzistojne!");
        }
    }
	
	
    private static Map<String,Object> getRSAKeys() throws Exception {
	    
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        Map<String, Object> keys = new HashMap<String,Object>();
        keys.put("private", privateKey);
        keys.put("public", publicKey);
        return keys;
    }
	
	
	public static void readFromAllFiles(String mesazhi) throws IOException {
		
		String oneLine = null;
		String twoLine;
		String fileName = "RSA2/";
		int counter = 0;
		
		File folder = new File("RSA2/");
		File[] listOfFiles = folder.listFiles();
		
		for (File file : listOfFiles) {
			
		    if (file.isFile()) {
				
		        FileReader theFile = new FileReader(fileName+file.getName());
                FileReader the = new FileReader(fileName+file.getName());
			
			    BufferedReader fileIn = new BufferedReader(theFile);
			    BufferedReader fileIn1 = new BufferedReader(the);
			    oneLine = fileIn.readLine();
				
				if(oneLine.contains(mesazhi)) {
					
						System.out.println( "Marresi: "  + file.getName());
						
					}		
			    }
			}
		
	} 
	
	
	public static void ImportPrivate(String filename) {
    	
    	
    	String XML_PRIVATE_FILENAME =  "RSA2/" + filename + "XmlPrivateKey.xml";
        String XML_PUBLIC_FILENAME = "RSA2/" + filename + "PublicKey.pub.xml";
    	
        
    	File file = new File(XML_PRIVATE_FILENAME);
    	File file1 = new File(XML_PUBLIC_FILENAME);
        
    	
         
        if(file.renameTo(new File("Keys/" + filename  + "privateKey.xml"))) 
        { 
        	if(file1.renameTo(new File("Keys/" + filename  + "publicKey.xml")))
           
               System.out.println("Celesi publik u ruajt ne fajllin Keys\\" +  filename + ".pub.xml"); 
			   System.out.println("Celesi privat u ruajt ne fajllin Keys\\" +  filename + ".xml"); 
        } 
        else
        { 
               System.out.println("Ky fajll nuk ekziston dhe nuk mund te importohet!"); 
        } 
    	
    }
	
	
	public static void removeRecord(String filepath, String removeTerm) {
		
		
		String tempFile = "temp.txt";
		
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		String username = "";
		String password = "";
		
		try {
			
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			
			
			while(x.hasNext()) {
				
				
				username = x.next();
				password = x.next();
				
				if(!username.equals(removeTerm)){
					
					
					pw.println(username + "," + password);
					
				}
				
				
			}
			
			x.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			
			File fajlli = new File(filepath);
			newFile.renameTo(fajlli);
			
			
			
		}
		catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error");
			
			
		}
		
		
	}
	
    }

package es.softtek.jwtDemo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.softtek.jwtDemo.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
