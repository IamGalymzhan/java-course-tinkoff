package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator {

    private List list = null;
    private int pointer = 0;

    public BackwardIterator(List list) {
        this.list = list;
        pointer = list.size();
    }

    @Override
    public boolean hasNext() {
        return pointer > 0;
    }

    @Override
    public Object next() {
        return list.get(--pointer);
    }
}
