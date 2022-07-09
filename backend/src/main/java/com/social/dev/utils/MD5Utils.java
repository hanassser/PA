package com.social.dev.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Utils {

    public static String getPwd(String pwd) {
        try {
            // create encryption instance
            MessageDigest digest = MessageDigest.getInstance("md5");


            byte[] bs = digest.digest(pwd.getBytes());
            // Optimize the encrypted result

            String hexString = "";
            for (byte b : bs) {

                int temp = b & 255;

                if (temp < 16 && temp >= 0) {

                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


//    public static void main(String[] args) {
//        String pwd = MD5Utils.getPwd("234");
//        System.out.println(pwd);
//    }

}
