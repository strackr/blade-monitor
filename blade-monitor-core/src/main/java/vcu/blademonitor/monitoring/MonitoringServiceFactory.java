package vcu.blademonitor.monitoring;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Factory class for monitoring services.
 */
public class MonitoringServiceFactory {

	/**
	 * Creates monitoring service that collects measurements at fixed rate.
	 * 
	 * @param poolSize
	 *            number of threads in the pool
	 * @param delay
	 *            delay between consecutive measurements
	 * @return new instance of the monitoring service
	 */
	public MonitoringService createFixedRateMonitoringService(int poolSize, long delay) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(poolSize);
		return new FixedRateMonitoringService(executor, delay);
	}

}
