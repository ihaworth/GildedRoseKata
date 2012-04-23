package org.gildedrose.quality.postsellin;

import org.gildedrose.ConfigurableItem;

public class Worthless implements PostSellInQualityAssessmentStrategy
{
	@Override
	public void updateQualityPostSellInDate(ConfigurableItem configurableItem)
	{
		configurableItem.zeroQuality();
	}
}
