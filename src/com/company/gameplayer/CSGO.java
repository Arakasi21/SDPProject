package com.company.gameplayer;

import com.company.iterator.PlayerIterator;

public class CSGO implements IGame{

    String name;

    public CSGO(String name) {
        this.name = name;
    }

    public CSGO() {
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
        return "CSGO";
    }

    @Override
    public void addToList(IGame csgoplayer) {
        PlayerIterator.players.add(csgoplayer);

    }

    @Override
    public String text() {
            return "I am playing CS:GO";
    }

    @Override
    public String toString() {
        return "CSGO Player(name: " + name + ")";
    }
}
