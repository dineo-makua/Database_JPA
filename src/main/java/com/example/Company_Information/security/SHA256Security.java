package com.example.Company_Information.security;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Security {
    public static String generateSHA256Hash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(text.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "hello world";

        // Use class name directly to call the static method
        String hash = SHA256Security.generateSHA256Hash(input);

        System.out.println("SHA-256 hash (Java): " + hash);
    }
}
