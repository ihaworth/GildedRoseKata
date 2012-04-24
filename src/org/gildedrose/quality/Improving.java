package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Improving implements QualityAssessmentStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();
	}
}
