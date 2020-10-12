package com.mahdi.ghanbri.AdjacencyList;

public class LinkedList {
    private ALNode first;
    private boolean visited;
    private int tag;

    LinkedList() {
        this.first = new ALNode();
        first.setData(-1);
        visited = false;
    }

    public void addNode(ALNode vertex) {
        ALNode temp = getFirst();
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(vertex);
    }

    public ALNode getFirst() {
        return first;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
