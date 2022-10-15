package com.company.iterator;

import com.company.gameplayer.IGame;

import java.util.ArrayList;


public class PlayerIterator implements Collection{
    public static ArrayList<IGame> players = new ArrayList<IGame>();

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < players.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) return players.get(index++);
            return null;
        }

        @Override
        public int getIndex() {
            return index;
        }
    }
}
