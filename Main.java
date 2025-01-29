public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();


        Item commonSword1 = new Item("Iron Sword", Rarity.COMMON);
        Item commonSword2 = new Item("Iron Sword", Rarity.COMMON);
        Item commonSword3 = new Item("Iron Sword", Rarity.COMMON);

        inventory.addItem(commonSword1);
        inventory.addItem(commonSword2);
        inventory.addItem(commonSword3);


        Item greatSword1 = new Item("Iron Sword", Rarity.GREAT);
        Item greatSword2 = new Item("Iron Sword", Rarity.GREAT);

        inventory.addItem(greatSword1);
        inventory.addItem(greatSword2);


        System.out.println("before upgrade:");
        inventory.displayInventory();


        System.out.println("\nfrom Common to Great:");
        inventory.upgradeItem("Iron Sword");


        System.out.println("\nafter upgrade:");
        inventory.displayInventory();

        System.out.println("\nfrom Great to Rare:");
        inventory.upgradeItem("Iron Sword");

        System.out.println("\nafter upgrade:");
        inventory.displayInventory();


        Item rareSword = new Item("Iron Sword", Rarity.RARE);
        inventory.addItem(rareSword);
        Item rareSword2 = new Item("Iron Sword", Rarity.RARE);
        inventory.addItem(rareSword2);

        System.out.println("\nfrom Rare to Epic 0:");
        inventory.upgradeItem("Iron Sword");

        System.out.println("\nafter upgrade:");
        inventory.displayInventory();

        Item epicSword1 = new Item("Iron Sword", Rarity.EPIC);
        inventory.addItem(epicSword1);


        System.out.println("\nfrom epic0 to Epic 1:");
        inventory.upgradeItem("Iron Sword");

        System.out.println("\nafter upgrade:");
        inventory.displayInventory();

    }
}