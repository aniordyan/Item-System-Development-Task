# Item-System-Development-Task
To execute the code type in the command line
1. javac Item.java Inventory.java Main.java
2. java Main

(or just create new project in any IDE that supports Java and copy-paste the files)

some highlights:
- I used an enum for Rarity as it has fixed values, also to ensure type safety and easy expansion for new rarities in the future.
- I decided to split the requirments into two main classes: Item and Inventory as Inventory should use Item and they do not have any shared properties
- Items are stored in a Map where keys are rarities and values are ArrayList of items for efficient access, upgrade logic, and expansion. This choice simplifies item grouping and makes the upgrade process more efficient.
- I included some test cases in the Main class
- I did the optional part in a separate class RandomGenerator, because I did not want it to be together with the main functionality of the project(to execute it do javac RandomGenerator.java java RandomGenerator)
