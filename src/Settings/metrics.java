package Settings;

public class metrics implements Observer {
    private settings settings;

    public metrics(settings settings) {
        this.settings = settings;
        this.settings.registerObserver(this);
    }

    @Override
    public void update() {
        
    }
}