package vcu.blademonitor;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class MetricStructureTest {

	@Test
	public void test_checkConstructor() {
		MetricStructure ms = new MetricStructure();
		assertTrue(ms.getNodeName().equals("N/A"));
		assertTrue(ms.listMetricNames().size() == 0);
	}
	
	@Test
	public void test_checkConstructorWithParam()
	{
		MetricStructure ms = new MetricStructure("master1");
		assertTrue(ms.getNodeName().equals("master1"));
		assertTrue(ms.listMetricNames().size() == 0);
	}

	@Test
	public void test_metricSetup()
	{
		MetricStructure ms = new MetricStructure("maste1");
		assertTrue(ms.addMetric("CPU Usage"));
		assertTrue(ms.setMetricValue("CPU Usage", "0.05"));
		Calendar calendar = new Calendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		assertTrue(ms.setMetricTime(hour + ":" + minute + ":" + second));
		
		assertTrue(ms.listMetricNames().contains("CPU Usage"));
		assertTrue(ms.getMetric("CPU Usage").contains("0.05"));
		assertTrue(ms.getMetric("CPU Usage")
				.contains(hour + ":" + minute + ":" + second));
	}
	
	@Test
	public void test_nodeRename()
	{
		MetricStructure ms = new MetricStructure("master1");
		ms.setName("slave2");
		assertTrue(ms.getNodeName().equals("slave2"));
	}
	
	@Test
	public void test_noDups()
	{
		MetricStructure ms = new MetricStructure("master1");
		ms.addMetric("CPU Usage");
		assertTrue(ms.addMetric("CPU Usage") == false);
	}
}