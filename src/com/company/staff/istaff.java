package com.company.staff;

import com.company.announcebot.IAnnounceBot;

import java.util.List;

public interface istaff {
    public String getName();

    public void addAnnouncement(String announcement);

    public void addAnnounceBot(IAnnounceBot announceBot);

    public void removeAnnounceBot(IAnnounceBot announceBot);

    public void announce();

    public List<IAnnounceBot> getAnnounceBots();
}
