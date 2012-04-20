package org.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AgedBrieTest extends GildedRoseTst
{	
	@Test
	public void agedBrieIncreasesInQualityTheOlderItGets()
	{
		agedBrie.setQuality(ORIGINAL_QUALITY);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY + 1, agedBrie.getQuality());
	}

	@Test
	public void agedBrieIncreasesInQualityTwiceAsFastAfterItsSellInDate()
	{
		agedBrie.setSellIn(-1);
		agedBrie.setQuality(ORIGINAL_QUALITY);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY + 2, agedBrie.getQuality());
	}

	@Test
	public void theQualityOfAgedBrieBeforeItsSellInDateIsNeverMoreThan50()
	{
		agedBrie.setQuality(MAX_QUALITY);
		
		updateQuality();
		
		assertEquals(MAX_QUALITY, agedBrie.getQuality());
	}

	@Test
	public void theQualityOfAgedBrieAfterItsSellInDateIsNeverMoreThan50()
	{
		agedBrie.setSellIn(-1);
		agedBrie.setQuality(MAX_QUALITY - 1);
		
		updateQuality();
		
		assertEquals(MAX_QUALITY, agedBrie.getQuality());
	}
}
