package ru.geekbrains.lesson_8.list;

import ru.geekbrains.lesson_8.list.iterator.GBIterator;


public class SingleLinkedList implements GBList {
    private Node first;
    private Node last;
    private int size = 0;

//    @Override
//    public void add(String val) {
//        if (first == null) {
//            first = new Node(val);
//            return;
//        } else if (last == null){
////            add(first, val);
//            last = new Node(val);
//            return;
//        } else {
//            add(last, val);
//        }
//        size++;
//    }
//
//    private void add(Node last, String val) {
//        if (last.next == null) {
////            this.last = last;
//            last.next = new Node(this.last, val, null);
//            return;
//        }
//        add(last.next, val);
//    }
    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            last = current;
            current.next = new Node(last, val, null);
            return;
        }
        add(current.next, val);
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
//        int i = 0;
//        GBIterator iterator = iterator();
//        while (iterator.hasNext()) {
//            i++;
//        }
//        return i;
        return size;
    }

    @Override
    public String get(int index) {
        Node node = first;
        if (index == 0){
            return node.val;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (i == index - 1){
                return node.val;
            }
        }
        return null;
    }

    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(last, first);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }



    // =================================================================================================


    private static class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this(null, val, null);
        }

        public Node(Node prev, String val, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

//        public void setPrev(Node prev) {
//            this.prev = prev;
//        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }


    // =================================================================================================


    public static class StraightForwardIterator implements GBIterator {
        private Node current;
        private Node previous;

        public StraightForwardIterator(Node previous, Node current) {
            this.previous = previous;
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public String previous() {
            String val = previous.val;
            previous = previous.prev;
            return val;
        }
    }
}
