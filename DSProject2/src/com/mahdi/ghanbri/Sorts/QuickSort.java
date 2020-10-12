package com.mahdi.ghanbri.Sorts;

import com.mahdi.ghanbri.ScoreNode;

public class QuickSort {

    public void quickSort(ScoreNode[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        ScoreNode pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i].getScore() > pivot.getScore()) {
                i++;
            }

            while (arr[j].getScore() < pivot.getScore()) {
                j--;
            }

            if (i <= j) {
                ScoreNode temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }
}
