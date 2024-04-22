/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp3_EX2;

/**
 *
 * @author Wael
 */
public class Main {
        public static void main(String[] args) {
        XORCipher xorCipher = new XORCipher("secretKey");
        
        String plaintext = "Hello, World!";
        String ciphertext = xorCipher.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        
        String decryptedText = xorCipher.decrypt(ciphertext);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
}
