package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class DoubleImproving implements QualityAssessmentStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();
		configurableItem.incrementQuality();
	}
}
