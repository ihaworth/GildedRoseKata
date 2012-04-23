package org.gildedrose.quality.postsellin;

import org.gildedrose.ConfigurableItem;

public class AcceleratedSpoiling implements PostSellInQualityAssessmentStrategy
{
	@Override
	public void updateQualityPostSellInDate(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
	}
}
