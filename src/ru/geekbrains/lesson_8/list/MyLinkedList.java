package ru.geekbrains.lesson_8.list;

import ru.geekbrains.lesson_8.list.iterator.GBIterator;

public class MyLinkedList implements MyList {
    private Node current;
    private Node first;
    private Node last;
    private int size;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public void add(String val) {
        current = new Node(null, val, null);
        if (first == null){
            last = current;
            first = current;
            size++;
            return;
        }
        addLast(last, val);
        size++;
    }

    private void addLast(Node last, String val){
        if (last.next == null){
            Node node = new Node(last, val, null);
            last.next = node;
            this.last = node;
            return;
        }
        addLast(last.next, val);
    }



    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
//            last = null;
            size--;
            return true;
        }

//        Node prevPrev = first.prev;
        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--;
                return true;
            }
//            prevPrev = current.prev;
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
//                "last=" + last +
                '}';
    }

    @Override
    public GBIterator iterator() {
        return new MyIterator(first, last);
    }

    //==================================================================================================================
    private static class Node {
        private Node prev;
        private String val;
        private Node next;

        private Node(Node prev, String val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
//                    "prev = " + prev +
                    "val = '" + val + '\'' +
                    ", next = " + next +
                    '}';
        }
    }

    //==================================================================================================================

    private static class MyIterator implements GBIterator {

        private Node first;
        private Node last;

        private MyIterator(Node first, Node last) {
            this.first = first;
            this.last = last;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public boolean hasPrevious() {
            return last != null;
        }

        @Override
        public String next() {
            String val = first.val;
            first = first.next;
            return val;
        }

        @Override
        public String previous() {
            String val = last.val;
            last = last.prev;
            return val;
        }
    }
}


