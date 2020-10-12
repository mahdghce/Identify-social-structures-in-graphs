package com.mahdi.ghanbri.AdjacencyMatrix;

import com.mahdi.ghanbri.NumberOfVertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NormalMatrix {
    private boolean AMatrix[][];
    private String filePath;
    private int vertex;

    public NormalMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file address:");
        setFilePath(scanner.next());
        NumberOfVertex numberOfVertex = new NumberOfVertex();
        setVertex(numberOfVertex.findMaxVertex(getFilePath()));
        AMatrix = new boolean[getVertex() + 1][getVertex() + 1];
    }

    public void addEdge() {
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split("\t");
                AMatrix[Integer.parseInt(part[0])][Integer.parseInt(part[1])] = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean[][] getAMatrix() {
        return AMatrix;
    }

    public void setAMatrix(boolean[][] AMatrix) {
        this.AMatrix = AMatrix;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getVertex() {
        return vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
}
