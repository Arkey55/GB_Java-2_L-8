package ru.geekbrains.lesson_8.list;

import ru.geekbrains.lesson_8.list.iterator.GBIterator;

public class MyLinkedList implements MyList {
    private Node currentElem;
    private Node lastElem;
    private int size;

    @Override
    public void add(String val) {
        Node current = new Node(null, val, null);
        if (currentElem == null){
            currentElem = current;
            lastElem = current;
            size++;
            return;
        }
        lastElem.next = current;
        current.prev = lastElem;
        lastElem = current;
        lastElem.next = null;
        size++;

    }

    @Override
    public boolean remove(String val) {
        if (currentElem.val.equals(val)) {
            Node node = currentElem;
            currentElem = node.next;
            currentElem.prev = null;
            size--;
            return true;
        }

        // не работает с обратной итерацией
        Node prev = currentElem;
        Node current = currentElem.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                //===============================
                Node last = lastElem;
                Node prevLast = lastElem.prev;
                while (prevLast != null){
                    if (prevLast.val.equals(val)){
                        last.setPrev(prevLast.prev);
                    }
                    last = prevLast;
                    prevLast = prevLast.prev;
                }
                //==============================
                size--;
                return true;
            }
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
        Node node = currentElem;
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
    public String toString() {
        return "MyLinkedList{" +
                "first=" + currentElem + "\n" +
                "last=" + lastElem +
                '}';
    }

    @Override
    public GBIterator iterator() {
        return new MyIterator(currentElem, lastElem);
    }

    //==================================================================================================================
    private static class Node {
        private Node prev;
        private String val;
        private Node next;

        public Node(String val) {
            this.val = val;
        }

        private Node(Node prev, String val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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


