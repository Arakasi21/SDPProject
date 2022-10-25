package com.company.announcebot;

public class AnnounceBot implements IAnnounceBot{
    String cab;

    @Override
    public String getCabinet() {
        return cab;
    }

    public AnnounceBot(String cab) {
        this.cab = cab;
    }

    @Override
    public void update(String announcement) {
        System.out.println("Hello, dear staff, which located in  \n "+ cab + " We want to announce that"+ announcement + "\n");
    }

    @Override
    public String toString() {
        return cab;
    }
}
