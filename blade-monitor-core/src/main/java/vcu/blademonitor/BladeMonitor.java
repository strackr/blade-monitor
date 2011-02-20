package vcu.blademonitor;

import vcu.blademonitor.monitoring.DebugMeasurementHandler;
import vcu.blademonitor.monitoring.MonitoringService;
import vcu.blademonitor.monitoring.MonitoringServiceFactory;
import vcu.blademonitor.monitoring.RandomStatisticsProvider;

/**
 * Blade monitor entry point.
 */
public class BladeMonitor {

	private static final int MONITORING_POOL_SIZE = 2;
	private static final int MONITORING_DELAY = 5000;

	public static void main(String[] args) {
		// create monitoring service and register measurement handler with
		// statistics provider
		MonitoringServiceFactory factory = new MonitoringServiceFactory();
		MonitoringService service = factory.createFixedRateMonitoringService(
				MONITORING_POOL_SIZE, MONITORING_DELAY);
		service.registerHandler(new DebugMeasurementHandler());
		service.registerStatisticsProvider(new RandomStatisticsProvider(4));
	}

}
