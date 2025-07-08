import java.util.List;

public class Client {
    public static void main(String[] args) {
        PaperList list = new PaperList((SelectionStrategy) new RandomStrategy());
        list.addPaper(new JournalPaper("AI"));
        list.addPaper(new JournalPaper("Cloud"));
        list.addPaper(new ConferencePaper("Security"));

        Student student = new Student("Cloudy", new Preference("JournalPaper", 2));

        try {
            List<Paper> selected = list.selectPaperByStudent(student);
            System.out.println("成功选择论文：");
            for (Paper p : selected) {
                System.out.println(" - " + p.getTitle());
            }
        } catch (Exception e) {
            System.out.println("选择失败：" + e.getMessage());
        }
    }
}