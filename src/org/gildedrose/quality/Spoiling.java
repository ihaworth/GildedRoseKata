package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Spoiling implements QualityAssessmentStrategy
{
	@Override
	public void updateQuality(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
	}
}
