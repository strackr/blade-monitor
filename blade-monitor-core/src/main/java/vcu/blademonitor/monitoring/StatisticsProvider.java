package vcu.blademonitor.monitoring;

/**
 * Interface for classes responsible for providing system statistics (CPU/memory
 * usage etc.)
 */
public interface StatisticsProvider {

	/**
	 * Reads current stats.
	 * 
	 * @return current stats
	 */
	MetricStructure getStats();

}
