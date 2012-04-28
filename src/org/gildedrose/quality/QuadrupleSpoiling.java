package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class QuadrupleSpoiling implements QualityUpdateStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
		configurableItem.decrementQuality();
		configurableItem.decrementQuality();
		configurableItem.decrementQuality();
	}
}
