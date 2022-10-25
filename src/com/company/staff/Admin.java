package com.company.staff;

import com.company.announcebot.IAnnounceBot;

import java.util.ArrayList;
import java.util.List;


public class Admin implements istaff{

    // по факту делает то же самое что и манагер, но после будет иметь возможность работать с инструментов (через адаптер) и будет как админ который управляет анонсами.
    String name;

    String announcement;
    List<IAnnounceBot> announceBots = new ArrayList<IAnnounceBot>();

    public Admin(String name) {
        this.name = name;
    }
    public Admin(){}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addAnnouncement(String announceBot) {

        this.announcement = (announcement);
        announce();

    }

    @Override
    public void addAnnounceBot(IAnnounceBot announceBot) {
        this.announceBots.add(announceBot);
    }

    @Override
    public void removeAnnounceBot(IAnnounceBot announceBot) {
        this.announceBots.remove(announceBot);

    }

    @Override
    public void announce() {
        for (IAnnounceBot announceBot : announceBots) {
           announceBot.update(this.announcement);
        }
    }

    @Override
    public List<IAnnounceBot> getAnnounceBots() {
        return announceBots;
    }

}
