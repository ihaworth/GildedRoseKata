package org.gildedrose.quality;

import org.gildedrose.ConfigurableItem;

public class Undiminishing implements QualityAssessmentStrategy
{
	@Override
	public void updateQualityGenerally(ConfigurableItem configurableItem)
	{
		// Do nothing as Items of Un-diminishing quality never change their quality.
	}
}
