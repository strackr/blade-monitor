package vcu.blademonitor;

import vcu.blademonitor.simpleMonitoringServices.DebugMeasurementHandler;
import vcu.blademonitor.simpleMonitoringServices.RandomStatisticsProvider;
import vcu.blademonitor.simpleMonitoringServices.SingleExecutionMonitoringService;

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
