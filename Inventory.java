import java.util.*;

public class Inventory {
    private Map<Rarity, ArrayList<Item>> itemsByRarity;

    public Inventory() {
        itemsByRarity = new HashMap<>();
        for (Rarity rarity : Rarity.values()) {
            itemsByRarity.put(rarity, new ArrayList<>());
        }
    }

    public void addItem(Item item) {
        itemsByRarity.get(item.getRarity()).add(item);
    }

    //Upgrades item according to the instructions, throws IllegalArgumentException when needed,
    // we could also create custom exception for this case
    public void upgradeItem(String itemName) throws IllegalArgumentException{
        Item targetItem = null;
        Rarity targetRarity = null;

        // Find the target item based on the name
        for (Rarity rarity : Rarity.values()) {
            for (Item item : itemsByRarity.get(rarity)) {
                if (item.getName().equals(itemName)) {
                    targetItem = item;
                    targetRarity = rarity;
                    break;
                }
            }
            if (targetItem != null) {
                break;
            }
        }

        // If no item found to upgrade
        if (targetItem == null) {
            throw new IllegalArgumentException("No such item to upgrade: " + itemName);
        }

        // Handle Epic item upgrade logic
        if (targetRarity == Rarity.EPIC) {
            if (targetItem.getUpgradeCount() == 0) {
                // Check if there are at least 2 Epic items to upgrade to Epic 1
                if (itemsByRarity.get(Rarity.EPIC).size() < 2) {
                    throw new IllegalArgumentException("Not enough Epic items to upgrade to Epic 1: " + itemName);
                }

                // Find and remove the second Epic item
                Iterator<Item> iterator = itemsByRarity.get(Rarity.EPIC).iterator();
                int count = 0;
                while (iterator.hasNext() && count < 1) {
                    Item item = iterator.next();
                    if (!item.equals(targetItem) && item.getName().equals(targetItem.getName())) {
                        iterator.remove(); // Remove the second Epic item
                        count++;
                    }
                }

                targetItem.upgradeEpic();  // Upgrade to Epic 1
                System.out.println("Upgraded to Epic 1: " + targetItem);
            } else if (targetItem.getUpgradeCount() == 1) {
                // Check if there are at least 2 Epic 1 items to upgrade to Epic 2
                if (itemsByRarity.get(Rarity.EPIC).size() < 2) {
                    throw new IllegalArgumentException("Not enough Epic 1 items to upgrade to Epic 2: " + itemName);
                }


                Iterator<Item> iterator = itemsByRarity.get(Rarity.EPIC).iterator();
                int count = 0;
                while (iterator.hasNext() && count < 1) {
                    Item item = iterator.next();
                    if (!item.equals(targetItem) && item.getName().equals(targetItem.getName())) {
                        iterator.remove();
                        count++;
                    }
                }

                targetItem.upgradeEpic();
                System.out.println("Upgraded to Epic 2: " + targetItem);
            } else if (targetItem.getUpgradeCount() == 2) {
                // Check if there are at least 3 Epic 2 items to upgrade to Legendary
                if (itemsByRarity.get(Rarity.EPIC).size() < 3) {
                    throw new IllegalArgumentException("Not enough Epic 2 items to upgrade to Legendary: " + itemName);
                }


                Iterator<Item> iterator = itemsByRarity.get(Rarity.EPIC).iterator();
                int count = 0;
                while (iterator.hasNext() && count < 2) {
                    Item item = iterator.next();
                    if (item.getName().equals(targetItem.getName())) {
                        iterator.remove();
                        count++;
                    }
                }

                targetItem.upgradeEpic();
                System.out.println("Upgraded to Legendary: " + targetItem);
            }
        }


        else {
            // Handle upgrade for non-Epic items based on their rarity
            if (itemsByRarity.get(targetRarity).size() < 3) {
                System.out.println("Not enough items to upgrade: " + itemName);
                return;
            }


            // Remove 3 items from the current rarity group
            int count = 0;
            Iterator<Item> iterator = itemsByRarity.get(targetRarity).iterator();
            while (iterator.hasNext() && count < 3) {
                Item item = iterator.next();
                if (item.getName().equals(targetItem.getName())) {
                    iterator.remove();
                    count++;
                }
            }

            // Upgrade the item to the next rarity using the next ordinal
            Rarity nextRarity = Rarity.values()[targetRarity.ordinal() + 1];
            Item upgradedItem = new Item(targetItem.getName(), nextRarity);
            addItem(upgradedItem);
            System.out.println("Upgraded: " + upgradedItem);
        }
    }



    public void displayInventory() {
        for (Rarity rarity : Rarity.values()) {
            System.out.println(rarity + ":");
            for (Item item : itemsByRarity.get(rarity)) {
                System.out.println(" - " + item);
            }
        }
    }
}
