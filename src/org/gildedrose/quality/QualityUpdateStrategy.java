package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public interface QualityUpdateStrategy
{
	public abstract void updateQuality(ConfigurableItem configurableItem);
}
