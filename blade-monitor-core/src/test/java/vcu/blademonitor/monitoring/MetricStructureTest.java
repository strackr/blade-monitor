package vcu.blademonitor.monitoring;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

public class MetricStructureTest {

	@Test
	public void test_checkConstructor() {
		MetricStructure ms = new MetricStructure("node1");
		assertTrue(ms.getNodeName().equals("node1"));
		assertTrue(ms.listMetricNames().size() == 0);
	}

	@Test
	public void test_checkConstructorWithParam() {
		MetricStructure ms = new MetricStructure("master1");
		assertTrue(ms.getNodeName().equals("master1"));
		assertTrue(ms.listMetricNames().size() == 0);
	}

	@Test
	public void test_metricSetup() {
		MetricStructure ms = new MetricStructure("master1");
		DateTime now = new DateTime();
		MetricObject temp = new MetricObject("CPU Usage", 0.05, now);
		ms.addMetric(temp);

		assertTrue(ms.listMetricNames().contains("CPU Usage"));
		assertTrue(ms.getMetrics("CPU Usage").getValue() == 0.05);
		assertTrue(ms.getMetrics("CPU Usage").getTime() == now);
	}

	@Test
	public void test_metricSetup2() {
		MetricStructure ms = new MetricStructure("maste1");

		assertTrue(ms.getMetrics("CPU Usage") == null);
	}

	@Test
	public void test_noDups() {
		MetricStructure ms = new MetricStructure("master1");
		MetricObject temp = new MetricObject("CPU Usage", 0.0, new DateTime());
		ms.addMetric(temp);
		assertTrue(ms.addMetric(temp) == false);
	}
}