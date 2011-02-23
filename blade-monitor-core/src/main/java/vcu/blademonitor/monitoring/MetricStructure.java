package vcu.blademonitor.monitoring;

import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 * 
 * @author Erik Test - 02/06/2011
 * 
 *         The MetricStructure defines how metrics are stored for the
 *         blade-monitor project. The node name (i.e. slave2) is stored as a
 *         string and the metrics are stored as a two-dimensional ArrayList that
 *         stores the names, values, and time metric was taken.
 *****************************************************************************/
public class MetricStructure {
	private String nodeName;
	private List<MetricObject> metricList;

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         The MetricStructures is initialized with the nodeName set to the
	 *         name specified by the user and the metricList is initialized to
	 *         an empty, 2D ArrayList
	 * 
	 * @param nodeName
	 *            - the name that the nodeName will be set to (i.e. master1,
	 *            slave5)
	 *************************************************************************/
	public MetricStructure(String nodeName) {
		this.nodeName = nodeName;
		this.metricList = new ArrayList<MetricObject>();
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         getNodeName is an access function the returns the name of the
	 *         node (i.e. master1, slave2, etc.) for the given metric.
	 * 
	 * @return nodeName - the name of the node for the given metric (i.e.
	 *         master1, slave2, etc.)
	 * 
	 *************************************************************************/
	public final String getNodeName() {
		return this.nodeName;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         listMetricNames list all the metric names found in metricList for
	 *         this node
	 * 
	 * @return returnList - the complete list of metric names available in this
	 *         node
	 * 
	 *************************************************************************/
	public final List<String> listMetricNames() {
		ArrayList<String> returnList = new ArrayList<String>();

		for (int i = 0; i < this.metricList.size(); i++) {
			returnList.add(this.metricList.get(i).getName());
			// metric i's name
		}

		return returnList;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         getMetrics gets the value and time for a given metricName stored
	 *         in the metricList if it exists. If the metric doesn't exist, null
	 *         is returned.
	 * 
	 * @param metricName
	 *            - the user specified metricName to search for within
	 *            metricList
	 * 
	 * @return returns a MetricObject that contains the name, value and time of
	 *         a metric. If the metric doesn't exist in the metricList, then
	 *         null is returned.
	 * 
	 *************************************************************************/
	public final MetricObject getMetrics(String metricName) {
		MetricObject returnMetric = null;
		int myIndex = metricAt(metricName);

		if (myIndex != -1) {
			returnMetric = this.metricList.get(myIndex);
		}

		return returnMetric;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         addMetric adds a metric to metricList that contains a metricName,
	 *         an empty string for value, and an empty string for time. If the
	 *         metric already exists, however, the metric is not added and the
	 *         return value is false.
	 * 
	 * @updated Erik Test - 02/22/2011
	 * 
	 *          Updated the parameter to take on an object instead of a name.
	 * 
	 * @param myObject
	 *            - the MetricObject that the user wants to add to the
	 *            metricList
	 * @return true if the metric was added successfully, false otherwise.
	 * 
	 *************************************************************************/
	public final boolean addMetric(MetricObject myObject) {
		boolean added = false;

		if (metricAt(myObject.getName()) == -1) {
			this.metricList.add(myObject);
			added = true;
		}

		return added;
	}

	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 *         metricAt is a helper function for the MetricStructure class to
	 *         find where a metric is located within metricList if it exists. -1
	 *         is returned if the metric doesn't exist within metric list.
	 * 
	 * @param metricName
	 *            - the metricName, specified by the user, sought in the metric
	 *            list
	 * 
	 * @return an integer indicating the location in metricList. returns -1 if
	 *         the metric does not exist in metric list.
	 * 
	 *************************************************************************/
	private final int metricAt(String metricName) {
		for (int i = 0; i < this.metricList.size(); i++) {
			if (this.metricList.get(i).getName().equals(metricName)) {
				return i;
			}
		}

		return -1;
	}
}
