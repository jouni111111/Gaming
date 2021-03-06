package fi.academy;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Hello world!
 */
public class Game {
    Scanner sc = new Scanner(System.in);
    boolean passKey = false;

    public static void main(String[] args) {
        Game game = new Game();
        game.elevator1();

    }

    public void elevator1() { //JOONAS
        System.out.println("You are in an elevator and the doors are shut.");
        System.out.println("1: Open the doors");
        System.out.println("2: Do nothing");
        String choice = sc.nextLine();


        if (choice.equalsIgnoreCase("1")) {
            System.out.println("Behind the doorway is a dark hallway.");
            System.out.println("1: Go to the hallway.");
            System.out.println("2: Go back inside the elevator");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    hallway2();
                    break;
                case "2":
                    elevator1();
                    break;
                default:
                    System.out.println("The elevator doors close because you didn't do anything.");
                    elevator1();
                    break;
            }
        }

        else if (choice.equalsIgnoreCase("2")) {
            elevator1();
        }

        else {
            System.out.println("Not an option at this time.");
            elevator1();
        }
    }

    public void hallway2() { //Jouni
        System.out.println("You are in a hallway in front of elevators. " +
                "There is an open office to the west and " +
                "the hallway continues to the east." +
                "What would you like to do now?");
        System.out.println("1: Go west to the office space.");
        System.out.println("2: Go go east continuing the hallway.");
        System.out.println("3: Press the elevator button to enter the elevator in the south.");
        String choice = sc.nextLine();
        switch (choice) { //Joonas
            case "1":
                office3();
                break;
            case "2":
                hallway6();
                break;
            case "3":
                elevator1();
                break;
            default:
                hallway2();
                break;
        }
    }

    public void office3() { //Jouni
        System.out.println("You arrived in the office. " +
                "You see some desks and chairs, one laptop on the nearest desk.\n " +
                "There are some papers with coffee cup stains on the papers scattered on the floor." +
                "\nThere is a printer in the corner.\n" +
                "What would you like to do now?");
        System.out.println("1: Go west, there is a door opening to a smaller room by a glass wall.");
        System.out.println("2: Go to north, there is a door between two glass walls opening to a large room.");
        System.out.println("3: Go to northeast, there are doors to two toilets.");
        System.out.println("4: Go to east to a hallway in front of the elevators.");

        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                conference4();
                break;
            case "2":
                leasegreen5();
                break;
            case "3":
                System.out.println("Which toilet would you like to enter?");
                System.out.println("1: The toilet near to you.");
                System.out.println("2: the toilet further to northeast from you.");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("1")) {
                    toilet24();
                } else if (choice.equalsIgnoreCase("2")) {
                    toilet25();
                } else { //Joonas
                    System.out.println("You went back to the office.");
                }
                break;
            case "4":
                hallway2();
                break;
            default:
                office3();
                break;
        }
    }

    public void conference4() { //Jouni
        System.out.println("You are in a mid-size negotiating room. " +
                "There is a table with six chairs around it and a large monitor on the \n" +
                "north wall above the table. There is a window to the east, \n" +
                "the orange window shades are pulled open and some office buildings \n" +
                "can be seen from the window.\n" +
                "You see a door to the east. What do you want to do?\n");
        System.out.println("1: Go east to the office space.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            office3();
        }
        else {
            conference4();
        }
    }

    public void leasegreen5() { //Jouni
        System.out.println("You are in a semi large classroom. \n" +
                "There is a U-shaped table in the middle\n" +
                "and some tables also by the east side of the wall. \n" +
                "The windows open to the west and you can see some office \n" +
                "buildings with white walls from the window across the street. \n" +
                "The room may be leased; it has a greenish feeling... \n" +
                "What do you want to do?");
        System.out.println("1: Go south to the open office space.");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            office3();
        }
        else {
            leasegreen5();
        }

    }

    public void hallway6() { //Jouni
        System.out.println("You are in a hallway. There are elevators to the west.\n" +
                "To the east is a large open space surrounded by very cozy couches.\n" +
                "There is a large whitescreen to the south. The space is airy and \n" +
                "surrounded by windows to the south and east.\n" +
                "What do you want to do?");
        System.out.println("1: Go west to the hallway in front of the elevators.");
        System.out.println("2: Go east to the open space where the sofas are.");
        System.out.println("3: Go southwest to the exit door.");
        System.out.println("4: Go north to the hallway in front of toilets with a grey " +
                "hanging wall made of woollen material to the east of the hallway.");
        String choice = sc.nextLine();
        switch (choice) { //Joonas
            case "1":
                hallway2();
                break;
            case "2":
                couch7();
                break;
            case "3":
                exit23();
                break;
            case "4":
                hallway9();
                break;
            default:
                hallway6();
                break;
        }
    }

    public void couch7() { //Johanna
        System.out.println("You are in the livingroom. \n" +
                "There are large couches and chairs around you.");
        System.out.println("1: Go back to the hallway.");
        System.out.println("2: Go to the dining room.");
        System.out.println("3: Examine room. You might die.");
        String choice = sc.nextLine();
        switch (choice) { //Joonas
            case "1":
                hallway6();
                break;
            case "2":
                diningRoom8();
                break;
            case "3":
                System.out.println("You find nothing here.");
                couch7();
                break;
            default:
                couch7();
        }
    }

    public void diningRoom8(){ //Joonas
        System.out.println("You are in a hall. In the north there appears to be a kitchen.\n" +
                " In the south there are some couches.");
        System.out.println("1: Go north.");
        System.out.println("2: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                kitchen13();
                break;
            case "2":
                couch7();
                break;
            default:
                System.out.println("That is not an option.");
                diningRoom8();
                break;
        }
    }

    public void hallway9() { //Jouni
        System.out.println("You are in a hallway to the south there is a " +
                "hallway leading to west around the wall to the east you see a \n " +
                "thick grey woollen felt wall hanging from the roof. It looks \n " +
                "sturdy. To the northwest there is a door to a toilet and  \n " +
                "to west there is a door to a maintenance room.  To southwest \n " +
                "there is door to another toilet. To north there is a large open \n" +
                " kitchen, you can smell a nice aroma of coffee from the kitchen. \n" +
                "What do you want to do?");
        System.out.println("1: Go northwest to the toilet.");
        System.out.println("2: Go west to the maintenance room.");
        System.out.println("3: Go southwest to the other toilet.");
        System.out.println("4: Go north to the kitchen the aroma of coffee smells so very nice.");
        String choice = sc.nextLine();
        switch (choice) { //Joonas
            case "1":
                toilet12();
                break;
            case "2":
                maintenance11();
                break;
            case "3":
                toilet10();
                break;
            case "4":
                kitchen13();
                break;
            default:
                hallway9();
                break;
        }
    }

    public void toilet10 () { //Johanna
        System.out.println("You can't enter the loo, you fool!");
        hallway9();
    }

    public void maintenance11 () {
        System.out.println("The door is locked. You hear hushed sounds coming from the maintenance room!");
        hallway9();
    }

    public void toilet12 () { //Johanna
        System.out.println("You can't enter the loo, you fool!");
        hallway9();
    }

    public void kitchen13 () { //Johanna
        System.out.println("You enter the kitchen. What do you do?");
        System.out.println("1: Make yourself some coffee. ");
        System.out.println("2: Have a sandwich.");
        System.out.println("3: Leave the room.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                System.out.println("You drink your coffee and feel refreshed.");
                kitchen13();
                break;
            case "2":
                System.out.println("You devour someones sandwich from the fridge... Seriously?!");
                kitchen13();
                break;
            case "3":
                System.out.println("You decide to leave the kitchen. Where do you want to go?");
                System.out.println("1: Go north to the hallway to other rooms.");
                System.out.println("2: Go southwest to the hallway with exits to toilets.");
                System.out.println("3: Go south to the dining room with large white tables surrounded by nice chairs.");

                choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        hallway14a();
                        break;
                    case "2":
                        hallway9();
                        break;
                    case "3":
                        diningRoom8();
                        break;
                    default:
                        System.out.println("A troll eats you and you die. mwahaha.");
                        break;
                }
                break;
            default:
                kitchen13();
                break;
        }
    }

    public void hallway14a(){
        System.out.println("You are in a hallway. Hallway continues to the west. \n" +
                "There are two doors: one to the north and another to the east. \n" +
                "In the south there is a kitchen.");
        System.out.println("1: Go west.");
        System.out.println("2: Go north.");
        System.out.println("3: Go east.");
        System.out.println("4: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                hallway14b();
                break;
            case "2":
                accenture16();
                break;
            case "3":
                conference15();
                break;
            case "4":
                kitchen13();
                break;
            default:
                System.out.println("Not possible.");
                hallway14a();
        }
    }

    public void hallway14b() {
        System.out.println("You are in a hallway. Hallway continues to the north and to the east.\n" +
                " There is a door to the west. In the south there is a corner with a TV.");
        System.out.println("1: Go west.");
        System.out.println("2: Go north.");
        System.out.println("3: Go east.");
        System.out.println("4: Go south.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                cSharp20();
                break;
            case "2":
                hallway18();
                break;
            case "3":
                hallway14a();
                break;
            case "4":
                beanbags21();
                break;
            default:
                System.out.println("Not possible.");
                hallway14b();
        }
    }

    public void conference15 () { //Johanna
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14a();
        }
        else {
            hallway14a();
        }
    }

    public void accenture16 () { //Johanna
        System.out.println("It's a classroom. You notice that the air in the room is thick and stale.");
        System.out.println("1: Go back to the hallway.");
        System.out.println("2: You go to the thermostat.");
        System.out.println("3: You want to look around.");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                hallway14a();
                break;
            case "2":
                System.out.println("The air conditioning is broken.");
                accenture16();
                break;
            case "3.":
                System.out.println("There is currently nothing interesting in this room.");
                accenture16();
                break;
            default:
                accenture16();
                break;
        }
    }

    public void conference17() { //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
        else {
            conference17();
        }
    }

    public void hallway18() { //JOONAS
        System.out.println("You are in a hallway of some sort. There is an exit in the west. \n" +
                "There is also two rooms north and north-east. \n" +
                "The hallway continues southwards.");
        System.out.println("1: Try the exit door.");
        System.out.println("2: Go into the room in the north");
        System.out.println("3: Go into the room in the north-east");
        System.out.println("4: Go south through the hallway.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                exit22();
                break;
            case "2":
                conference19();
                break;
            case "3":
                conference17();
                break;
            case "4":
                hallway14b();
                break;
            default:
                System.out.println("That's not possible.");
                hallway18();
                break;
        }

    }

    public void conference19() { //JOONAS
        System.out.println("You are in a room. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway18();
        }
        else {
            conference19();
        }
    }

    public void cSharp20() { //Johanna
        System.out.println("You are in a classroom. There is currently nothing interesting in this room.");
        System.out.println("1: Go back to the hallway.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14b();
        }
        else {
            cSharp20();
        }
    }

    public void beanbags21() { //Jouni

        System.out.println("There are a few large and colourful beanbag chairs omn the floors.\n" +
                "They look very inviting. On the south wall there is a large monitor \n" +
                "where you see Fortnite running and waiting on a Playstation. \n" +
                "It appears even more inviting." +
                "What do you want to do?");
        System.out.println("1: Go to the north to a large open hallway.");
        System.out.println("2: Pick up a Playstation controller.");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            hallway14b();
        }

        else if (choice.equals("2")) {
            if (!passKey){
                System.out.println("The controller does not work, but you see a passkey. You take it with you. " +
                        "\nPerhaps it could be used to open some doors?");
                passKey = true;
                beanbags21();
            }

            else if (passKey) {
                System.out.println("The controller does not work.");
                beanbags21();
            }
        }

        else {
            beanbags21();
        }
    }

    public void exit22(){
        if (passKey) {
            System.out.println("Congratulations! You have succesfully exited the building.");
        }

        else {
            System.out.println("The door is locked.");
            hallway18();
        }
    }

    public void exit23(){
        if (passKey) {
            System.out.println("Congratulations! You have succesfully exited the building.");
        }

        else {
            System.out.println("The door is locked.");
            hallway6();
        }
    }

    public void toilet24() { //Johanna
        System.out.println("You can't enter the loo, you fool!");
        office3();
    }

    public void toilet25() { //Johanna
        System.out.println("You enter the toilet. As usual, there's no paper there. What do you do?");
        System.out.println("1: Leave the toilet. Try to find Maisa to help you. ");
        System.out.println("2: Leave the toilet. I didn't need to go anyway.");
        System.out.println("3: Use the toilet.");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                office3();
                break;
            case "2":
                office3();
                break;
            case "3":
                System.out.println("You flush the toilet. You hear a strange crackling sound\n" +
                        " coming from the wash basin.");
                System.out.println("1: Leave the toilet.");
                System.out.println("2: Check the wash basin.");
                System.out.println("3: Check under the wash basin.");

                choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        office3();
                        break;
                    case "2":
                        office3();
                        break;
                    case "3":
                        office3();
                        break;
                    default:
                        System.out.println("A troll eats you and you die. mwahaha.");
                        break;
                }
                break;
            default:
                office3();
                break;
        }
    }
}
