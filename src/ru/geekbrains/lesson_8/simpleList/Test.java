package ru.geekbrains.lesson_8.simpleList;

public class Test {
    public static void main(String[] args) {
        SimpleList list = new SimpleList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println(list);
        MyIterator iter = list.iterator();
        while (iter.hasNext()){
            String val = iter.next();
            System.out.println(val);
        }
        System.out.println("====================");

        while (iter.hasPrev()){
            String val = iter.prev();
            System.out.println(val);
        }
    }
}
