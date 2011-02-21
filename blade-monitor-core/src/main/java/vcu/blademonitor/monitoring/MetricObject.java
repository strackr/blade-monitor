package vcu.blademonitor.monitoring;

import java.util.Calendar;
import java.util.Date;

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
	private Date time;

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         The MetricObject is initialized with strName set to null, value
	 *         is set to 0.0, and time is set to null.
	 * 
	 *************************************************************************/
	public MetricObject() {
		this.strName = null;
		this.value = 0d;
		this.time = null;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         The MetricObject is initialized with strName set to the user
	 *         specified strName, value is set to 0.0, and time is set to null.
	 * 
	 * @param strName
	 *            - the name of the metric
	 * 
	 *************************************************************************/
	public MetricObject(String strName) {
		this.strName = strName;
		this.value = 0d;
		this.time = null;
	}

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
	 *            - the Calendar time the metric was taken
	 * 
	 *************************************************************************/
	public MetricObject(String strName, double value, Calendar time) {
		this.strName = strName;
		this.value = value;
		this.time = time.getTime();
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         The MetricObject is initialized with strName set to the user
	 *         specified strName, value is set to the user specified value, and
	 *         time is set to the user specified Date time.
	 * 
	 * @param strName
	 *            - the name of the metric
	 * @param value
	 *            - the value of the metric, strName
	 * @param time
	 *            - the Date time the metric was taken
	 * 
	 *************************************************************************/
	public MetricObject(String strName, double value, Date time) {
		this.strName = strName;
		this.value = value;
		this.time = time;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Set the MetricObject strName to the user specified strName
	 * 
	 * @param strName
	 *            - the name of the metric
	 * 
	 *************************************************************************/
	public final void setName(String strName) {
		this.strName = strName;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Set the MetricObject value to the user specified value
	 * 
	 * @param value
	 *            - the value of the metric
	 * 
	 *************************************************************************/
	public final void setValue(double value) {
		this.value = value;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Set the MetricObject Date time to the user specified Calendar
	 *         time
	 * 
	 * @param time
	 *            - the Calendar time that a metric was taken
	 * 
	 *************************************************************************/
	public final void setTime(Calendar time) {
		this.time = time.getTime();
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Set the MetricObject Date time to the user specified Date time
	 * 
	 * @param time
	 *            - the Date time that a metric was taken
	 * 
	 *************************************************************************/
	public final void setTime(Date time) {
		this.time = time;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/11/2011
	 * 
	 *         Set the MetricObject Date time to the time that it is now
	 * 
	 *************************************************************************/
	public final void resetTime() {
		this.time = Calendar.getInstance().getTime();
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
	public final Date getTime() {
		return this.time;
	}
}
