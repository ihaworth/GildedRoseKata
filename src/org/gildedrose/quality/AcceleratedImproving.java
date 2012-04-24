package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class AcceleratedImproving implements QualityAssessmentStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();
	}
}
