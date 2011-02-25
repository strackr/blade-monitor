package vcu.blademonitor.monitoring;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SingleExecutionMonitoringServiceTest {

	private final SingleExecutionMonitoringService service = new SingleExecutionMonitoringService();

	@Test
	public void shouldCollectStats() {
		MetricStructure measurement = new MetricStructure("node1");
		StatisticsProvider provider = mock(StatisticsProvider.class);
		when(provider.getStats()).thenReturn(measurement);
		MeasurementHandler handler = mock(MeasurementHandler.class);

		service.registerHandler(handler);
		service.registerStatisticsProvider(provider);
		service.start();

		verify(provider).getStats();
		verify(handler).handleMeasurement(measurement);
	}

}
