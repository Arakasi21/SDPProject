package com.company.gameplayer;

import com.company.iterator.PlayerIterator;

public class DOTA2 implements IGame{

    String name;

    public DOTA2(String name) {
        this.name = name;
    }

    public DOTA2() {
    }

    @Override
    public void setName(String name) {

        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Dota";
    }

    @Override
    public void addToList(IGame dotaplayer) {
        PlayerIterator.players.add(dotaplayer);

    }

    @Override
    public String text() {
        return "I am playing DOTA 2";
    }

    @Override
    public String toString() {
        return name ;
    }
}
