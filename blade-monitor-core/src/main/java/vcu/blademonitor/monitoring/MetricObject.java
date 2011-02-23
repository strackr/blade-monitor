package vcu.blademonitor.monitoring;

import org.joda.time.DateTime;

/******************************************************************************
 * 
 * @author Erik Test - 02/11/2011
 * 
 *         The MetricObject defines how a metric is defined for the
 *         blade-monitor project. It contains the metric name, value, and time
 *         the metric was taken.
 * 
 *****************************************************************************/

public class MetricObject {
	private String strName;
	private double value;
	private DateTime time;

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         The MetricObject is initialized with strName set to the user
	 *         specified strName, value is set to the user specified value, and
	 *         time is set to the user specified Calendar time.
	 * 
	 * @param strName
	 *            - the name of the metric
	 * @param value
	 *            - the value of the metric, strName
	 * @param time
	 *            - the DateTime time the metric was taken
	 * 
	 *************************************************************************/
	public MetricObject(String strName, double value, DateTime time) {
		this.strName = strName;
		this.value = value;
		this.time = time;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Get the MetricObject metric name
	 * 
	 * @return The metric name as a String
	 * 
	 *************************************************************************/
	public final String getName() {
		return this.strName;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Get the MetricObject metric value
	 * 
	 * @return The metric value as a double
	 * 
	 *************************************************************************/
	public final double getValue() {
		return this.value;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Get the MetricObject metric time
	 * 
	 * @return The metric time as a Date
	 * 
	 *************************************************************************/
	public final DateTime getTime() {
		return this.time;
	}
}
