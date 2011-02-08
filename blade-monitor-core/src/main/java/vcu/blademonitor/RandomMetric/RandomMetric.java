package vcu.blademonitor.RandomMetric;

import java.util.Random;

import vcu.blademonitor.simpleMonitoringServices.MetricStructure;

public class RandomMetric {
	public MetricStructure createRandomMetric() {
		MetricStructure myMetric = new MetricStructure("RandomNode");
		Random generator = new Random();
		int loopLimit = generator.nextInt(10);

		String metricName;
		String metricValue;
		String metricTime;

		for (int i = 0; i < loopLimit; i++) {
			metricName = "RandomeMetric_" + i;
			myMetric.addMetric(metricName);

			metricValue = "RandomValue_" + generator.nextInt(10);
			myMetric.setMetricValue(metricName, metricValue);

			metricTime = "RandomTime_" + generator.nextInt(20) + 11;
			myMetric.setMetricTime(metricName, metricTime);
		}

		return myMetric;
	}
}