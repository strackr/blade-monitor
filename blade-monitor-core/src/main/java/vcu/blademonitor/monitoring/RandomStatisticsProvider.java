package vcu.blademonitor.monitoring;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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
			myMetric.addMetric(metricName);

			double metricValue = generator.nextInt(resourceLimit) + 1;
			myMetric.setMetricValue(metricName, metricValue);

			Date metricTime = Calendar.getInstance().getTime();
			myMetric.setMetricTime(metricName, metricTime);
		}

		return myMetric;
	}

}
