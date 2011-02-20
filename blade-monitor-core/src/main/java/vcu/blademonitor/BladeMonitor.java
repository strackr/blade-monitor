package vcu.blademonitor;

import vcu.blademonitor.monitoring.DebugMeasurementHandler;
import vcu.blademonitor.monitoring.RandomStatisticsProvider;
import vcu.blademonitor.monitoring.SingleExecutionMonitoringService;

/**
 * Blade monitor entry point.
 */
public class BladeMonitor {

	public static void main(String[] args) {
		// create monitoring service and register measurement handler with
		// statistics provider
		SingleExecutionMonitoringService service = new SingleExecutionMonitoringService();
		service.registerHandler(new DebugMeasurementHandler());
		service.registerStatisticsProvider(new RandomStatisticsProvider(4));

		service.start();
	}

}
