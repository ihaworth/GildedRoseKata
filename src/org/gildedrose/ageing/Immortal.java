package org.gildedrose.ageing;

import org.gildedrose.ConfigurableItem;

public class Immortal implements AgeingStrategy
{
	@Override
	public void updateSellInDate(ConfigurableItem configurableItem)
	{
		// Do nothing for Immortal goods, they never age!
	}
}
