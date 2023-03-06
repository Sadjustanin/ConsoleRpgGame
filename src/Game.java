import javax.swing.*;
import java.awt.*;

public class Game extends Character {
    private static StringBuilder forName = new StringBuilder();
    private static StringBuilder helper = new StringBuilder();

    //private static String[] yep = {"Yep","Yes","Ye","Yeah"};
    //private static String[] no = {"Nu","No","Nope","Nuh"};
    static JFrame window;
    static Container con;
    public static void main(String[] args) {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        System.out.print("Enter your name: ");
        Character vorobey = new Character(forName = new StringBuilder(sc.nextLine()));
        checkForNull(forName,"Enter your name: ");
        System.out.print("Do you want to change the name, " + vorobey.getPlayerName() + " ? ");
        cleanFor(forName);
        helper = new StringBuilder(sc.nextLine());
        if (helper.toString().equalsIgnoreCase("Yep")) changeTheName(vorobey);
        vorobey.setPlayerHealth(15);
        vorobey.setPlayerWeapon("Knife");
        System.out.println("========================================================================");

        System.out.println("Alright, " + vorobey.getPlayerName() + " , let's start the game!");

        System.out.println("========================================================================");
        WaitingInSec.waitingInSec(3);
        System.out.println("Currently you're in front of townguard");
        townguard(vorobey);
    }

    public static void checkForNull(StringBuilder some,String something) {
        if (some.isEmpty()) while (some.isEmpty()) {
            System.out.print(something);
            some = new StringBuilder(sc.nextLine());
        }
    }

    public static void cleanFor(StringBuilder something) {
        something.delete(0, something.length());
    }

    public static void townguard(Character vorobey) {
        WaitingInSec.waitingInSec(2);
        System.out.println("What do you want to do?");
        WaitingInSec.waitingInSec(1);
        System.out.println("1: Talk to the guard");
        WaitingInSec.waitingInSec(1);
        System.out.println("2: Attack the guard");
        WaitingInSec.waitingInSec(1);
        System.out.println("3: Leave");
        cleanFor(forName);
        forName = new StringBuilder(sc.nextLine());
        checkForNull(forName,"Please, choose the option: ");
        switch (forName.toString()) {
            case "1" -> {
                System.out.println("Guard: Hello there, stranger. So your name is " + vorobey.getPlayerName() + "? " + "\nSorry but we can't let stranger enter our town");
                townguard(vorobey);
            }
            case "2" -> {
                System.out.println("Guard: Hey don't be stupid. \nTHe guard hit you so hard and you gave up\n(You receive 1 damage)");
                vorobey.setPlayerHealth(vorobey.getPlayerHealth()-1);
                System.out.println("Your HP: " + vorobey.getPlayerHealth());
                townguard(vorobey);
            }
            case "3" -> crossRoad(vorobey);
            default -> townguard(vorobey);
        }
    }

    public static void crossRoad(Character vorobey) {
        System.out.println("====================================================================");
        System.out.println("You are at a crossroad. If you go south, you will go back to the town\n\n");
        System.out.println("""
                1: Go north
                2: Go east
                3: Go south
                4: Go west
                """);
        System.out.println("====================================================================");
        cleanFor(forName);
        forName = new StringBuilder(sc.nextLine());
        switch (forName.toString()) {
            case "1" -> townguard(vorobey);
            case "2" -> {
                System.out.println("You lost...");
                WaitingInSec.waitingInSec(3);
                System.out.println("Currently you're in front of townguard");
                townguard(vorobey);
            }
            case "3" -> {
                System.out.println("You don't know how but you came back to the town");
                townguard(vorobey);
            }
            case "4" -> System.out.println("In the pipeline!");
            default -> crossRoad(vorobey);
        }
    }

    public static void changeTheName(Character vorobey) {
        while (helper.toString().equalsIgnoreCase("Yep")) {
            checkForNull(helper,"Enter your name: ");
            cleanFor(helper);
            System.out.print("Enter your name: ");
            helper = new StringBuilder(sc.nextLine());
            System.out.print("Do you want to change the name, " + vorobey.getPlayerName() + " ? ");
            helper = new StringBuilder(sc.nextLine());
        }
    }
}