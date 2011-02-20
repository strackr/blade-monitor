package vcu.blademonitor.simpleMonitoringServices;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Monitoring service designated to collect measurements at fixed rate.
 */
public class FixedRateMonitoringService extends AbstractMonitoringService {

	/**
	 * Executor service.
	 */
	private final ScheduledExecutorService executor;

	/**
	 * Delay between consecutive executions (in miliseconds).
	 */
	private final long delay;

	/**
	 * Creates new monitoring service.
	 * 
	 * @param executor
	 *            executor for statistics providers
	 * @param delay
	 *            delay between consecutive measurements
	 */
	public FixedRateMonitoringService(ScheduledExecutorService executor, long delay) {
		this.executor = executor;
		this.delay = delay;
	}

	@Override
	public void registerStatisticsProvider(final StatisticsProvider provider) {
		Runnable command = new Runnable() {
			@Override
			public void run() {
				distributeMeasurement(provider.getStats());
			}
		};
		executor.scheduleAtFixedRate(command, 0, delay, TimeUnit.MILLISECONDS);
	}

	/**
	 * Stops monitoring service.
	 */
	public void stop() {
		executor.shutdown();
	}

}
