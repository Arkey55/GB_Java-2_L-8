package ru.geekbrains.lesson_8.simpleList;

public class SimpleIterator implements MyIterator{
    Node current;
    Node last;

    public SimpleIterator(Node current, Node last) {
        this.current = current;
        this.last = last;
    }

    public boolean hasNext(){
         return current != null;
     }

    public String next (){
         String val = current.val;
         current = current.next;
         return val;
    }

    public boolean hasPrev (){
        return last != null;
    }

    public String prev (){
        String val = last.val;
        last = last.prev;
        return val;
    }
}
