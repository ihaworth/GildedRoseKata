package org.gildedrose;

import org.gildedrose.ageing.AgeingStrategy;
import org.gildedrose.ageing.Mortal;
import org.gildedrose.quality.DoubleSpoiling;
import org.gildedrose.quality.QualityAssessmentStrategy;
import org.gildedrose.quality.Spoiling;

public class ConfigurableItem extends Item
{
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;

	private QualityAssessmentStrategy preSellInQualityAssessmentStrategy;
	private AgeingStrategy ageingStrategy;
	private QualityAssessmentStrategy postSellInQualityAssessmentStrategy;

	public ConfigurableItem(String name, int sellIn, int quality)
	{
		super(name, sellIn, quality);

		setDefaultStrategies();
	}

	private void setDefaultStrategies()
	{
		preSellInQualityAssessmentStrategy = new Spoiling();
		ageingStrategy = new Mortal();
		postSellInQualityAssessmentStrategy = new DoubleSpoiling();
	}

	public void setQualityAssessmentStrategy(QualityAssessmentStrategy qualityAssessmentStrategy)
	{
		this.preSellInQualityAssessmentStrategy = qualityAssessmentStrategy;
	}

	public void setAgeingStrategy(AgeingStrategy ageingStrategy)
	{
		this.ageingStrategy = ageingStrategy;
	}

	public void setPostSellInQualityAssessmentStrategy(QualityAssessmentStrategy postSellInQualityAssessmentStrategy)
	{
		this.postSellInQualityAssessmentStrategy = postSellInQualityAssessmentStrategy;
	}


	void updateItem()
	{
		ageingStrategy.updateSellInDate(this);

		if (beforeSellInDate())
		{
			preSellInQualityAssessmentStrategy.updateQuality(this);
		}
		else if (pastSellInDate())
		{
		    postSellInQualityAssessmentStrategy.updateQuality(this);
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
