package com.company;

import com.company.gameplayer.IGame;
import com.company.singleton.Stats;
import com.company.factory.PlayerFactory;
import com.company.iterator.PlayerIterator;
import com.company.iterator.Iterator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //factory
        PlayerFactory playerFactory = new PlayerFactory();
        PlayerIterator playerIterator = new PlayerIterator();

        System.out.println("************ WELCOME TO THE AITU GAMING CLUB ADMIN PANEL ***********\n");

        System.out.println("*********************** Starting Panel *****************************\n");


        while (true) {
            //-----------------Starting Panel-----------------------
            System.out.println(
                    "Choose one option: \n" +
                            "1)Add player\n" +
                            "2)Add member\n" +
                            "3)Show information about players\n" +
                            "0)Close panel"
            );

            int choice = scanner.nextInt();
            //-------------------------------------------------------------------

            if (choice == 0) {
                System.out.println("*********************** Panel Is Closed *****************************\n");
                break;
            }

            //---------------------------Adding players----------------------
            if (choice == 1) {
                System.out.println("Choose game to witch one you want to add player:\n" +
                        "1)DOTA2 \n" +
                        "2)CS:GO\n"
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

            //--------------------------- Show Players ------------------------------
            if (choice == 3) {
                System.out.println("Select the information you are interested in :\n" +
                        "1)All players \n" +
                        "2)Dota2 players  \n" +
                        "3)Csgo players \n" +
                        "4)Go back \n"
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


        }
    }
}

