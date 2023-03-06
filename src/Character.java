import java.util.Random;
import java.util.Scanner;

public class Character implements  WaitingInSec{
    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);
    private StringBuilder playerWeapon = new StringBuilder();
    private StringBuilder playerArmor = new StringBuilder();
    private StringBuilder playerName = new StringBuilder();
    private int playerHealth;
    public Character(){

    }
    public Character(StringBuilder playerName){
        this.playerName = new StringBuilder(playerName);
    }

    public StringBuilder getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = new StringBuilder(playerWeapon);
    }

    public StringBuilder getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(String playerArmor) {
        this.playerArmor = new StringBuilder(playerArmor);
    }

    public StringBuilder getPlayerName() {
        return playerName;
    }

    public void setPlayerName(StringBuilder playerName) {
        this.playerName = playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
    public void baseMonsterAttack() {
        playerHealth -= random.nextInt(1, 5);
    }

    }
