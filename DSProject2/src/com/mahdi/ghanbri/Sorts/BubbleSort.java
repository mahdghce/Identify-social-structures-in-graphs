package com.mahdi.ghanbri.Sorts;

import com.mahdi.ghanbri.ScoreNode;

public class BubbleSort {

    public void bubbleSort(ScoreNode array[]) {
        int n = array.length;
        int k;
        for (int j = n; j >= 0; j--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i].getScore() < array[k].getScore()) {
                    swap(i, k, array);
                }
            }
        }
    }

    private static void swap(int i, int j, ScoreNode[] array) {
        ScoreNode temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
