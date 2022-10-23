package com.company;

import com.company.gameplayer.IGame;

import com.company.iterator.StaffIterator;
import com.company.singleton.Stats;

import com.company.factory.PlayerFactory;

import com.company.iterator.PlayerIterator;
import com.company.iterator.Iterator;
import com.company.staff.Manager;

import com.company.workstrategy.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlayerFactory playerFactory = new PlayerFactory();

        PlayerIterator playerIterator = new PlayerIterator();
        StaffIterator staffIterator = new StaffIterator();

        DoMedia domedia = new DoMedia();
        DoEvent doevent = new DoEvent();

        System.out.println("[************ WELCOME TO THE AITU GAMING CLUB ADMIN PANEL ***********]\n");

            System.out.println("[*********************** Starting Panel *****************************]\\n");


        while (true) { //бесконечный луп для того, чтобы наша панелька не останавливалась. Остановится когда choice = 0 / продолжается при continue  / brake
            //-----------------Начальная панель.-----------------------
            //в будущем будут добавлены мемберы стаффа aitugaming
            System.out.println(
                    """
                            [Choose one option:... ]\s
                            [1] Add player
                            [2] Add member
                            [3] Show information about players
                            [4] Show information about managers
                            [5] Switch the job of manager
                            [6] Promote manager to Admin // in future // not added
                            [0] Close panel"""
            );

            int choice = scanner.nextInt();
            //-------------------------------------------------------------------

            if (choice == 0) {
                System.out.println("[*********************** Panel Is Closed *****************************]\n");
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

                }
                else if (choice == 3) {
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
                    for (Iterator iter = playerIterator.getIterator(); iter.hasNext();  ) {
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
            }
            //-------------------------------------------------------------------------------
        }
}

