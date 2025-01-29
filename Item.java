public class Item {
    private String name;
    private int upgradeCount;
    private Rarity rarity;


    public Item(String name, Rarity rarity){
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getUpgradeCount() {
        return this.upgradeCount;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void upgradeEpic(){
        if(this.rarity == Rarity.EPIC){
            if(getUpgradeCount() < 2) this.upgradeCount++;
        } else{
            setRarity(Rarity.LEGENDARY);
            this.upgradeCount = 0;
        }
    }


    public String toString() {
        return name + " (" + rarity + (rarity == Rarity.EPIC ? " " + getUpgradeCount(): "") + ")";
    }







}
