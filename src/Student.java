public class Student {
    private String name;
    private Preference preference;
    private boolean hasSelected = false;

    public Student(String name, Preference preference) {
        this.name = name;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public Preference getPreference() {
        return preference;
    }

    public boolean hasSelected() {
        return hasSelected;
    }

    public void setHasSelected(boolean selected) {
        this.hasSelected = selected;
    }
}
