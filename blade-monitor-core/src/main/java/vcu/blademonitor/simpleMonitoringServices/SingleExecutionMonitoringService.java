package vcu.blademonitor.simpleMonitoringServices;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <code>ExecutionService</code> that collects statistics only once.
 */
public class SingleExecutionMonitoringService extends AbstractMonitoringService {

	private final Collection<StatisticsProvider> providers = new ArrayList<StatisticsProvider>();

	@Override
	public void registerStatisticsProvider(StatisticsProvider provider) {
		providers.add(provider);
	}

	/**
	 * Runs execution service.
	 */
	public void start() {
		for (StatisticsProvider provider : providers) {
			distributeMeasurement(provider.getStats());
		}
	}

}
