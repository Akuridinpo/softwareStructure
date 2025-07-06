public class NoEnoughPapersException extends Exception {
    public NoEnoughPapersException(String name, int wanted, int available) {
        super("学生 " + name + " 希望选论文 " + wanted + " 篇，但目前只有 " + available + " 篇可选");
    }
}