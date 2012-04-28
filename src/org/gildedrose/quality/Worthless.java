package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Worthless implements QualityUpdateStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.zeroQuality();
	}
}
