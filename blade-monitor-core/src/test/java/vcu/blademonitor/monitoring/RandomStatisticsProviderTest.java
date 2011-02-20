package vcu.blademonitor.monitoring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import vcu.blademonitor.monitoring.MetricObject;
import vcu.blademonitor.monitoring.MetricStructure;
import vcu.blademonitor.monitoring.RandomStatisticsProvider;

public class RandomStatisticsProviderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testCreateRandomMetric() {
		int resourceLimit = 10;
		RandomStatisticsProvider provider = new RandomStatisticsProvider(resourceLimit);

		MetricStructure ms = provider.getStats();

		assertTrue(ms.getNodeName().equals("RandomNode"));
		assertEquals(resourceLimit, ms.listMetricNames().size());

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
