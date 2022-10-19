package com.company.staff;
import com.company.workstrategy.IWork;

public class manager {
    IWork workstrategy;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public manager(String name, IWork workstrategy) {
        this.name = name;
        this.workstrategy= workstrategy;
    }

    public manager(String name) {
        this.name = name;
    }

    public manager() {
    }

    public void work() {
        workstrategy.work();
    }
}
