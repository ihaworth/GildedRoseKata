package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class TieredImprovement implements QualityAssessmentStrategy
{
	@Override
	public void updateQualityGenerally(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();

		if (configurableItem.getSellIn() < 11)
		{
			configurableItem.incrementQuality();
		}

		if (configurableItem.getSellIn() < 6)
		{
			configurableItem.incrementQuality();
		}
	}
}
