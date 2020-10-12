package com.mahdi.ghanbri.AdjacencyMatrix;

import com.mahdi.ghanbri.NumberOfTerms;
import com.mahdi.ghanbri.ScoreNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SparseMatrix {

    private int terms;
    private String filePath;
    private int SMArray[][];
    private int removedEdgeNumber;

    public SparseMatrix(String filePath) {
        NumberOfTerms numberOfTerms = new NumberOfTerms();
        this.filePath = filePath;
        this.terms = numberOfTerms.numberOfTerms(getFilePath());
        removedEdgeNumber = 0;
        setSMArray(new int[3][getTerms()]);
    }

    public Algorithm innerClass() {
        return new Algorithm();
    }

    public void addEdge() {
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            int n = 0;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                SMArray[0][n] = Integer.parseInt(part[0]);
                SMArray[1][n] = Integer.parseInt(part[1]);
                SMArray[2][n] = 1;
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Algorithm {
        private ScoreNode[] scoreNodeArrayList = new ScoreNode[(terms / 2) - removedEdgeNumber];

        public Algorithm() {
            for (int i = 0; i < (terms / 2) - removedEdgeNumber; i++) {
                scoreNodeArrayList[i] = new ScoreNode();
            }
        }

        public void score() {
            int j = 0;
            for (int i = 0; i < getTerms(); i++) {
                if (j < scoreNodeArrayList.length) {
                    if (SMArray[0][i] < SMArray[1][i] && existEdge(SMArray[0][i], SMArray[1][i])) {
                        double Cij;
                        int temp1 = degree(SMArray[1][i]) - 1;
                        int temp2 = degree(SMArray[0][i]) - 1;
                        if (temp1 == 0 || temp2 == 0) Cij = 100;
                        else Cij = (Zij(SMArray[0][i], SMArray[1][i]) + 1) / min(temp1, temp2);
                        scoreNodeArrayList[j].setI(SMArray[0][i]);
                        scoreNodeArrayList[j].setJ(SMArray[1][i]);
                        scoreNodeArrayList[j].setScore(Cij);
                        j++;
                    }
                }
            }
        }

        public int min(int x, int y) {
            if (x > y) return y;
            else return x;
        }

        public int Zij(int v1, int v2) {
            int z = 0;
            for (int i = 0; i < getTerms(); i++) {
                if (SMArray[0][i] == v1 && SMArray[1][i] == v2 && SMArray[2][i] == 1) {
                    for (int j = 0; j < getTerms(); j++) {
                        if (SMArray[0][j] == v1 && SMArray[2][j] == 1) {
                            for (int k = 0; k < getTerms(); k++) {
                                if (SMArray[1][j] == SMArray[1][k]) {
                                    if (SMArray[0][k] == v2)
                                        z++;
                                }
                            }

                        }
                    }
                    break;
                }
            }
            return z;
        }

        public int degree(int v) {
            int vertexDegree = 0;
            for (int i = 0; i < getTerms(); i++) {
                if (SMArray[0][i] == v) vertexDegree++;
            }
            return vertexDegree;
        }

        public boolean existEdge(int v1, int v2) {
            for (int k = 0; k < getTerms(); k++) {
                if (SMArray[0][k] == v1 && SMArray[1][k] == v2 && SMArray[2][k] == 1) {
                    return true;
                }
            }
            return false;
        }

        public void remove() {
            for (int k = 0; k < getTerms(); k++) {
                if (SMArray[1][k] == scoreNodeArrayList[scoreNodeArrayList.length - 1].getI() || SMArray[1][k] == scoreNodeArrayList[scoreNodeArrayList.length - 1].getJ())
                    SMArray[2][k] = 0;
            }
            removedEdgeNumber++;
        }

        public ScoreNode[] getScoreNodeArrayList() {
            return scoreNodeArrayList;
        }

        public void setScoreNodeArrayList(ScoreNode[] scoreNodeArrayList) {
            this.scoreNodeArrayList = scoreNodeArrayList;
        }

    }

    public void print() {
        for (int i = 0; i < getTerms(); i++) {
            System.out.println(SMArray[0][i]);
            System.out.println(SMArray[1][i]);
            System.out.println(SMArray[2][i]);
        }
    }

    public int[][] getSMArray() {
        return SMArray;
    }

    public void setSMArray(int[][] SMArray) {
        this.SMArray = SMArray;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
