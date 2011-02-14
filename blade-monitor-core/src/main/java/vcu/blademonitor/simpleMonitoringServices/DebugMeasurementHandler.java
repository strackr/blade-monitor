package vcu.blademonitor.simpleMonitoringServices;

import java.util.ArrayList;

/**
 * 
 * @author Erik - 02/13/2011
 * 
 *         DebugMeasurementHandler extends the MeasurementHandler interface and
 *         implements the handleMeasurement method
 * 
 */

public class DebugMeasurementHandler implements MeasurementHandler {

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
		System.out.println("Node Name -> " + myStructure.getNodeName());

		ArrayList<String> metricNames = (ArrayList<String>) myStructure
				.listMetricNames();
		MetricObject tempObject = null;
		for (int i = 0; i < metricNames.size(); i++) {
			tempObject = myStructure.getMetrics(metricNames.get(i));
			System.out.println("Metric Name  -> " + tempObject.getName());
			System.out.println("Metric Value -> " + tempObject.getValue());
			System.out.println("Metric Time  -> " + tempObject.getTime());
		}
	}

}
