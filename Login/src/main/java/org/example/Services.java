package org.example;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Services {

    public static  String hashing(String pass){
        MessageDigest instancedigest = null;
        try {
            instancedigest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = instancedigest.digest(pass.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static String checkhash(String pass){
       String valid = " ";
       System.out.println(pass);
       if(pass.equals("99800b85d3383e3a2fb45eb7d0066a4879a9dad0")){
           valid= "Succes";
           return  valid;
       }
       else {
           valid = "Fail";
           return valid;
       }
    }
    
}
