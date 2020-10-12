package com.mahdi.ghanbri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfTerms {
    public int numberOfTerms(String filePath) {
        int term = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((br.readLine()) != null) {
                term++;
            }
            return term;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return term;
    }
}
