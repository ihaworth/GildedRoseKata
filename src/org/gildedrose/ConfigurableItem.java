package org.gildedrose;

import org.gildedrose.ageing.AgeingStrategy;
import org.gildedrose.ageing.Mortal;
import org.gildedrose.quality.Spoiling;
import org.gildedrose.quality.QualityAssessmentStrategy;
import org.gildedrose.quality.postsellin.AcceleratedSpoiling;
import org.gildedrose.quality.postsellin.PostSellInQualityAssessmentStrategy;

public class ConfigurableItem extends Item
{
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;

	private QualityAssessmentStrategy qualityAssessmentStrategy;
	private AgeingStrategy ageingStrategy;
	private PostSellInQualityAssessmentStrategy postSellInQualityAssessmentStrategy;

	public ConfigurableItem(String name, int sellIn, int quality)
	{
		super(name, sellIn, quality);

		setDefaultStrategies();
	}

	private void setDefaultStrategies()
	{
		qualityAssessmentStrategy = new Spoiling();
		ageingStrategy = new Mortal();
		postSellInQualityAssessmentStrategy = new AcceleratedSpoiling();
	}

	public void setQualityAssessmentStrategy(QualityAssessmentStrategy qualityAssessmentStrategy)
	{
		this.qualityAssessmentStrategy = qualityAssessmentStrategy;
	}

	public void setAgeingStrategy(AgeingStrategy ageingStrategy)
	{
		this.ageingStrategy = ageingStrategy;
	}

	public void setPostSellInQualityAssessmentStrategy(PostSellInQualityAssessmentStrategy postSellInQualityAssessmentStrategy)
	{
		this.postSellInQualityAssessmentStrategy = postSellInQualityAssessmentStrategy;
	}

	
	void updateItem()
	{
		qualityAssessmentStrategy.updateQualityGenerally(this);
	
		ageingStrategy.updateSellInDate(this);
	
		if (pastSellInDate())
		{
		    postSellInQualityAssessmentStrategy.updateQualityPostSellInDate(this);
		}
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
