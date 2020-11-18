package ru.geekbrains.lesson_8.simpleList;

public class Node {
    Node prev;
    Node next;
    String val;

    public Node(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
//                "prev=" + prev +
                ", val='" + val +
                ", next=" + next + '\'' +
                '}';
    }
}
