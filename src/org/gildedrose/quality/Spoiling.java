package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Spoiling implements QualityUpdateStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
	}
}
