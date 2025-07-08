import java.util.List;

public class TestRun {
    public static void main(String[] args) {
        PaperList list = new PaperList((SelectionStrategy) new RandomStrategy());
        list.addPaper(new Thesis("A"));
        list.addPaper(new Thesis("B"));
        list.addPaper(new Thesis("C"));

        Student student = new Student("Cloudy", new Preference("Thesis", 2));

        try {
            List<Paper> result = list.selectPaperByStudent(student);
            System.out.println("选择成功：" + result.size() + "篇");
        } catch (Exception e) {
            System.out.println("异常：" + e.getMessage());
        }
    }
}
