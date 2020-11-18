package ru.geekbrains.lesson_8.tests;

public class SimpleList implements MyIterable{
    private Node current;
    private Node lastElem;

    public void add (String val){
        Node node = new Node(val);
        if (current == null){
            current = node;
            lastElem = node;
            current.prev = null;
            lastElem.next = null;
        } else {
//            Node n = current;
//            while (n.next != null){
//                n = n.next;
//            }
//            n.prev = lastElem;
//            n.next = node;
//            lastElem = n;
////            last.prev = first;
            lastElem.next = node;
            node.prev = lastElem;
            lastElem = node;
            lastElem.next = null;
        }
    }

    public MyIterator iterator() {
        return new SimpleIterator(current, lastElem.next);
    }

    @Override
    public String toString() {
        return "SimpleList{" +
                "first=" + current +
                ", last=" + lastElem +
                '}';
    }
}
