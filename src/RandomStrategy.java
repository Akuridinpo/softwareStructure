import java.util.Collections;
import java.util.List;

public class RandomStrategy implements SelectionStrategy {
    @Override
    public List<Paper> select(List<Paper> papers, int count) {
        Collections.shuffle(papers);
        return papers.subList(0, count);
    }
}
