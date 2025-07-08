import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class PaperListTest {

    @Test
    public void testSelectPaperByRandom_Normal() throws Exception {
        PaperList paperList = new PaperList((SelectionStrategy) new RandomStrategy());
        paperList.addPaper(new JournalPaper("A"));
        paperList.addPaper(new JournalPaper("B"));
        paperList.addPaper(new JournalPaper("C"));

        Student student = new Student("Cloudy", new Preference("JournalPaper", 2));
        List<Paper> result = paperList.selectPaperByStudent(student);
        assertEquals(2, result.size());
    }

    @Test
    public void testSelectPaper_NotEnough() {
        PaperList paperList = new PaperList((SelectionStrategy) new RandomStrategy());
        paperList.addPaper(new ConferencePaper("C1"));

        Student student = new Student("Cloudy", new Preference("ConferencePaper", 3));
        assertThrows(NoEnoughPapersException.class, () -> {
            paperList.selectPaperByStudent(student);
        });
    }

    @Test
    public void testSelectPaper_IllegalQuantity() {
        PaperList paperList = new PaperList((SelectionStrategy) new RandomStrategy());
        paperList.addPaper(new Thesis("T1"));

        Student student = new Student("Cloudy", new Preference("Thesis", 0));
        assertThrows(IllegalArgumentException.class, () -> {
            paperList.selectPaperByStudent(student);
        });
    }
}
