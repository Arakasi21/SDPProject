package com.company.iterator;


import com.company.staff.manager;


import java.util.ArrayList;

public class StaffIterator implements Collection {
    public static ArrayList<manager> managers = new ArrayList<>();

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < managers.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) return managers.get(index++);
            return null;
        }

        @Override
        public int getIndex() {
            return index;
        }
    }
}
