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
        System.out.println("Block " + cab + ": \n" + "Hello, dear staff,we want to announce that " + announcement + "\n");
    }

    @Override
    public String toString() {
        return cab;
    }
}
