package vcu.blademonitor.monitoring;

import java.util.Random;

import org.joda.time.DateTime;

public class RandomStatisticsProvider implements StatisticsProvider {

	private final int resourceLimit;

	public RandomStatisticsProvider(int resourceLimit) {
		this.resourceLimit = resourceLimit;
	}

	@Override
	public MetricStructure getStats() {
		MetricStructure myMetric = new MetricStructure("RandomNode");
		Random generator = new Random();

		for (int i = 0; i < resourceLimit; i++) {
			String metricName = "RandomMetric_" + i;
			double metricValue = generator.nextInt(resourceLimit) + 1;
			DateTime metricTime = new DateTime();
			myMetric.addMetric(new MetricObject(metricName, metricValue,
					metricTime));
		}

		return myMetric;
	}

}
