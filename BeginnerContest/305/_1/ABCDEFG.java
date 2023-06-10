import java.util.*;

public class ABCDEFG {
    static Map<String, Integer> dist = Map.of(
        "A", 0,
        "B", 3,
        "C", 4,
        "D", 8,
        "E", 9,
        "F", 14,
        "G", 23
    );

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String p = io.nextStr();
        String q = io.nextStr();
        io.close();

        io.output(Math.abs(dist.get(p) - dist.get(q)));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}