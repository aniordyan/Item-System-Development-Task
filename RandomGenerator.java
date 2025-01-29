import java.io.*;
import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static Item generateRandomItem(String itemName) {

        int rand = random.nextInt(100); // Get a random number between 0 and 99

        // Determine the rarity based on the random number
        Rarity rarity;
        if (rand < 50) {
            rarity = Rarity.COMMON;
        } else if (rand < 75) {
            rarity = Rarity.GREAT;
        } else if (rand < 90) {
            rarity = Rarity.RARE;
        } else if (rand < 98) {
            rarity = Rarity.EPIC;
        } else {
            rarity = Rarity.LEGENDARY;
        }

        // Create and return the new item
        return new Item(itemName, rarity);
    }

    //Creates database.txt file(if one does not exist) and writes to the file randomly generated items,
    //ones the file created new items would be appended to the existing file
    private static void writeItemToFile(Item item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
            writer.write(item.getRarity() + "," + item.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Item item1 = RandomGenerator.generateRandomItem("Iron Sword");
        RandomGenerator.writeItemToFile(item1);

        Item item2 = RandomGenerator.generateRandomItem("Steel Shield");
        RandomGenerator.writeItemToFile(item2);

        Item item3 = RandomGenerator.generateRandomItem("Golden Helmet");
        RandomGenerator.writeItemToFile(item3);
    }

}
