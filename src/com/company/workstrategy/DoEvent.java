package com.company.workstrategy;

public class DoEvent implements IWork {
    public DoEvent(){};
    @Override
    public void work() {
        System.out.println("holds an event [Manager]");
    }
}
