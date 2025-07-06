public class Preference {
    private String preferredType;
    private int preferredQuantity;

    public Preference(String type, int quantity) {
        this.preferredType = type;
        this.preferredQuantity = quantity;
    }

    public String getPreferredType() {
        return preferredType;
    }

    public int getPreferredQuantity() {
        return preferredQuantity;
    }
}