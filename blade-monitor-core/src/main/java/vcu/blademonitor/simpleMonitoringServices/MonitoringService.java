package vcu.blademonitor.simpleMonitoringServices;

/**
 * Common interface of the monitoring services (classes responsible for
 * gathering and processing information from <code>StatisticsProvider</code>.
 */
public interface MonitoringService {

	/**
	 * Registers new handler (object responsible for processing incoming
	 * measurements).
	 * 
	 * @param handler
	 *            new handler
	 */
	void registerHandler(MeasurementHandler handler);

	/**
	 * Registers object responsible for gathering system stats.
	 * 
	 * @param provider
	 *            new stats provider
	 */
	void registerStatisticsProvider(StatisticsProvider provider);

}
