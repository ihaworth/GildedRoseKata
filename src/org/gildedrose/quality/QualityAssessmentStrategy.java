package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public interface QualityAssessmentStrategy
{
	public abstract void updateQuality(ConfigurableItem configurableItem);
}
