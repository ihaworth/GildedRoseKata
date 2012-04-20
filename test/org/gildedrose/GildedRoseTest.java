package org.gildedrose;

import static org.junit.Assert.*;


import org.junit.Test;

public class GildedRoseTest extends GildedRoseTst
{
	@Test
	public void atTheEndOfEachDayTheQualityIsReducedByOne()
	{
		item.setQuality(10);
		
		updateQuality();
		
		assertEquals(9, item.getQuality());
	}
	
	@Test
	public void atTheEndOfEachDayTheSeeByDateIsReducedByOne()
	{
		item.setSellIn(5);
		
		updateQuality();
		
		assertEquals(4, item.getSellIn());
	}
	
	@Test
	public void onceTheSellByDateHasPassedTheQualityDegradesTwiceAsFast()
	{
		sellByDateHasPassed();
		item.setQuality(10);
		
		updateQuality();
		
		assertEquals(8, item.getQuality());
	}

	@Test
	public void theQualityOfAnItemIsNeverNegative()
	{
		item.setQuality(0);
		
		updateQuality();
		
		assertEquals(0, item.getQuality());
	}
	
	@Test
	public void theQualityOfAnItemIsNeverNegativeEvenAfterTheSellInDate()
	{
		item.setSellIn(-1);
		item.setQuality(0);
		
		updateQuality();
		
		assertEquals(0, item.getQuality());
	}
}
