package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class AcceleratedSpoiling implements QualityAssessmentStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
	}
}
