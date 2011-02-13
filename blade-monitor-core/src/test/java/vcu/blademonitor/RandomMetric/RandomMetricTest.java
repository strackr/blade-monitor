package vcu.blademonitor.RandomMetric;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import vcu.blademonitor.simpleMonitoringServices.MetricObject;
import vcu.blademonitor.simpleMonitoringServices.MetricStructure;

public class RandomMetricTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testCreateRandomMetric() {
		MetricStructure ms = RandomMetric.createRandomMetric();
		assertTrue(ms.getNodeName().equals("RandomNode"));

		MetricObject myMetricObject = null;
		ArrayList<String> myMetrics = (ArrayList<String>) ms.listMetricNames();
		for (int i = 0; i < myMetrics.size(); i++) {
			assertTrue(myMetrics.get(i).equals("RandomMetric_" + i));
			myMetricObject = ms.getMetrics("RandomMetric_" + i);

			assertTrue(myMetricObject.getName().equals("RandomMetric_" + i));
			assertTrue(myMetricObject.getTime() instanceof Date);
			assertTrue(myMetricObject.getValue() > 0);
		}
	}
}
