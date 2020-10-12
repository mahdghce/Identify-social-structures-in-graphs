package com.mahdi.ghanbri.Sorts;

import com.mahdi.ghanbri.ScoreNode;

public class InsertionSort {

    public void insertionSort(ScoreNode array[]) {
        ScoreNode temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].getScore() > array[j - 1].getScore()) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
