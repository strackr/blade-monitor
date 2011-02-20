/**
 * 
 */
package vcu.blademonitor.monitoring;

/**
 * @author Erik - 02/13/2011
 * 
 *         The interface for handling measurements from the system
 * 
 */

public interface MeasurementHandler {

	/**
	 * @author Erik - 02/13/2011
	 * 
	 *         The interface for handleMeasurement.
	 * 
	 * @param - myStructure is the metricStructure to be handled
	 * 
	 */
	public void handleMeasurement(MetricStructure myStructure);

}
