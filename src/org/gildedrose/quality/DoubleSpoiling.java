package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class DoubleSpoiling implements QualityAssessmentStrategy
{
	@Override
	public void updateQualityGenerally(ConfigurableItem configurableItem)
	{
		configurableItem.decrementQuality();
		configurableItem.decrementQuality();
	}
}
