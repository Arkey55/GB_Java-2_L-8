package ru.geekbrains.lesson_8;

import ru.geekbrains.lesson_8.list.MyLinkedList;
import ru.geekbrains.lesson_8.list.MyList;
import ru.geekbrains.lesson_8.list.iterator.GBIterator;

public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("D");
        list.add("E");
//        System.out.println(((MyLinkedList) list).getFirst());
        System.out.println(((MyLinkedList) list).getLast());

        System.out.println(list);
        System.out.println("Get: " + list.get(2));
        list.remove("B");
        System.out.println(list);

        GBIterator iter = list.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
        }

        System.out.println("=======================");

        while (iter.hasPrevious()){
            String prev = iter.previous();
            System.out.println(prev);
        }
        System.out.println("=======================");
        System.out.println(list.size());
    }
}
