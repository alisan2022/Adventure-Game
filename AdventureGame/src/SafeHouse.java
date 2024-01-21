public class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean getLocation() {
        player.setHealthy(player.getrHealthy());
        System.out.println("You're healed...");
        System.out.println("You're at Safe House now.");
        return true;
    }

}
