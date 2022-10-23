package com.company.staff;
import com.company.workstrategy.IWork;

public class Manager {
    IWork workstrategy;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager(String name, IWork workstrategy) {
        this.name = name;
        this.workstrategy= workstrategy;
    }

    public Manager(String name) {
        this.name = name;
    }

    public Manager() {
    }

    public void work() {
        workstrategy.work();
    }
}
