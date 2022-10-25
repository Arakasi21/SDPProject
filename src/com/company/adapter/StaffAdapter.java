package com.company.adapter;

import com.company.announcebot.IAnnounceBot;
import com.company.staff.Manager;
import com.company.staff.istaff;

import java.util.ArrayList;
import java.util.List;

public class StaffAdapter implements istaff {
    Manager manager;
    String name;

    public StaffAdapter(Manager manager){
        this.manager = manager;
        name = manager.getName();
    }

    String announcement;
    List<IAnnounceBot> announceBots = new ArrayList<IAnnounceBot>();


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addAnnouncement(String announceBot) {
        this.announcement = announcement;
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
    //в будущем будет работать для того чтобы добавить инструмент анонса
}
