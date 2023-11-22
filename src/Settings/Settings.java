package Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The class Settings
 */ 
public class Settings {
	private boolean isMetric;
	private Map<String, List<Observer>> observers = new HashMap<>();


	/** 
	 *
	 * It is a constructor. 
	 *
	 */
	public Settings() { 

		this.isMetric = true;
		this.observers.put("metric", new ArrayList<>());
	}


	/** 
	 *
	 * Subscribe a object
	 *
	 * @param settingType  the setting type. 
	 * @param observer  the observer. 
	 */
	public void subscribe(String settingType, Observer observer) { 

		List<Observer> settingObservers = observers.get(settingType);
		settingObservers.add(observer);
	}


	/** 
	 *
	 * Unsubscribe
	 *
	 * @param settingType  the setting type. 
	 * @param observer  the observer. 
	 */
	public void unsubscribe(String settingType, Observer observer) { 

		List<Observer> settingObservers = observers.get(settingType);
		settingObservers.remove(observer);
	}


	/** 
	 *
	 * Is metric
	 *
	 * @return boolean
	 */
	public boolean isMetric() { 

		return isMetric;
	}


	/** 
	 *
	 * Sets the metric
	 *
	 * @param metric  the metric. 
	 */
	public void setMetric(boolean metric) { 

		if (this.isMetric != metric) {
			this.isMetric = metric;
			notifyObservers("metric");
		}
	}


	/** 
	 *
	 * Notify observers
	 *
	 * @param settingType  the setting type. 
	 */
	private void notifyObservers(String settingType) { 

		List<Observer> settingObservers = observers.get(settingType);
		for (Observer observer : settingObservers) {
			observer.updateMetric(this.isMetric);
		}
	}
}
