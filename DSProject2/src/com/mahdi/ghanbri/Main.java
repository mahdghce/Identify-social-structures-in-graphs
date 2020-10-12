package com.mahdi.ghanbri;

import com.mahdi.ghanbri.AdjacencyList.AdjacencyList;
import com.mahdi.ghanbri.AdjacencyMatrix.SparseMatrix;
import com.mahdi.ghanbri.Sorts.BubbleSort;
import com.mahdi.ghanbri.Sorts.InsertionSort;
import com.mahdi.ghanbri.Sorts.MergeSort;
import com.mahdi.ghanbri.Sorts.QuickSort;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //sparseMatrix.print();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the name of input file:");
        String filePath = scanner.next();
        SparseMatrix sparseMatrix = new SparseMatrix(filePath);
        sparseMatrix.addEdge();
        AdjacencyList adjacencyList = new AdjacencyList(filePath);
        adjacencyList.addEdge();
        System.out.println("What do u wanna do? (ENTER THE NUMBER)");
        System.out.println("1.RUN LinkedList Quick");
        System.out.println("2.RUN Matrix Quick");
        System.out.println("3.RUN LinkedList Insertion");
        System.out.println("4.RUN Matrix Insertion");
        System.out.println("5.RUN LinkedList Merge");
        System.out.println("6.RUN Matrix Merge");
        System.out.println("7.RUN LinkedList Bubble");
        System.out.println("8.RUN Matrix Bubble");
        System.out.println("9.RUN LinkedList Optimum Insertion N");
        System.out.println("10.RUN Matrix Optimum Insertion N");
        System.out.println("11.RUN LinkedList Optimum Bubble N");
        System.out.println("12.RUN Matrix Optimum Bubble N");
        String command = scanner.next();
        switch (command) {
            case "1":
                QuickSort quickSort = new QuickSort();
                while (true) {
                    AdjacencyList.Algorithm algorithm1 = adjacencyList.innerClass();
                    algorithm1.setScore();
                    quickSort.quickSort(algorithm1.getScoreNodeArrayList(), 0, algorithm1.getScoreNodeArrayList().length - 1);
                    algorithm1.remove(algorithm1.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm1.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "2":
                QuickSort quickSort2 = new QuickSort();
                while (true) {
                    AdjacencyList.Algorithm algorithm1 = adjacencyList.innerClass();
                    SparseMatrix.Algorithm algorithm2 = sparseMatrix.innerClass();
                    algorithm2.score();
                    algorithm1.setScore();
                    quickSort2.quickSort(algorithm1.getScoreNodeArrayList(), 0, algorithm1.getScoreNodeArrayList().length - 1);
                    algorithm1.remove(algorithm1.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm1.unCheck();
                }
                adjacencyList.writeUnConnected();
//                QuickSort quickSort1 = new QuickSort();
//                SparseMatrix.Algorithm algorithm1 = sparseMatrix.innerClass();
//                algorithm1.score();
//                quickSort1.quickSort(algorithm1.getScoreNodeArrayList(), 0, algorithm1.getScoreNodeArrayList().length - 1);
//                //algorithm1.remove();
//                ScoreNode[] jafar1 = algorithm1.getScoreNodeArrayList();
//                for (int i = 0; i < algorithm1.getScoreNodeArrayList().length; i++) {
//                    System.out.println(jafar1[i].getScore());
//                }
                break;
            case "3":
                InsertionSort insertionSort = new InsertionSort();
                while (true) {
                    AdjacencyList.Algorithm algorithm3 = adjacencyList.innerClass();
                    algorithm3.setScore();
                    insertionSort.insertionSort(algorithm3.getScoreNodeArrayList());
                    algorithm3.remove(algorithm3.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm3.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "4":
                InsertionSort insertionSort1 = new InsertionSort();
                while (true) {
                    SparseMatrix.Algorithm algorithm2 = sparseMatrix.innerClass();
                    algorithm2.score();
                    AdjacencyList.Algorithm algorithm3 = adjacencyList.innerClass();
                    algorithm3.setScore();
                    insertionSort1.insertionSort(algorithm3.getScoreNodeArrayList());
                    algorithm3.remove(algorithm3.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm3.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "5":
                MergeSort mergeSort = new MergeSort();
                while (true) {
                    AdjacencyList.Algorithm algorithm5 = adjacencyList.innerClass();
                    algorithm5.setScore();
                    algorithm5.setScoreNodeArrayList(mergeSort.mergeSort(algorithm5.getScoreNodeArrayList()));
                    algorithm5.remove(algorithm5.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm5.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "6":
                MergeSort mergeSort2 = new MergeSort();
                while (true) {
                    SparseMatrix.Algorithm algorithm2 = sparseMatrix.innerClass();
                    algorithm2.score();
                    AdjacencyList.Algorithm algorithm5 = adjacencyList.innerClass();
                    algorithm5.setScore();
                    algorithm5.setScoreNodeArrayList(mergeSort2.mergeSort(algorithm5.getScoreNodeArrayList()));
                    algorithm5.remove(algorithm5.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm5.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "7":
                BubbleSort bubbleSort = new BubbleSort();
                while (true) {
                    AdjacencyList.Algorithm algorithm7 = adjacencyList.innerClass();
                    algorithm7.setScore();
                    bubbleSort.bubbleSort(algorithm7.getScoreNodeArrayList());
                    algorithm7.remove(algorithm7.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm7.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            case "8":
                BubbleSort bubbleSort2 = new BubbleSort();
                while (true) {
                    SparseMatrix.Algorithm algorithm2 = sparseMatrix.innerClass();
                    algorithm2.score();
                    AdjacencyList.Algorithm algorithm7 = adjacencyList.innerClass();
                    algorithm7.setScore();
                    bubbleSort2.bubbleSort(algorithm7.getScoreNodeArrayList());
                    algorithm7.remove(algorithm7.getScoreNodeArrayList());
                    if (adjacencyList.asjList[1] != null) {
                        adjacencyList.dfs(adjacencyList.asjList[1]);
                    } else break;
                    if (adjacencyList.connected()) break;
                    algorithm7.unCheck();
                }
                adjacencyList.writeUnConnected();
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
}
