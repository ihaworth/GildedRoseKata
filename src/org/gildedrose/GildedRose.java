package org.gildedrose;
import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
}


	
    public static void updateQuality(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
			if (item.getName() != "Aged Brie" && item.getName() != "Backstage passes to a TAFKAL80ETC concert")
            {
                if (item.getQuality() > 0)
                {
                    if (item.getName() != "Sulfuras, Hand of Ragnaros")
                    {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            }
            else // Aged Brie OR Backstage Pass
            {
                if (item.getQuality() < 50)
                {
                    incrementQuality(item);

                    if (item.getName() == "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                incrementQuality(item);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                incrementQuality(item);
                            }
                        }
                    }
                }
            }

            if (item.getName() != "Sulfuras, Hand of Ragnaros")
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (item.getName() != "Aged Brie")
                {
                    if (item.getName() != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (item.getQuality() > 0)
                        {
                            if (item.getName() != "Sulfuras, Hand of Ragnaros")
                            {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else // Must be Aged Brie!
                {
                    if (item.getQuality() < 50)
                    {
                        incrementQuality(item);
                    }
                }
            }
        }
    }



	private static void incrementQuality(Item item)
	{
		item.setQuality(item.getQuality() + 1);
	}
}