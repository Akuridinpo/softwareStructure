import java.util.*;

public class PaperList {
    private List<Paper> papers = new ArrayList<>();
    private SelectionStrategy strategy;

    public PaperList(SelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public void addPaper(Paper paper) {
        papers.add(paper);
    }

    public List<Paper> selectPaperByStudent(Student student) throws NoEnoughPapersException {
        if (student == null || student.hasSelected())
            throw new IllegalArgumentException("学生无效或已选择过");
        Preference pref = student.getPreference();
        if (pref == null || pref.getPreferredQuantity() <= 0)
            throw new IllegalArgumentException("偏好设置非法");

        List<Paper> available = new ArrayList<>();
        for (Paper paper : papers) {
            if (!paper.isSelected() && paper.getClass().getSimpleName().equals(pref.getPreferredType())) {
                available.add(paper);
            }
        }

        if (available.size() < pref.getPreferredQuantity()) {
            throw new NoEnoughPapersException(student.getName(), pref.getPreferredQuantity(), available.size());
        }

        List<Paper> selected = strategy.select(available, pref.getPreferredQuantity());
        for (Paper paper : selected) {
            paper.setSelected(true);
        }
        student.setHasSelected(true);
        return selected;
    }
}