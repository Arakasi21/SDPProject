package com.company.singleton;

public class Stats {
    private static Stats stats;

    public int NumberOfPlayers;
    public int NumberOfDotaPlayers;
    public int NumberOfCsgoPlayers;
    public int NumberOfStaffMembers;
    public int NumberOfManagers;


    public static synchronized Stats getStats() {
        if (stats == null) {
            return stats = new Stats();
        }

        return stats;
    }

}
