package vcu.blademonitor.monitoring;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class MetricObjectTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testMetricObjectStringDoubleDateTime() {
		DateTime myDate = new DateTime();
		MetricObject myMetric = new MetricObject("Metric", 0.05, myDate);

		assertTrue(myMetric.getTime() == myDate);
		assertTrue(myMetric.getName().equals("Metric"));
		assertTrue(myMetric.getValue() == 0.05);
	}
}
