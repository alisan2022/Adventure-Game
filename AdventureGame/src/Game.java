import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to our adventure !");
        System.out.println("Please enter your name: ");
        String playerName = scan.nextLine();
        player = new Player("a");
        player.selectCha();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Choose a place to commit action : ");
            System.out.println("1. Safe House --> A safe place with no enemies");
            System.out.println("2. Cave --> A zombie can appear");
            System.out.println("3. Forest --> A Vampire may appear");
            System.out.println("4. River --> A bear may appear");
            System.out.println("5. Store --> You can buy different kinds of weapon and armors");
            System.out.print("Place you want to go : ");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Enter a valid place : ");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Congrats you won !");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.println("Game Over");
                break;
            }

        }
    }
}