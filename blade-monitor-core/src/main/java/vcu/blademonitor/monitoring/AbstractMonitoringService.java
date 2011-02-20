package vcu.blademonitor.monitoring;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract superclass for monitoring services (implements distribution of the
 * measurements to handlers).
 */
public abstract class AbstractMonitoringService implements MonitoringService {

	/**
	 * Collection of measurement handlers.
	 */
	private final Collection<MeasurementHandler> handlers = new ArrayList<MeasurementHandler>();

	@Override
	public final void registerHandler(MeasurementHandler handler) {
		handlers.add(handler);
	}

	/**
	 * Distributes measurements among handlers.
	 * 
	 * @param measurement
	 *            measurement
	 */
	protected void distributeMeasurement(MetricStructure measurement) {
		for (MeasurementHandler handler : handlers) {
			handler.handleMeasurement(measurement);
		}
	}

}
