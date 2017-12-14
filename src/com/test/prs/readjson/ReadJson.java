package com.test.prs.readjson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("C:/Users/pupadhya/Documents/dataFile.json");
        BufferedReader inputStream = new BufferedReader(file);
        System.out.println(inputStream.readLine());
    }
}
