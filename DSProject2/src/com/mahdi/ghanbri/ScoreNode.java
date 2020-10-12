package com.mahdi.ghanbri;

public class ScoreNode {
    private int i;
    private int j;
    private double score;
    private boolean exist;

    public ScoreNode() {
        this.i = 0;
        this.j = 0;
        this.score = -1;
        this.exist = false;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
