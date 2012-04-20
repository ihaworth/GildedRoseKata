package org.gildedrose;

import java.util.LinkedList;

import org.junit.Before;

public class GildedRoseTst
{

	protected static final int MAX_QUALITY = 50;
	protected static final int ORIGINAL_QUALITY = 5;
	private LinkedList<Item> items;
	protected Item item;
	protected Item agedBrie;
	protected Item sulfuras;
	protected Item backstagePass;

	public GildedRoseTst()
	{
		super();
	}

	@Before
	public void setup()
	{
		items = new LinkedList<Item>();
		
		item = new Item("General Item", 5, 5);
		items.add(item);
	
		agedBrie = new Item("Aged Brie", 3, 5);
		items.add(agedBrie);
	
		sulfuras = new Item("Sulfuras, Hand of Ragnaros", 9, 9);
		items.add(sulfuras);
	
		backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 7);
		items.add(backstagePass);
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