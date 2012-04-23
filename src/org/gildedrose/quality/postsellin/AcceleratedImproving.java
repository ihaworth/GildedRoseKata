package org.gildedrose.quality.postsellin;

import org.gildedrose.ConfigurableItem;

public class AcceleratedImproving implements PostSellInQualityAssessmentStrategy
{
	@Override
	public void updateQualityPostSellInDate(ConfigurableItem configurableItem)
	{
		configurableItem.incrementQuality();
	}
}
