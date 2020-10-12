package com.mahdi.ghanbri.Sorts;

import com.mahdi.ghanbri.ScoreNode;

public class MergeSort {

    public ScoreNode[] mergeSort(ScoreNode array[])
    {
        if (array.length > 1) {
            int i, mid = array.length / 2;
            ScoreNode[] half1 = new ScoreNode[mid];
            ScoreNode[] half2 = new ScoreNode[array.length - mid];
            for (i = 0; i < mid; i++)
                half1[i] = array[i];
            for (; i < array.length; i++)
                half2[i - mid] = array[i];
            half1 = mergeSort(half1);
            half2 = mergeSort(half2);
            int j = 0, k = 0;
            ScoreNode[] b = new ScoreNode[array.length];
            for (i = 0; j < half1.length && k < half2.length; i++)
                if (half1[j].getScore() > half2[k].getScore()) {
                    b[i] = half1[j];
                    j++;
                } else {
                    b[i] = half2[k];
                    k++;
                }
            for (; j < half1.length; i++, j++)
                b[i] = half1[j];
            for (; k < half2.length; i++, k++)
                b[i] = half2[k];
            return b;
        } else {
            ScoreNode[] b = new ScoreNode[1];
            b[0] = array[0];
            return b;
        }
    }
}
