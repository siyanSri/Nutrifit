package Meal;

public class parametersForIngredients {
	private Meal meal;
    private String type;
    private String date;
    private String selectedProfile;

    public parametersForIngredients(Meal meal, String type, String date, String selectedProfile) {
        this.meal = meal;
        this.type = type;
        this.date = date;
        this.selectedProfile = selectedProfile;
    }

    public Meal getMeal() {
        return meal;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getSelectedProfile() {
        return selectedProfile;
    }
}
