public class ToolStore extends NormalLoc {

    ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean getLocation() {
        System.out.println("Money : " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Quit");
        System.out.print("Your choice : ");
        int selTool = scan.nextInt();
        int selItemID;
        switch (selTool) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
        }

        return true;
    }

    public int armorMenu() {
        System.out.println("1. Lite \t <Money : 15 - Damage : 1>");
        System.out.println("2. Mid \t <Money : 25 - Damage : 3>");
        System.out.println("3. Heavy \t <Money : 40 - Damage : 5>");
        System.out.println("4. Quit");
        System.out.print("Choose a weapon : ");
        int selArmorID = scan.nextInt();
        return selArmorID;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                avoid = 1;
                aName = "Lite armor";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Mid armor";
                price = 15;
                break;
            case 3:
                avoid = 5;
                aName = "Heavy armor";
                price = 40;
                break;
            case 4:
                System.out.println("Quitting..");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought " +aName + ", Avoided Damage : " + player.getInv().getArmor());
                System.out.println("Money remaining :" + player.getMoney());
            } else {
                System.out.println("Amount is not enough to buy.");
            }
        }
    }

    public int weaponMenu() {
        System.out.println("1. Pistol\t<Money : 25 - Damage : 2>");
        System.out.println("2. Holy Sword\t<Money : 35 - Damage : 3>");
        System.out.println("3. Winchester\t<Money : 45 - Damage : 7>");
        System.out.println("4. Quit");
        System.out.print("Choose a weapon : ");
        int selWeaponID = scan.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Pistol";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Holy Sword";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Winchester";
                price = 45;
                break;
            case 4:
                System.out.println("Quitting..");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (price > 0) {
            if (player.getMoney() > price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought "+wName + ", Damage before the weapon :" + player.getDamage() + ", New Damage : "
                        + player.getTotalDamage());
                System.out.println("Money remaining :" + player.getMoney());
            } else {
                System.out.println("Amount is not enough to buy.");
            }
        }
    }

}
