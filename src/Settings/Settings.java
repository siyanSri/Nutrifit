package Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    private boolean isMetric;
    private Map<String, List<Observer>> observers = new HashMap<>();

    public Settings() {
        this.isMetric = true;
        this.observers.put("metric", new ArrayList<>());
    }

    public void subscribe(String settingType, Observer observer) {
        List<Observer> settingObservers = observers.get(settingType);
        settingObservers.add(observer);
    }

    public void unsubscribe(String settingType, Observer observer) {
        List<Observer> settingObservers = observers.get(settingType);
        settingObservers.remove(observer);
    }

    public boolean isMetric() {
        return isMetric;
    }

    public void setMetric(boolean metric) {
        if (this.isMetric != metric) {
            this.isMetric = metric;
            notifyObservers("metric");
        }
    }

    private void notifyObservers(String settingType) {
        List<Observer> settingObservers = observers.get(settingType);
        for (Observer observer : settingObservers) {
            observer.updateMetric(this.isMetric);
        }
    }
}