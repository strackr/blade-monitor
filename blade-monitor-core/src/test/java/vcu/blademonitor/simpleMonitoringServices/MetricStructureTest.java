package vcu.blademonitor.simpleMonitoringServices;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class MetricStructureTest {

	@Test
	public void test_checkConstructor() {
		MetricStructure ms = new MetricStructure();
		assertTrue(ms.getNodeName().equals("N/A"));
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
		MetricStructure ms = new MetricStructure("maste1");
		assertTrue(ms.addMetric("CPU Usage"));
		assertTrue(ms.setMetricValue("CPU Usage", "0.05"));
		Date now = Calendar.getInstance().getTime();
		assertTrue(ms.setMetricTime("CPU Usage", now.toString()));

		assertTrue(ms.listMetricNames().contains("CPU Usage"));
		assertTrue(ms.getMetrics("CPU Usage").contains("0.05"));
		assertTrue(ms.getMetrics("CPU Usage").contains(now.toString()));
	}

	@Test
	public void test_nodeRename() {
		MetricStructure ms = new MetricStructure("master1");
		ms.setNodeName("slave2");
		assertTrue(ms.getNodeName().equals("slave2"));
	}

	@Test
	public void test_noDups() {
		MetricStructure ms = new MetricStructure("master1");
		ms.addMetric("CPU Usage");
		assertTrue(ms.addMetric("CPU Usage") == false);
	}
}