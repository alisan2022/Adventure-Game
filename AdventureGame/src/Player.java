
import java.util.Scanner;

public class Player {
    private int damage, health, money, rHealthy;
    private String name, cName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initalizePlayer("Samurai", 3, 10, 15);
                break;
            case 2:
                initalizePlayer("Archer", 6, 8, 22);
                break;
            case 3:
                initalizePlayer("Knight", 6, 13, 5);
                break;
            default:
                initalizePlayer("Samurai", 3, 10, 15);
                break;
        }
        System.out.println("Character is created. Name =" + getcName() + " ,Damage=" + getDamage() + " ,Health="
                + getHealthy() + " ,Money=" + getMoney());
    }

    public int chaMenu() {
        System.out.println("Please enter a character : ");
        System.out.println("1- Samurai \t Damage : 3 \t Health :10 \t Money :15");
        System.out.println("2- Archer \t Damage : 4 \t Health :8 \t Money :22");
        System.out.println("3- Knight \t Damage : 6 \t Health :13 \t Money :5");
        System.out.print("Your choice : ");
        int chaID = scan.nextInt();

        while (chaID < 1 || chaID > 3) {
            System.out.print("Please enter a valid character : ");
            chaID = scan.nextInt();
        }

        return chaID;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }

    public void initalizePlayer(String cName, int dmg, int hlth, int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlth);
        setMoney(mny);
        setrHealthy(hlth);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return health;
    }

    public void setHealthy(int healthy) {
        this.health = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

}