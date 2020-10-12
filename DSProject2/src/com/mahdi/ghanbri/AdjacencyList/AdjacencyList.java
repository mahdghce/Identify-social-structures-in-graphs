package com.mahdi.ghanbri.AdjacencyList;

import com.mahdi.ghanbri.NumberOfTerms;
import com.mahdi.ghanbri.NumberOfVertex;
import com.mahdi.ghanbri.ScoreNode;

import java.io.*;

public class AdjacencyList {
    private String filePath;
    private int vertex;
    private int terms;
    public LinkedList asjList[];
    private int removed;

    public Algorithm innerClass() {
        return new Algorithm();
    }

    public void writeUnConnected() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("C:\\Users\\Assassins\\Desktop\\result.txt", "UTF-8");
        for (int i = 1; i < asjList.length; i++) {
            if (asjList[i].isVisited()) {
                writer.println("A : " + asjList[i].getTag());
            } else writer.println("B : " + asjList[i].getTag());
//            ALNode temp1 = asjList[i].getFirst().getNext();
//            while (temp1 != null) {
//                if (temp1.isVisited()) {
//                    writer.println("A : " + temp1.getData());
//                } else writer.println("B : " + temp1.getData());
//                temp1 = temp1.getNext();
//            }
        }
        writer.println(System.currentTimeMillis());
        writer.println(Runtime.getRuntime().totalMemory());
        writer.close();
    }

    public boolean connected() {
        for (int i = 1; i < asjList.length; i++) {
            if (!asjList[i].isVisited()) {
                return true;
            }
//            ALNode temp2 = asjList[i].getFirst().getNext();
//            while (temp2 != null) {
//                if (!temp2.isVisited()) {
//                    return false;
//                }
//                temp2 = temp2.getNext();
//            }
        }
        return false;
    }

//    public void dfs(ALNode alNode) {
//        System.out.println(alNode.getData());
//        alNode.setVisited(true);
//        //asjList[alNode.getData()].getFirst().getNext().setVisited(true);
//        while (alNode != null) {
//            if (!asjList[alNode.getData()].getFirst().getNext().isVisited()) {
//                dfs(asjList[alNode.getData()].getFirst().getNext());
//            }
//            alNode = alNode.getNext();
//        }
//    }

    public void dfs(LinkedList linkedList) {
        //System.out.println(linkedList.getTag());
        linkedList.setVisited(true);
        ALNode temp = linkedList.getFirst().getNext();
        while (temp != null) {
            if (!asjList[temp.getData()].isVisited()) {
                dfs(asjList[temp.getData()]);
            }
            temp = temp.getNext();
        }

    }

    public class Algorithm {
        private ScoreNode[] scoreNodeArrayList = new ScoreNode[(terms / 2) - removed];

        Algorithm() {
            for (int i = 0; i < (terms / 2) - removed; i++) {
                scoreNodeArrayList[i] = new ScoreNode();
            }
        }

        public void unCheck() {
            for (int i = 1; i < asjList.length; i++) {
                asjList[i].setVisited(false);
//                ALNode temp2 = asjList[i].getFirst().getNext();
//                while (temp2 != null) {
//                    temp2.setVisited(false);
//                    temp2 = temp2.getNext();
//                }
            }
        }

        public void setScore() {
            int j = 0;
            for (int i = 0; i < asjList.length; i++) {
                ALNode temp = asjList[i].getFirst().getNext();
                while (temp != null) {
                    if (i < temp.getData() && existEdge(i, temp.getData())) {
                        this.scoreNodeArrayList[j].setI(i);
                        this.scoreNodeArrayList[j].setJ(temp.getData());
                        this.scoreNodeArrayList[j].setScore(ComputeCij(i, temp.getData()));
                        j++;
                    }
                    temp = temp.getNext();
                }

            }
        }

        public void remove(ScoreNode[] scoreNodeArrayList) {
            ALNode temp1 = asjList[scoreNodeArrayList[scoreNodeArrayList.length - 1].getI()].getFirst();
            ALNode temp2 = asjList[scoreNodeArrayList[scoreNodeArrayList.length - 1].getJ()].getFirst();
            while (temp1.getNext() != null) {
                if (temp1.getNext().getData() == scoreNodeArrayList[scoreNodeArrayList.length - 1].getJ()) {
                    temp1.setNext(temp1.getNext().getNext());
                    break;
                }
                temp1 = temp1.getNext();
            }

            while (temp2.getNext() != null) {
                if (temp2.getNext().getData() == scoreNodeArrayList[scoreNodeArrayList.length - 1].getI()) {
                    temp2.setNext(temp2.getNext().getNext());
                    break;
                }
                temp2 = temp2.getNext();
            }
            removed++;
        }

        double ComputeCij(int i, int j) {
            double k = min((ComputeDegree(i) - 1.0), (ComputeDegree(j) - 1.0));
            if (k == 0) {
                return 100;
            } else {
                return ((ComputeZij(i, j) + 1.0) / k);
            }
        }

        int ComputeZij(int i, int j) {
            int zij = 0;
            ALNode temp1 = asjList[i].getFirst().getNext();
            while (temp1 != null) {
                ALNode temp2 = asjList[j].getFirst().getNext();
                while (temp2 != null) {
                    if (temp1.getData() == temp2.getData())
                        zij++;
                    temp2 = temp2.getNext();
                }
                temp1 = temp1.getNext();
                //System.out.println(zij);
            }
            return zij;
        }

        double ComputeDegree(int i) {
            double degree = 0.0;
            ALNode temp = asjList[i].getFirst().getNext();
            while (temp != null) {
                degree++;
                temp = temp.getNext();
            }
            return degree;
        }

        boolean existEdge(int i, int j) {
            ALNode temp = asjList[i].getFirst().getNext();
            while (temp != null) {
                if (temp.getData() == j) {
                    return true;
                }
                temp = temp.getNext();
            }
            return false;
        }

        double min(double x, double y) {
            if (x < y) return x;
            else return y;
        }

        public ScoreNode[] getScoreNodeArrayList() {
            return scoreNodeArrayList;
        }

        public void setScoreNodeArrayList(ScoreNode[] scoreNodeArrayList) {
            this.scoreNodeArrayList = scoreNodeArrayList;
        }
    }

    public AdjacencyList(String filePath) {
        setFilePath(filePath);
        NumberOfVertex numberOfVertex = new NumberOfVertex();
        setVertex(numberOfVertex.findMaxVertex(getFilePath()));
        NumberOfTerms numberOfTerms = new NumberOfTerms();
        this.terms = numberOfTerms.numberOfTerms(getFilePath());
        setAsjList(new LinkedList[getVertex() + 1]);
        for (int i = 0; i < getAsjList().length; i++) {
            this.asjList[i] = new LinkedList();
        }
        this.removed = 0;
    }

    public void addEdge() {
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split(",");
                ALNode vertex1 = new ALNode();
                vertex1.setData(Integer.parseInt(part[1]));
                asjList[Integer.parseInt(part[0])].addNode(vertex1);
                asjList[Integer.parseInt(part[0])].setTag(Integer.parseInt(part[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void print() {
//        for (int i = 0; i < getAsjList().length; i++) {
//            ALNode alNode = getAsjList()[i].getFirst();
//            while (alNode.getNext() != null) {
//                System.out.println(alNode.getNext().getData());
//                alNode = alNode.getNext();
//            }
//        }
//    }

    private String getFilePath() {
        return filePath;
    }

    private void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private LinkedList[] getAsjList() {
        return asjList;
    }

    private void setAsjList(LinkedList[] asjList) {
        this.asjList = asjList;
    }

    private int getVertex() {
        return vertex;
    }

    private void setVertex(int vertex) {
        this.vertex = vertex;
    }
}
