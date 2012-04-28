package org.gildedrose;

import org.gildedrose.ageing.AgeingStrategy;
import org.gildedrose.ageing.Mortal;
import org.gildedrose.quality.DoubleSpoiling;
import org.gildedrose.quality.QualityUpdateStrategy;
import org.gildedrose.quality.Spoiling;

public class ConfigurableItem extends Item
{
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;

	private QualityUpdateStrategy preSellInQualityUpdateStrategy;
	private AgeingStrategy ageingStrategy;
	private QualityUpdateStrategy postSellInQualityUpdateStrategy;

	public ConfigurableItem(String name, int sellIn, int quality)
	{
		super(name, sellIn, quality);

		setDefaultStrategies();
	}

	private void setDefaultStrategies()
	{
		preSellInQualityUpdateStrategy = new Spoiling();
		ageingStrategy = new Mortal();
		postSellInQualityUpdateStrategy = new DoubleSpoiling();
	}

	public void setPreSellInQualityUpdateStrategy(QualityUpdateStrategy qualityUpdateStrategy)
	{
		this.preSellInQualityUpdateStrategy = qualityUpdateStrategy;
	}

	public void setAgeingStrategy(AgeingStrategy ageingStrategy)
	{
		this.ageingStrategy = ageingStrategy;
	}

	public void setPostSellInQualityUpdateStrategy(QualityUpdateStrategy postSellInQualityUpdateAssessmentStrategy)
	{
		this.postSellInQualityUpdateStrategy = postSellInQualityUpdateAssessmentStrategy;
	}


	void updateItem()
	{
		ageingStrategy.updateSellInDate(this);

		if (beforeSellInDate())
		{
			preSellInQualityUpdateStrategy.updateQuality(this);
		}
		else if (pastSellInDate())
		{
		    postSellInQualityUpdateStrategy.updateQuality(this);
		}
	}

	private boolean beforeSellInDate()
	{
		return !pastSellInDate();
	}

	private boolean pastSellInDate()
	{
		return getSellIn() < 0;
	}

	public void decrementSellIn()
	{
		setSellIn(getSellIn() - 1);
	}

	public void decrementQuality()
	{
		if (getQuality() > MIN_QUALITY)
		{
			setQuality(getQuality() - 1);
		}
	}

	public void incrementQuality()
	{
		if (getQuality() < MAX_QUALITY)
		{
			setQuality(getQuality() + 1);
		}
	}

	public void zeroQuality()
	{
		setQuality(0);
	}
}
