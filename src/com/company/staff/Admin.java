package com.company.staff;

import java.util.ArrayList;
import java.util.List;


public class Admin implements istaff{

    // по факту делает то же самое что и манагер, но после будет иметь возможность работать с инструментов (через адаптер) и будет как админ который управляет анонсами.
    String name;
    @Override
    public String getName() {
        return name;
    }
}
