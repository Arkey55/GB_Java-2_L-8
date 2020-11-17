package ru.geekbrains.lesson_8;

import ru.geekbrains.lesson_8.list.iterator.GBIterator;
import ru.geekbrains.lesson_8.list.GBList;
import ru.geekbrains.lesson_8.list.SingleLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");
        list.add("MAZDA");

        GBIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("==================");

        while (iterator.hasPrevious()){
            String prev = iterator.previous();
            System.out.println(prev);
        }
        System.out.println("==================");

        System.out.println("Get: " + list.get(2));

        System.out.println("Size before remove " + list.size());

        boolean isToyotaRemoved = list.remove("TOYOTA");
        System.out.println("Is toyota removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());

        System.out.println(list);
        System.out.println("==================");
        GBIterator iterator2 = list.iterator();
        while (iterator2.hasPrevious()){
            String prev = iterator2.previous();
            System.out.println(prev);
        }
    }
}
