package com.company.factory;

import com.company.gameplayer.*;

public class PlayerFactory {

    public void createPlayer(String playerType, String name) {
        if (playerType.equalsIgnoreCase("CSGO")) {
            CSGO csgo = new CSGO(name);
           csgo.addToList(csgo);
        } else if (playerType.equalsIgnoreCase("DOTA2")) {
            DOTA2 dota = new DOTA2(name);
            dota.addToList(dota);
        }
    }
}
