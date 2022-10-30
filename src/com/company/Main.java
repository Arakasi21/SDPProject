package com.company;

import com.company.adapter.*;
import com.company.announcebot.*;
import com.company.iterator.*;
import com.company.factory.*;
import com.company.gameplayer.*;
import com.company.iterator.*;
import com.company.singleton.Stats;
import com.company.staff.*;
import com.company.workstrategy.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//swing / jframe gui
//    JFrame window;
//    Container con;
//    JPanel titleNamePanel;
//    JLabel titleNameLabel;
//    Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);

    public static void main(String[] args) {

        //new Main(); будущий jframe / swing
        ArrayList<istaff> admins = new ArrayList<istaff>();
        Admin admin = new Admin("admin");
        admins.add(admin);

        // factory
        PlayerFactory playerFactory = new PlayerFactory();

        // iterator
        PlayerIterator playerIterator = new PlayerIterator();

        // observer
        StaffIterator staffIterator = new StaffIterator();
        AnnounceBot first = new AnnounceBot("A");
        AnnounceBot second = new AnnounceBot("B");
        AnnounceBot third = new AnnounceBot("C");
        AnnounceBot fourth = new AnnounceBot("D");
        admin.addAnnounceBot(first);
        admin.addAnnounceBot(second);
        admin.addAnnounceBot(third);
        admin.addAnnounceBot(fourth);

        // Scanners
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        // Strategies
        DoMedia domedia = new DoMedia();
        DoEvent doevent = new DoEvent();

        String text = ("...................\n" + "........\n" + "************ WELCOME TO THE AITU GAMING CLUB ADMIN PANEL ***********\n");
        int k;
        for(k = 1; k < text.length(); k++){
            System.out.print(text.charAt(k));
            try{
                Thread.sleep(25);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

        String text2 = "*********************** Starting Panel *****************************\n";
        int k1;
        for(k1 = 1; k1 < text2.length(); k1++){
            System.out.print(text2.charAt(k1));
            try{
                Thread.sleep(25);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }



        while (true) { //бесконечный луп для того, чтобы наша панелька не останавливалась. Остановится когда choice = 0 / продолжается при continue  / brake
            //-----------------Начальная панель.-----------------------
            String text3 =
                    """
                             Choose one option:... \s
                            [1] Add player
                            [2] Add member
                            [3] Show information about players
                            [4] Show information about managers
                            [5] Switch the job of manager
                            [6] Promote manager to Admin
                            [7] Show map
                            [8] Show admin list
                            [9] AnnounceBot Control Panel
                            [0] Close panel\n"""
            ;
            int k2;
            for(k2 = 1; k2 < text3.length(); k2++){
                System.out.print(text3.charAt(k2));
                try{
                    Thread.sleep(5);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }

            int choice = scanner.nextInt();
            //-------------------------------------------------------------------

            if (choice == 0) {
                String text4 = "[*********************** Panel Is Closed *****************************\n";
                int k3;
                for(k3 = 1; k3 < text4.length(); k3++){
                    System.out.print(text4.charAt(k3));
                    try{
                        Thread.sleep(25);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                break;
            }

            //---------------------------Добавление игроков----------------------
            if (choice == 1) {
                System.out.println("""
                        Choose game to witch one you want to add player:
                        1)DOTA2\s
                        2)CS:GO
                        """
                );

                choice = scanner.nextInt();

                System.out.println("**************************************************\n");

                if (choice == 1) {
                    System.out.println("Type dota2 player name:");
                    String name = scanner.next();
                    playerFactory.createPlayer("DOTA2", name);
                    Stats.getStats().NumberOfPlayers++;
                    Stats.getStats().NumberOfDotaPlayers++;
                    continue;
                } else if (choice == 2) {
                    System.out.println("Type csgo player name:");
                    String name = scanner.next();
                    playerFactory.createPlayer("CSGO", name);
                    Stats.getStats().NumberOfPlayers++;
                    Stats.getStats().NumberOfCsgoPlayers++;
                    continue;
                }
                System.out.println("**************************************************\n");
            }
            //-------------------------------------------------------------------------------


            //---------------------------Добавление манагеров----------------------
            if (choice == 2) {
                System.out.println("Write name of new staff member:");
                String name = scanner.next();
                System.out.println("""
                        Choose the specialization for manager:\s
                        1)Doing event (manager)\s
                        2)Doing media (smm)\s
                        3)Go Back
                        """
                );

                choice = scanner.nextInt();

                if (choice == 1) {
                    StaffIterator.managers.add(new Manager(name, doevent));

                    Stats.getStats().NumberOfStaffMembers++;
                    Stats.getStats().NumberOfManagers++;

                } else if (choice == 2) {
                    StaffIterator.managers.add(new Manager(name, domedia));
                    Stats.getStats().NumberOfStaffMembers++;
                    Stats.getStats().NumberOfManagers++;

                } else if (choice == 3) {
                    System.out.println("Going back to start panel");
                    System.out.println("**************************************************");
                    continue;
                }

                System.out.println("**************************************************/n");
                continue;
            }
            //-------------------------------------------------------------------------------

            //--------------------------- Статистика / показывает стату ------------------------------
            if (choice == 3) {
                System.out.println("""
                        Select the information you are interested in :
                        1)All players\s
                        2)Dota2 players \s
                        3)Csgo players\s
                        4)Go back\s
                        """
                );
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("The number of all players:" + Stats.getStats().NumberOfPlayers);
                    for (Iterator iter = playerIterator.getIterator(); iter.hasNext(); ) {
                        IGame player = (IGame) iter.next();
                        System.out.println(player);
                    }
                    System.out.println("**************************************************\n");
                    continue;
                } else if (choice == 2) {
                    System.out.println("The number of Dota 2 players:" + Stats.getStats().NumberOfDotaPlayers);
                    for (Iterator iter = playerIterator.getIterator(); iter.hasNext(); ) {
                        IGame player = (IGame) iter.next();
                        if (player.getType().equals("Dota")) {
                            System.out.println(player);
                        }
                    }
                    System.out.println("**************************************************\n");
                    continue;
                } else if (choice == 3) {
                    System.out.println("The number of CSGO Players:" + Stats.getStats().NumberOfCsgoPlayers);
                    for (Iterator iter = playerIterator.getIterator(); iter.hasNext(); ) {
                        IGame player = (IGame) iter.next();
                        if (player.getType().equals("CSGO")) {
                            System.out.println(player);
                        }
                    }
                    System.out.println("**************************************************\n");
                    continue;
                } else if (choice == 4) {
                    System.out.println("Going back to start panel");
                    System.out.println("**************************************************\n");
                    continue;
                }

                System.out.println("**************************************************\n");
            }
            //-------------------------------------------------------------------------------


            //---------------------------Показать манагеров------------------------------
            if (choice == 4) {
                System.out.println("Number of managers:" + Stats.getStats().NumberOfManagers);

                Manager manager;
                for (Iterator iter = staffIterator.getIterator(); iter.hasNext(); ) {
                    manager = (Manager) iter.next();
                    System.out.print(" Name: " + manager.getName() + " "); // можно в будущем показывать еще айдишки. Оставлю пока код "ID: " + (iter.getIndex() - 1)
                    manager.work();
                }
                System.out.println("**************************************************\n");
            }


            //---------------------------Изменение работы------------------------------
            if (choice == 5) {
                System.out.println("Choose the manager:");
                Manager nameofman;
                int index = 0;
                for (Iterator iter = staffIterator.getIterator(); iter.hasNext(); ) {
                    nameofman = (Manager) iter.next();
                    System.out.print("ID: " + (iter.getIndex() - 1) + " Name: " + nameofman.getName() + "  ");
                    nameofman.work();
                    index = iter.getIndex();
                }

                if (index == 0) {
                    System.out.println("List of workers is empty");
                    continue;
                }
                int id = scanner.nextInt();
                if (id > index - 1) {
                    System.out.println("Manager not found");
                    continue;
                }

                System.out.println("Choose the work for the employee:\n" +
                        "1)Do Event \n" +
                        "2)Do Media \n" +
                        "3)Go Back\n"
                );
                choice = scanner.nextInt();
                System.out.println("**************************************************");

                if (choice == 1) {
                    Manager worker = new Manager(StaffIterator.managers.get(id).getName(), doevent);
                    StaffIterator.managers.set(id, worker);
                } else if (choice == 2) {
                    Manager worker = new Manager(StaffIterator.managers.get(id).getName(), domedia);
                    StaffIterator.managers.set(id, worker);
                }
            } else if (choice == 3) {
                System.out.println("Going back to start panel");
                System.out.println("**************************************************\n");
            }

            //-------------------------------------------------------------------------------
            //---------------------------Повысить манагера-----------------------------
            if (choice == 6) {
                Manager nameOfmanager;
                int index = 0;
                for (Iterator iter = staffIterator.getIterator(); iter.hasNext(); ) {
                    nameOfmanager = (Manager) iter.next();
                    System.out.print("ID: " + (iter.getIndex() - 1) + " Name: " + nameOfmanager.getName() + "  ");
                    nameOfmanager.work();
                    index = iter.getIndex();
                }
                System.out.println("Choose manager to made it admin:");
                int id = scanner.nextInt();
                if (id > index - 1) {
                    System.out.println("Manager not found");
                    System.out.println("**************************************************");
                    continue;
                }

                StaffAdapter staffAdapter = new StaffAdapter(StaffIterator.managers.get(id));
                StaffIterator.managers.remove(id);
                Stats.getStats().NumberOfManagers--;
                admins.add(staffAdapter);
                staffAdapter.addAnnounceBot(first);
                staffAdapter.addAnnounceBot(second);
                staffAdapter.addAnnounceBot(third);
                staffAdapter.addAnnounceBot(fourth);

                System.out.println("**************************************************");
                continue;
            }


            //---------------------------Показать карту------------------------------
            if (choice == 7) {
                System.out.println("This is a map of our club cabinet");
                //in future
                continue;
            }
            //-------------------------------------------------------------------------------


            if (choice == 8) {
                System.out.println("Manager list:");
                for (istaff iAdmin : admins) {
                    System.out.println(iAdmin.getName());
                }
                System.out.println("**************************************************");
            }

            //---------------------------Функции менеджера------------------------------
            if (choice == 9) {
                System.out.println("Write admin name:");
                String adminSelect = scanner2.next();
                istaff selectedAdmin = null;
                for (istaff iStaff : admins) {
                    if (iStaff.getName().equals(adminSelect)) {
                        selectedAdmin = iStaff;
                    }
                }
                if (selectedAdmin == null) {
                    System.out.println("Admin not found");
                    continue;
                }
                System.out.println("Choose what to do :\n" +
                        "1)Make an announce \n" +
                        "2)Turn on AnnounceBot  \n" +
                        "3)Turn off AnnounceBot \n" +
                        "4)Show active AnnounceBots \n" +
                        "5)Go back \n"
                );
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Write your announce. Write 'cancel' to cancel.");
                    String announce = scanner1.nextLine();
                    if (!announce.equals("cancel") && selectedAdmin != null) {
                        System.out.println(selectedAdmin.getName() + " notified that: ");
                        selectedAdmin.addAnnouncement(announce);
                    } else if (announce.equals("cancel")) {
                        System.out.println("Announcement was canceled");
                        continue;
                    } else {
                        System.out.println("Admin not found");
                        continue;
                    }
                    continue;
                } else if (choice == 2) {
                    System.out.println("Active AnnounceBots:");
                    for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                        System.out.println("Announce Bot at block: " + selectedAdmin.getAnnounceBots().get(i));
                    }
                    System.out.println("**************************************************");
                    System.out.println("Choose Announcement Bot to turn on\n" +
                            "Write 'first' to add Announcement Bot on block A\n" +
                            "Write 'second' to add Announcement Bot on block B\n" +
                            "Write 'third' to add Announcement Bot on block C\n" +
                            "Write 'fourth' to add Announcement Bot on block D\n"
                    );
                    String announcementbot = scanner1.next();
                    if (announcementbot.equals("first")) {
                        boolean exists = false;
                        for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                            if (selectedAdmin.getAnnounceBots().get(i).getCabinet().equals("A")) {
                                System.out.println("Announcement Bot on block A is already activated");
                                exists = true;
                                break;
                            }
                        }
                        if (exists == false) {
                            selectedAdmin.addAnnounceBot(first);
                        }
                        continue;
                    } else if (announcementbot.equals("second")) {
                        boolean exists = false;
                        for (int i = 0; i <selectedAdmin.getAnnounceBots().size(); i++) {
                            if (selectedAdmin.getAnnounceBots().get(i).getCabinet().equals("B")) {
                                System.out.println("Announcement Bot on block B is already activated");
                                exists = true;
                                break;
                            }
                        }
                        if (exists == false) {
                            selectedAdmin.addAnnounceBot(second);
                        }
                        continue;
                    } else if (announcementbot.equals("third")) {
                        boolean exists = false;
                        for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                            if (selectedAdmin.getAnnounceBots().get(i).getCabinet().equals("C")) {
                                System.out.println("Announcement Bot on block C is already activated");
                                exists = true;
                                break;
                            }
                        }
                        if (exists == false) {
                            selectedAdmin.addAnnounceBot(third);
                        }
                        continue;
                    } else if (announcementbot.equals("fourth")) {
                        boolean exists = false;
                        for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                            if (selectedAdmin.getAnnounceBots().get(i).getCabinet().equals("D")) {
                                System.out.println("Announcement Bot on block D is already activated");
                                exists = true;
                                break;
                            }
                        }
                        if (exists == false) {
                            selectedAdmin.addAnnounceBot(fourth);
                        }
                        continue;
                    } else {
                        System.out.println("AnnounceBot not found");
                        continue;

                    }
                } else if (choice == 3) {
                    System.out.println("Active AnnounceBots:");
                    for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                        System.out.println("AnnounceBot at block: " + selectedAdmin.getAnnounceBots().get(i));
                    }
                    System.out.println("**************************************************");
                    System.out.println("Choose Announcement Bot to turn off\n" +
                            "Write 'first' to off Announcement Bot on block A\n" +
                            "Write 'second' to off Announcement Bot on block B\n" +
                            "Write 'third' to off Announcement Bot on block C\n" +
                            "Write 'fourth' to off Announcement Bot on block D\n"
                    );
                    String announcebot = scanner1.next();
                    if (announcebot.equals("first")) {
                        selectedAdmin.removeAnnounceBot(first);
                    } else if (announcebot.equals("second")) {
                        selectedAdmin.removeAnnounceBot(second);
                    } else if (announcebot.equals("third")) {
                        selectedAdmin.removeAnnounceBot(third);
                    } else if (announcebot.equals("fourth")) {
                        selectedAdmin.removeAnnounceBot(fourth);
                    } else {
                        System.out.println("AnnounceBot not found");
                    }
                    continue;
                } else if (choice == 4) {
                    System.out.println("Active Announcement Bots:");
                    for (int i = 0; i < selectedAdmin.getAnnounceBots().size(); i++) {
                        System.out.println("Announcement Bot at block: " + selectedAdmin.getAnnounceBots().get(i));
                    }
                } else if (choice == 5) {
                    System.out.println("Going back to start panel");
                    continue;
                }
                System.out.println("**************************************************");
                continue;
            }
            //-------------------------------------------------------------------------------
        }
    }

//    public Main(){
//        window = new JFrame();
//        window.setSize(800,600);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.getContentPane().setBackground(new Color(51,51,51));
//        window.setLayout(null);
//        window.setVisible(true);
//        con = window.getContentPane();
//
//        titleNamePanel = new JPanel();
//        titleNamePanel.setBounds(100,100,600, 150);
//        titleNamePanel.setBackground(new Color(51,51,51));
//        titleNameLabel = new JLabel("************ WELCOME TO THE AITU GAMING CLUB ADMIN PANEL ***********");
//        titleNameLabel.setForeground(Color.BLACK);
//        titleNameLabel.setFont(titleFont);
//        titleNamePanel.add(titleNameLabel);
//        con.add(titleNamePanel);
//    }
}