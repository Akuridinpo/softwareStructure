import java.util.List;

public interface SelectionStrategy {
    List<Paper> select(List<Paper> papers, int count);
}
