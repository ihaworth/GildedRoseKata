package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Undiminishing implements QualityUpdateStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		// Do nothing as Items of Un-diminishing quality never change their quality.
	}
}
