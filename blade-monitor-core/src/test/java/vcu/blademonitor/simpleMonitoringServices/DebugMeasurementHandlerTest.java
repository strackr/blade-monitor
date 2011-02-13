package vcu.blademonitor.simpleMonitoringServices;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import vcu.blademonitor.RandomMetric.RandomMetric;

public class DebugMeasurementHandlerTest {
	private final static String lineSeparator = System
			.getProperty("line.separator");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testHandleMeasurement() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintStream printer = new PrintStream(output);
		System.setOut(printer);

		DebugMeasurementHandler myHandler = new DebugMeasurementHandler();
		myHandler.handleMeasurement(RandomMetric.createRandomMetric());

		printer.flush();
		String outputString = output.toString();

		// split the output on lineSeparators
		String[] lines = outputString.split(lineSeparator);

		// lines[0] is the nodeName (RandomNode in this case)
		assertTrue(lines[0].contains("RandomNode"));

		String regex = null;
		for (int i = 1; i < lines.length; i++) {
			// validate metric name
			regex = "Metric Name  -> RandomMetric_[0-9]+";
			assertTrue("*" + lines[i] + "* does not match *" + regex + "*",
					lines[i].matches(regex));
			i++;
			// validate metric value
			regex = "Metric Value -> [0-9]+.[0-9]+";
			assertTrue("*" + lines[i] + "* does not match *" + regex + "*",
					lines[i].matches(regex));
			i++;
			// validate metric time
			regex = "Metric Time  -> [a-zA-Z0-9: ]+";
			assertTrue("*" + lines[i]
					+ "* does not match *Metric Time  -> [a-zA-Z0-9: ]+*",
					lines[i].matches(regex));
		}
	}
}
