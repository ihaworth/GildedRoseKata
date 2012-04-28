package org.gildedrose;

import java.util.ArrayList;
import java.util.List;

import org.gildedrose.ageing.Immortal;
import org.gildedrose.quality.DoubleImproving;
import org.gildedrose.quality.DoubleSpoiling;
import org.gildedrose.quality.Improving;
import org.gildedrose.quality.QuadrupleSpoiling;
import org.gildedrose.quality.TieredImprovement;
import org.gildedrose.quality.Undiminishing;
import org.gildedrose.quality.Worthless;

public class GildedRose {

	private static List<ConfigurableItem> items = null;

	public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = createItems();

        updateQuality(items);
	}

	private static List<ConfigurableItem> createItems()
	{
		ConfigurableItem agedBrie = createAgedBrie(2, 0);
        ConfigurableItem sulfuras = createSulfuras(0, 80);
        ConfigurableItem backstagePass = createBackstagePass(15, 20);
        ConfigurableItem conjuredManaCake = createConjuredManaCake(3, 6);

        List<ConfigurableItem> items = new ArrayList<ConfigurableItem>();
        items.add(new ConfigurableItem("+5 Dexterity Vest", 10, 20));
		items.add(agedBrie);
        items.add(new ConfigurableItem("Elixir of the Mongoose", 5, 7));
		items.add(sulfuras);
		items.add(backstagePass);
		items.add(conjuredManaCake);

        return items;
	}

	static ConfigurableItem createConjuredManaCake(int sellIn, int quality)
	{
		ConfigurableItem conjuredManaCake = new ConfigurableItem("Conjured Mana Cake", sellIn, quality);
		conjuredManaCake.setPreSellInQualityUpdateStrategy(new DoubleSpoiling());
		conjuredManaCake.setPostSellInQualityUpdateStrategy(new QuadrupleSpoiling());
		return conjuredManaCake;
	}

	static ConfigurableItem createBackstagePass(int sellIn, int quality)
	{
		ConfigurableItem backstagePass = new ConfigurableItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        backstagePass.setPreSellInQualityUpdateStrategy(new TieredImprovement());
        backstagePass.setPostSellInQualityUpdateStrategy(new Worthless());
		return backstagePass;
	}

	static ConfigurableItem createSulfuras(int sellIn, int quality)
	{
		ConfigurableItem sulfuras = new ConfigurableItem("Sulfuras, Hand of Ragnaros", sellIn, quality);
        sulfuras.setAgeingStrategy(new Immortal());
        sulfuras.setPreSellInQualityUpdateStrategy(new Undiminishing());
        sulfuras.setPostSellInQualityUpdateStrategy(new Undiminishing());
		return sulfuras;
	}

	static ConfigurableItem createAgedBrie(int sellIn, int quality)
	{
		ConfigurableItem agedBrie = new ConfigurableItem("Aged Brie", sellIn, quality);
        agedBrie.setPreSellInQualityUpdateStrategy(new Improving());
        agedBrie.setPostSellInQualityUpdateStrategy(new DoubleImproving());
		return agedBrie;
	}

    public static void updateQuality(List<ConfigurableItem> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            items.get(i).updateItem();
        }
    }
}