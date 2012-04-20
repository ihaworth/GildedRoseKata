package org.gildedrose;

import static org.junit.Assert.*;


import org.junit.Test;

public class SulfrasTest extends GildedRoseTst
{		
	@Test
	public void sulfurasDoesNotDecreasesInQuality()
	{
		sulfuras.setQuality(ORIGINAL_QUALITY);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY, sulfuras.getQuality());
	}

	@Test
	public void sulfurasDoesNotDecreasesInQualityAfterItsSellByDate()
	{
		sulfuras.setSellIn(-1);
		sulfuras.setQuality(ORIGINAL_QUALITY);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY, sulfuras.getQuality());
	}
}
