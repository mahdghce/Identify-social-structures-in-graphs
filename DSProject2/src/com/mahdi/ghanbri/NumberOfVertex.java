package com.mahdi.ghanbri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfVertex {

    public int findMaxVertex(String filePath) {
        int max = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                if (max < Integer.parseInt(part[0]) || max < Integer.parseInt(part[1])) {
                    if (Integer.parseInt(part[0]) >= Integer.parseInt(part[1])) max = Integer.parseInt(part[0]);
                    else max = Integer.parseInt(part[1]);
                }
            }
            return max;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return max;
    }
}
