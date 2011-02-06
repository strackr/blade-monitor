package vcu.blademonitor.simpleMonitoringServices;

import java.util.Vector;

/******************************************************************************
 * 
 * @author Erik Test - 02/06/2011
 * 
 * The MetricStructure defines how metrics are stored for the blade-monitor 
 * project.  The node name (i.e. slave2) is stored as a string and the metrics
 * are stored as a two-dimensional vector that stores the names, values, and
 * time metric was taken.
 *****************************************************************************/
public class MetricStructure {
	private String                   nodeName;
	private Vector<Vector<String>>   metricList;
	//contains metric name, metric value, and the time metric was taken
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * The MetricStructure is initialized with nodeName set to "N/A" and
	 * the metricList is initialized to an empty, 2D vector.
	 * 
	 *************************************************************************/
	MetricStructure()
	{
		this.nodeName = "N/A";
		this.metricList = new Vector<Vector<String>>();
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * The MetricStructures is initialized with the nodeName set to the name
	 * specified by the user and the metricList is initialized to an empty, 
	 * 2D vector
	 * 
	 * @param nodeName - the name that the nodeName will be set to (i.e. 
	 *                   master1, slave5)
	 *************************************************************************/
	MetricStructure(String nodeName)
	{
		this.nodeName = nodeName;
		this.metricList = new Vector<Vector<String>>();
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * getNodeName is an accesser function the returns the name of the node 
	 * (i.e. master1, slave2, etc.) for the given metric.
	 * 
	 * @return nodeName - the name of the node for the given metric
	 *                    (i.e. master1, slave2, etc.)
	 *                    
	 *************************************************************************/
	public String getNodeName()
	{
		return this.nodeName;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * setNodeName is a setting function that sets the name of the node for 
	 * this metric (i.e. master1, slave2, etc.)
	 * 
	 * @param nodeName - the name to be used for the given metric
	 * 
	 *************************************************************************/
	public void setNodeName(String nodeName)
	{
		this.nodeName = nodeName;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * listMetricNames list all the metric names found in metricList for this
	 * node
	 * 
	 * @return returnList - the complete list of metric names available in this
	 *                      node
	 * 
	 *************************************************************************/
	public Vector<String> listMetricNames()
	{
		Vector<String> returnList = new Vector<String>();
	
		for(int i = 0; i < this.metricList.size(); i++)
		{
			returnList.add(this.metricList.elementAt(i).elementAt(0));
			//metric i's name
		}
	
		return returnList;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * getMetrics gets the value and time for a given metricName stored in the
	 * metricList if it exists. If the metric doesn't exist, null is returned.
	 * 
	 * @param metricName - the user specified metricName to search for within
	 *                     metricList
	 *                     
	 * @return returns a Vector of Strings that contain the metric name, value,
	 *         and time. If the metric doesn't exist in the metricList, then
	 *         null is returned.
	 * 
	 *************************************************************************/
	public Vector<String> getMetrics(String metricName)
	{
		Vector<String> returnVector = null;
		int myIndex = metricAt(metricName);
		
		if(myIndex != -1)
		{
			returnVector = new Vector<String>();
			returnVector.addAll(this.metricList.elementAt(myIndex));
		}
				
		return returnVector;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * addMetric adds a metric to metricList that contains a metricName, an
	 * empty string for value, and an empty string for time. If the metric
	 * already exists, however, the metric is not added and the return value is
	 * false.
	 * 
	 * @param metricName - the metricName that the user wants to add to the 
	 *                     metricList
	 * @return true if the metric was added successfully, false otherwise.
	 * 
	 *************************************************************************/
	public boolean addMetric(String metricName)
	{
		boolean added = false;
		
		if(metricAt(metricName) == -1)
		{
			Vector<String> temp = new Vector<String>();
			temp.add(metricName);
			temp.add("");
			temp.add("");
			this.metricList.add(temp);
			added = true;
		}
				
		return added;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * metricAt is a helper function for the MetricStructure class to find 
	 * where a metric is located within metricList if it exists. -1 is returned
	 * if the metric doesn't exist within metric list.
	 * 
	 * @param metricName - the metricName, specified by the user, sought in
	 *                     the metric list 
	 *                     
	 * @return an integer indicating the location in metricList. returns -1 if
	 *         the metric does not exist in metric list.
	 * 
	 *************************************************************************/
	private int metricAt(String metricName)
	{
		for(int i = 0; i < this.metricList.size(); i++)
		{
			if(this.metricList.elementAt(i).elementAt(0).equals(metricName))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * setMetricValue sets the value for metricName within metricList if
	 * metricName exists within metric list. Returns false if the metric value
	 * was not set (because the metric doesn't exist within metricList).
	 * 
	 * @param metricName - the metricName within metricList to set to strValue
	 * @param strValue - the value to set for metricName
	 * 
	 * @return a boolean indicating if the metric was set or not (based on the
	 *         existence of metricName within metricList) 
	 * 
	 *************************************************************************/
 	public boolean setMetricValue(String metricName, String strValue)
	{
 		boolean set = false;
 		int myIndex = metricAt(metricName);
 		
 		if(myIndex != -1)
 		{
 			this.metricList.elementAt(myIndex).set(1, strValue);
 			set = true;
 		}
		 		
 		return set;
	}
	
 	/**************************************************************************
	 * 
	 * @author Erik Test - 02/06/2011
	 * 
	 * setMetricTime sets the time for metricName within metricList if
	 * metricName exists within metric list. Returns false if the metric time
	 * was not set (because the metric doesn't exist within metricList).
	 * 
	 * @param metricName - the metricName within metricList to set to strTime
	 * @param strTime - the time to set for metricName
	 * 
	 * @return a boolean indicating if the metric was set or not (based on the
	 *         existence of metricName within metricList) 
	 * 
	 *************************************************************************/
	public boolean setMetricTime(String metricName, String strTime)
	{
		boolean set = false;
		int myIndex = metricAt(metricName);

		if(myIndex != -1)
		{
			this.metricList.elementAt(myIndex).set(2, strTime);
			set = true;
		}
		
		return set;
	}
}
