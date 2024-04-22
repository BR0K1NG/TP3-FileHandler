/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp3_EX2;

/**
 *
 * @author Wael
 */
public class XORCipher {
    private final String key;
    public XORCipher(String key){
            this.key=key;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i % key.length());

            
            String plainBinary = String.format("%8s", Integer.toBinaryString(plainChar)).replace(' ', '0');
            String keyBinary = String.format("%8s", Integer.toBinaryString(keyChar)).replace(' ', '0');

           
            StringBuilder encryptedChar = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                encryptedChar.append(plainBinary.charAt(j) ^ keyBinary.charAt(j));
            }

            
            int encryptedInt = Integer.parseInt(encryptedChar.toString(), 2);
            ciphertext.append((char) encryptedInt);
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % key.length());

            
            String cipherBinary = String.format("%8s", Integer.toBinaryString(cipherChar)).replace(' ', '0');
            String keyBinary = String.format("%8s", Integer.toBinaryString(keyChar)).replace(' ', '0');

            
            StringBuilder decryptedChar = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                decryptedChar.append(cipherBinary.charAt(j) ^ keyBinary.charAt(j));
            }

            
            int decryptedInt = Integer.parseInt(decryptedChar.toString(), 2);
            decryptedText.append((char) decryptedInt);
        }

        return decryptedText.toString();
    }



}
