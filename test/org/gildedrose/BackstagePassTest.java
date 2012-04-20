package org.gildedrose;

import static org.junit.Assert.*;


import org.junit.Test;

public class BackstagePassTest extends GildedRoseTst
{
	@Test
	public void backstagePassesIncreaseInQualityBy1WhenThereAreMoreThan10DaysLeft()
	{
		backstagePass.setQuality(ORIGINAL_QUALITY);
		backstagePass.setSellIn(11);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY + 1, backstagePass.getQuality());
	}

	@Test
	public void backstagePassesIncreaseInQualityBy2WhenThereAre10DaysOrFewer()
	{
		backstagePass.setQuality(ORIGINAL_QUALITY);
		backstagePass.setSellIn(10);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY + 2, backstagePass.getQuality());
	}

	@Test
	public void backstagePassesAreNeverMoreValueableThan50WhenThereAre10DaysOrFewer()
	{
		backstagePass.setQuality(MAX_QUALITY - 1);
		backstagePass.setSellIn(10);
		
		updateQuality();
		
		assertEquals(MAX_QUALITY, backstagePass.getQuality());
	}

	@Test
	public void backstagePassesIncreaseInQualityBy3WhenThereAre5DaysOrFewer()
	{
		backstagePass.setQuality(ORIGINAL_QUALITY);
		backstagePass.setSellIn(5);
		
		updateQuality();
		
		assertEquals(ORIGINAL_QUALITY + 3, backstagePass.getQuality());
	}

	@Test
	public void backstagePassesAreNeverMoreValueableThan50WhenThereAre5DaysOrFewer()
	{
		backstagePass.setQuality(MAX_QUALITY - 2);
		backstagePass.setSellIn(5);
		
		updateQuality();
		
		assertEquals(MAX_QUALITY, backstagePass.getQuality());
	}

	@Test
	public void backstagePassesAreOfZeroValueAfterTheConcert()
	{
		backstagePass.setQuality(ORIGINAL_QUALITY);
		backstagePass.setSellIn(0);
		
		updateQuality();
		
		assertEquals(0, backstagePass.getQuality());
	}
}
