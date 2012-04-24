package org.gildedrose;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;

public class GildedRoseTst
{
	protected static final int MAX_QUALITY = 50;
	protected static final int ORIGINAL_QUALITY = 5;

	private List<ConfigurableItem> items;

	protected ConfigurableItem item;
	protected ConfigurableItem agedBrie;
	protected ConfigurableItem sulfuras;
	protected ConfigurableItem backstagePass;
	protected ConfigurableItem conjuredManaCake;

	public GildedRoseTst()
	{
		super();
	}

	@Before
	public void setup()
	{
		items = new LinkedList<ConfigurableItem>();

		item = new ConfigurableItem("General Item", 5, 5);
		items.add(item);

		agedBrie = GildedRose.createAgedBrie(3, 5);
		items.add(agedBrie);

		sulfuras = GildedRose.createSulfuras(9, 9);
		items.add(sulfuras);

		backstagePass = GildedRose.createBackstagePass(4, 7);
		items.add(backstagePass);

		conjuredManaCake = GildedRose.createConjuredManaCake(3, 6);
		items.add(conjuredManaCake);
	}

	protected void updateQuality()
	{
		GildedRose.updateQuality(items);
	}

	protected void sellByDateHasPassed()
	{
		item.setSellIn(0);
	}

}