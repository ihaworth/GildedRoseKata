package org.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConjuredItemTest extends GildedRoseTst
{
	@Test
	public void conjuredItemsIncreaseInQualityTwiceAsFastAsNormal()
	{
		conjuredManaCake.setQuality(ORIGINAL_QUALITY);

		updateQuality();

		assertEquals(ORIGINAL_QUALITY - 2, conjuredManaCake.getQuality());
	}

	@Test
	public void conjuredItemsIncreaseInQualityTwiceAsFastAsNormalAfterSellInDate()
	{
		conjuredManaCake.setQuality(ORIGINAL_QUALITY);
		conjuredManaCake.setSellIn(0);

		updateQuality();

		assertEquals(ORIGINAL_QUALITY - 4, conjuredManaCake.getQuality());
	}
}
