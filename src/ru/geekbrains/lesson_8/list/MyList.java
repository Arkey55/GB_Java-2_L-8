package ru.geekbrains.lesson_8.list;

import ru.geekbrains.lesson_8.list.iterator.GBIterable;

public interface MyList extends GBIterable {
    void add(String val);
    boolean remove(String val);
    int size();
    String get(int index);
}
