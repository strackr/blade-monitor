package vcu.blademonitor.monitoring;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import vcu.blademonitor.monitoring.AbstractMonitoringService;
import vcu.blademonitor.monitoring.MeasurementHandler;
import vcu.blademonitor.monitoring.MetricStructure;
import vcu.blademonitor.monitoring.StatisticsProvider;

public class AbstractMonitoringServiceTest {

	@Test
	public void shouldDistributeMeasurements() {
		AbstractMonitoringService service = new AbstractMonitoringService() {
			@Override
			public void registerStatisticsProvider(StatisticsProvider provider) {
				// nothing to do
			}
		};
		MetricStructure measurement = new MetricStructure();
		MeasurementHandler handler1 = mock(MeasurementHandler.class);
		MeasurementHandler handler2 = mock(MeasurementHandler.class);

		service.registerHandler(handler1);
		service.registerHandler(handler2);
		service.distributeMeasurement(measurement);

		verify(handler1).handleMeasurement(measurement);
		verify(handler2).handleMeasurement(measurement);
	}

}
