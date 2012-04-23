package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class TieredImprovement implements QualityAssessmentStrategy
{
	@Override
	public void updateQualityGenerally(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();

		if (configurableItem.getSellIn() <= 10)
		{
			configurableItem.incrementQuality();
		}

		if (configurableItem.getSellIn() <= 5)
		{
			configurableItem.incrementQuality();
		}
	}
}
