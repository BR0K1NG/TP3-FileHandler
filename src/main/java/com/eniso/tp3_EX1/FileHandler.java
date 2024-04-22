/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp3_EX1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Wael
 */
public class FileHandler {
    public String filePath;
    public Integer fileSizeinKb;
    public Integer numberOfLines ;
    public ArrayList<String>  fileContent;
    public FileHandler(String filePath) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
                this.filePath= filePath;
                this.fileSizeinKb=0;
                this.numberOfLines=0;
                this.fileContent = new ArrayList<>();
        }
        else {
            System.out.println("ERROR FILE NOT FOUND ");
        }
    }
    public void readFile() {
         try {
            fileContent = new ArrayList<>(Files.readAllLines(Paths.get(filePath)));
            fileSizeinKb = (int) (Files.size(Paths.get(filePath)) / 1024); 
            numberOfLines = fileContent.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> findLinesWithPattern(String pattern) { 
        Pattern p = Pattern.compile(pattern);
        ArrayList<String>  matchingLines = new ArrayList<> ();
        
        for (String line : fileContent) {
            Matcher m = p.matcher(line);       
                if (m.find()) {
                    matchingLines.add(line);
                  }
           }
        return matchingLines;
    }
    
    public boolean compareStrings1(String str1, String str2) {
       return str1.equals(str2);                                         //.equals: check if  two strings  are exactly equal
    }
    
    public boolean compareStrings2(String str1, String str2) {
       return str1.equalsIgnoreCase(str2);                  //.equalsIgnoreCase: check if  two strings  are exactly equal with ignoring the cases
    }
    public boolean compareStrings3(String str1, String str2) {
        return str1==str2;                                                              // str == str2 checks if both strings refer to the same object in memor
    }
    public void reverseString(int lineIndex)  {
         if (lineIndex >= 0 && lineIndex < fileContent.size()) {
            String reversedStr = new StringBuilder(fileContent.get(lineIndex)).reverse().toString();
            fileContent.set(lineIndex, reversedStr);
        } else {
            System.out.println("Invalid line index");
        }
    }


public void removeDuplicates(int lineIndex) {
    if (lineIndex >= 0 && lineIndex < fileContent.size()) {
        String originalLine = fileContent.get(lineIndex);
        
        LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
        for (char c : originalLine.toCharArray()) {
            uniqueChars.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : uniqueChars) {
            sb.append(c);
        }
        
        fileContent.set(lineIndex, sb.toString());
    } else {
        System.out.println("Invalid line index");
    }
}


}
