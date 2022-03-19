package KatasSolution;

public class ShopInventoryManager {
    class Item{
        private String name;
        private int quality;
        private int sellIn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public int getSellIn() {
            return sellIn;
        }

        public void setSellIn(int sellIn) {
            this.sellIn = sellIn;
        }

        public Item(String name, int quality, int sellIn) {
            this.name = name;
            this.quality = quality;
            this.sellIn = sellIn;

        }
    }
    private Item[] item;

    public ShopInventoryManager(Item[] item) {
        super();
        this.item = item;
    }

    public void updateQuality() {
        for (int i = 0; i < item.length; i++) {
            if (item[i].getName() != "Aged Brie" && item[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                if (item[i].getQuality() > 0) {
                    if (item[i].getName() != "Sulfuras, Hand of Ragnaros") {
                        item[i].setQuality(item[i].getQuality() - 1);
                    }
                }
            } else {
                if (item[i].getQuality() < 50) {
                    item[i].setQuality(item[i].getQuality() + 1);
                    if (item[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (item[i].getSellIn() < 11) {
                            if (item[i].getQuality() < 50) {
                                item[i].setQuality(item[i].getQuality() + 1);
                            }
                        }
                        if (item[i].getSellIn() < 6) {
                            if (item[i].getQuality() < 50) {
                                item[i].setQuality(item[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }
            if (item[i].getName() != "Sulfuras, Hand of Ragnaros") {
                item[i].setSellIn(item[i].getSellIn() - 1);
            }
            if (item[i].getSellIn() < 0) {
                if (item[i].getName() != "Aged Brie") {
                    if (item[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item[i].getQuality() > 0) {
                            if (item[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                item[i].setQuality(item[i].getQuality() - 1);
                            }
                        }
                    } else {
                        item[i].setQuality(item[i].getQuality() - item[i].getQuality());
                    }
                } else {
                    if (item[i].getQuality() < 50) {
                        item[i].setQuality(item[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}