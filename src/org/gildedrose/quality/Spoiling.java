package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Spoiling implements QualityAssessmentStrategy
{
	@Override
	public void updateQualityGenerally(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
	}
}
