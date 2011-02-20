package vcu.blademonitor.simpleMonitoringServices;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FixedRateMonitoringServiceTest {

	@Test
	public void shouldProvideMeasurements() {
		// given
		ScheduledExecutorService executor = mock(ScheduledExecutorService.class);
		Answer<Void> singleExecutionAnswer = new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Runnable runnable = (Runnable) invocation.getArguments()[0];
				runnable.run();
				return null;
			}
		};
		doAnswer(singleExecutionAnswer).when(executor)
				.scheduleAtFixedRate(any(Runnable.class), anyLong(), anyLong(), any(TimeUnit.class));
		FixedRateMonitoringService service = new FixedRateMonitoringService(executor, 1000);

		MeasurementHandler handler = mock(MeasurementHandler.class);

		MetricStructure measurement = new MetricStructure();
		StatisticsProvider provider = mock(StatisticsProvider.class);
		when(provider.getStats()).thenReturn(measurement);

		// when
		service.registerHandler(handler);
		service.registerStatisticsProvider(provider);

		// then
		verify(executor).scheduleAtFixedRate(any(Runnable.class), anyLong(), anyLong(), any(TimeUnit.class));
		verify(handler).handleMeasurement(measurement);
	}

}
