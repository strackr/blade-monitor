package vcu.blademonitor.simpleMonitoringServices;

import java.util.List;

import vcu.blademonitor.logging.Log;

/**
 * 
 * @author Erik - 02/13/2011
 * 
 *         DebugMeasurementHandler extends the MeasurementHandler interface and
 *         implements the handleMeasurement method
 * 
 */

public class DebugMeasurementHandler implements MeasurementHandler {

	private static Log log = Log.instance();

	/**
	 * @author Erik - 02/13/2011
	 * 
	 *         handleMeasurement displays the nodeName, metricNames, values, and
	 *         times for a given metric, myStructure
	 * 
	 * @param - myStructure is the MetricStructure that will have all its
	 *        metrics displayed to screen
	 */
	@Override
	public void handleMeasurement(MetricStructure myStructure) {
		log.debug("Node Name -> {0}", myStructure.getNodeName());

		List<String> metricNames = myStructure.listMetricNames();
		for (String metricName : metricNames) {
			MetricObject tempObject = myStructure.getMetrics(metricName);
			log.debug("Metric Name  -> {0}", tempObject.getName());
			log.debug("Metric Value -> {0,number,#.00}", tempObject.getValue());
			log.debug("Metric Time  -> {0,date,long}", tempObject.getTime());
		}
	}

}
