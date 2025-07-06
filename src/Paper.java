public abstract class Paper {
    protected String title;
    protected boolean isSelected = false;

    public Paper(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}