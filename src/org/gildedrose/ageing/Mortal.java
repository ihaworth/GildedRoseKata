package org.gildedrose.ageing;

import org.gildedrose.ConfigurableItem;

public class Mortal implements AgeingStrategy
{
	@Override
	public void updateSellInDate(ConfigurableItem configurableItem)
	{
		configurableItem.decrementSellIn();
	}
}
