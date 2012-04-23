package org.gildedrose.ageing;

import org.gildedrose.ConfigurableItem;

public interface AgeingStrategy
{
	public abstract void updateSellInDate(ConfigurableItem configurableItem);
}
