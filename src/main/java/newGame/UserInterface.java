package newGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    final Character [] VOWEL_ARRAY = {'a','e','i','o','u','y','ä','ö'};
    final List<Character> VOWELS = new ArrayList<>(Arrays.asList(VOWEL_ARRAY));

    public void startTheUserInterface(Scanner sc, Player player, Location currentLocation, GameData gameData){

        //welcome player
        welcome(player, sc);

        while (true) {
            try {
                if (currentLocation.getName().substring(0, 4).equals("exit"))
                    winGame(player);
                if (player.isTooHungry()) {
                    currentLocation = resetGame(gameData,player);
                    gameOver(player, sc);
                }

                printCurrentLocation(currentLocation);
                printOptions(currentLocation, player);
                player.increaseInventorySize(gameData.getItems().get("bag")); //if they have a bag, their inventory-size is increased

                int command = Integer.parseInt(sc.nextLine());

                if (command > 0 && command < 10)
                    currentLocation = moveToLocation(player, currentLocation, sc, command);

                if (command == 11)
                    examineLocation(currentLocation, sc, player);

                if (command == 22)
                    checkInventory(sc, player, currentLocation);

                if (command == 999)
                    quitGame();

            } catch (Exception e) {
                System.out.println("Excuse me, but that is not a valid command. Please use only the options listed under <COMMANDS>.");
                System.out.println("====================================================");

            }
        }
    }

    private void gameOver(Player player, Scanner sc) {
        System.out.println("==================< GAME OVER >=====================");
        System.out.println(player + ", you passed out because you were too hungry. \nRemember to eat something next time!\n");
        System.out.println("....................................................");
        System.out.println("Would you like to try again?");
        while (true) {
            System.out.println("\t>1 - Yes");
            System.out.println("\t>2 - No");
            System.out.println("....................................................");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("OK, good luck!");
                for (int i = 0; i <10; i++) System.out.println(".");
                System.out.println("====================================================");
                return;
            }
            if (choice.equals("2")) { ;
                quitGame();
            }
            else {
                System.out.println("Sorry, not a valid command at this time. Would you like to restart the game or not?");
            }
        }
    }

    private Location resetGame(GameData gameData, Player player) {
        player.setHungerLevel(1);
        gameData.getLocations().get("hallway2").lockWithPasscode();
        return gameData.getLocations().get("elevator1");
    }

    private void quitGame() {
        System.out.println("====================================================");
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    public void welcome(Player player, Scanner sc) {
        System.out.println("==============< ESCAPE FROM ACADEMY >===============");
        System.out.print("Welcome to *Escape From Academy*! Please enter your name: ");
        player.setName(sc.nextLine());
        System.out.println("Ok " + player + ", let's start this game!");

        for (int i = 0; i<10; i++) {
            System.out.println(".");
        }
        System.out.println("====================================================");
    }

    private void printCurrentLocation(Location currentLocation) {
        System.out.println("<LOCATION>\n");
        if (VOWELS.contains(currentLocation.getName().charAt(0))){
            System.out.println("You are currently in an " + currentLocation + ".");
        }

        else {
            System.out.println("You are currently in a " + currentLocation);
        }
        System.out.println("....................................................");
    }

    public void printOptions(Location currentLocation, Player player){
        // 1-9) possible exits and their directions
        // 11) examine room (reveals a list of items in the room)
        // 12) check your inventory
        // 999) quit game


        String direction = null;
        System.out.println("<COMMANDS>");
        for (Integer directionNumber: currentLocation.getExits().keySet()) {
            switch (directionNumber) {
                case 1:
                    direction = "southwest";
                    break;
                case 2:
                    direction = "south";
                    break;
                case 3:
                    direction = "southeast";
                    break;
                case 4:
                    direction = "west";
                    break;
                case 6:
                    direction = "east";
                    break;
                case 7:
                    direction = "northwest";
                    break;
                case 8:
                    direction = "north";
                    break;
                case 9:
                    direction = "northeast";
                    break;
            }
            // getting the right article in front of items: a or an depending on the first letter
            if (VOWELS.contains(currentLocation.getExits().get(directionNumber).getName().charAt(0))) {
                System.out.println("\t>" + directionNumber + " - continue " + direction + " to an " + currentLocation.getExits().get(directionNumber));
            }

            else {
                System.out.println("\t>" + directionNumber + " - continue " + direction + " to a " + currentLocation.getExits().get(directionNumber));
            }
        }

        System.out.println("\t>11 - examine the " + currentLocation);
        System.out.println("\t>22 - check your inventory");
        System.out.println("\t>999 - quit game");
        System.out.println("====================================================");

    }

    public Location moveToLocation(Player player, Location currentLocation, Scanner sc, int command) {
        Location nextLocation = currentLocation.getExits().get(command);
        player.increaseHungerLevel();
        player.checkHungerLevel();

        if (nextLocation.isLocked()) {
            System.out.println(nextLocation + " is locked.");
            return currentLocation;
        }

        else if (nextLocation.isLockedWithPasscode()) {
            System.out.println("This door is locked with a passcode.");
            while (true) {
                player.checkHungerLevel();
                if (player.isTooHungry()) return currentLocation;
                player.increaseHungerLevel();

                System.out.print("Passcode: ");
                int passcode = Integer.parseInt(sc.nextLine());

                if (passcode == nextLocation.getPasscode()) {
                    System.out.println("....................................................");
                    System.out.println("\nCorrect! The door is now unlocked.");

                    nextLocation.openWithPasscode();
                    break;
                }
                else {
                    System.out.println("....................................................");
                    System.out.println("Wrong passcode! Try again?");
                    System.out.println("\t>1 - Yes");
                    System.out.println("\t>2 - No");
                    int choice = Integer.parseInt(sc.nextLine());

                    if (choice == 1) continue;
                    if (choice == 2) return currentLocation;
                }
            }

        }

        System.out.println("You left the " + currentLocation + " and moved to the " + nextLocation + ".\n");
        System.out.println("====================================================");
        return nextLocation;
    }

    public void examineLocation(Location currentLocation, Scanner sc, Player player) {
        System.out.println("....................................................");
        // if too hungry, can't do anything
        player.checkHungerLevel();
        if (player.isTooHungry()) return;

        System.out.println("<" + currentLocation.getName().toUpperCase() + ">\n");
        List<Item> roomItems = currentLocation.getItems();
        System.out.print(currentLocation.getDescription());
        System.out.println();
        if (roomItems.isEmpty()) {
            player.increaseHungerLevel();
            player.checkHungerLevel();
            if (player.isTooHungry()) return;
            System.out.println("There is nothing interesting in this " + currentLocation + ".");
        }

        else {
            System.out.println("The " + currentLocation + " seems to contain these items: ");
            for (Item item: roomItems) {
                String name = null;
                if (VOWELS.contains(item.getName().charAt(0))) {
                    name = "an " + item.getName();
                }

                else {
                    name = "a " + item.getName();
                }
                System.out.println("- " + name);
            }
            int commandIndex = 1;

            System.out.println("....................................................");
            System.out.println("<COMMANDS>");

            for (Item item: roomItems) {
                System.out.println("\t>" + commandIndex + " - examine the " + item + ".");
                commandIndex++;
            }
            System.out.println("\t>" + commandIndex + " - do nothing.");
            System.out.println("====================================================");

            int command = Integer.parseInt(sc.nextLine());
            int index = command-1;

            if (command <= roomItems.size()) {
                Item item = roomItems.get(index);
                examineItem(item,player,sc,currentLocation);
            }
        }
        System.out.println("....................................................");
    }

    public void checkInventory(Scanner sc, Player player, Location currentLocation) {
        System.out.println("....................................................");
        player.checkHungerLevel();
        if (player.isTooHungry()) return;
        player.increaseHungerLevel();

        System.out.println("<INVENTORY>\n");
        if (player.getInventory().size() == 0) {
            System.out.println("You don't have any items with you.");
            System.out.println("You can carry a maximum of " + player.getMaxInventorySize() + " items.");
            System.out.println("....................................................");
        }
        else {
            System.out.println("You currently carry these items: ");
            for (Item item: player.getInventory()) {
                System.out.println(item);
            }

            System.out.println("\nYou can carry a maximum of " + player.getMaxInventorySize() + " items.");
            System.out.println("....................................................");
            System.out.println("What would you like to do?");
            int commandIndex = 1;

            for (Item item: player.getInventory()) {
                System.out.println("\t>" + commandIndex + " - examine the " + item);
                commandIndex++;
            }

            for (Item item: player.getInventory()) {
                System.out.println("\t>" + commandIndex + " - leave the " + item + " in the " + currentLocation.getName());
                commandIndex++;
            }
            System.out.println("\t>" + commandIndex + " - do nothing.");
            System.out.println("====================================================");

            int command = Integer.parseInt(sc.nextLine());
            int index = command-1;

            if (command <= player.getInventory().size()) {
                System.out.println(player.getInventory().get(index).getDescription());
                System.out.println("....................................................");
                checkInventory(sc,player,currentLocation);
            }


            else if (command <= player.getInventory().size()*2) {
                index -= player.getInventory().size();
                Item item = player.getInventory().get(index);
                currentLocation.addItem(item);
                player.getInventory().remove(index);
                System.out.println("You left the " + item + " in the " + currentLocation);
                System.out.println("....................................................");
            }
        }
    }

    private void examineItem(Item item, Player player, Scanner sc, Location currentLocation) {
        player.checkHungerLevel();
        if (player.isTooHungry()) return;

        System.out.println(item.getDescription());
        System.out.println("....................................................");
        int commandIndex = 1;
        int foodCommand = 99999;
        int moveCommand = 99999;
        System.out.println("<COMMANDS>");
        if (item.isMovable()) {
            moveCommand = commandIndex;
            System.out.println("\t>" + (commandIndex++) + " - take the " + item + " with you.");
        }

        if (item.isConsumable()) {
            foodCommand = commandIndex;
            System.out.println("\t>" + (commandIndex++) + " - consume the " + item);
        }
        System.out.println("\t>" + (commandIndex) + " - do nothing.");
        System.out.println("====================================================");

        int command = Integer.parseInt(sc.nextLine());
        if (command == moveCommand) {
            takeItem(item,player,currentLocation);
        }
        if (command == foodCommand) {
            player.getInventory().remove(item);
            player.setHungerLevel(1);
            System.out.println("You consumed the " + item + ".");
        }

        examineLocation(currentLocation,sc,player);
    }

    private void takeItem(Item item, Player player, Location currentLocation) {

        player.checkHungerLevel();
        if (player.isTooHungry()) return;
        player.increaseHungerLevel();

        if (player.addItemToInventory(item)) {
            currentLocation.getItems().remove(item);
            System.out.println("You took the " + item + " with you.");
        }
        else {
            System.out.println("Sorry, you can't carry more than "  + player.getMaxInventorySize() + " items.");

        }

    }

    public void winGame(Player player) {
        System.out.println();
        String congratulations = "Pop the champagne "+ player + "!!! You got succesfully out of the building and won the game!";
        CowSay.callTheCow(congratulations);
        System.exit(0);
    }
}