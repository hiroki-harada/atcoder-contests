import java.util.*;

public class Centers {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        var a = new HashMap<Integer, Integer>();
        io.close();

        var result = new HashMap<Integer, Integer>();

        io.output(
            result.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(e -> e.getValue().toString())
                .reduce("", (str1, str2) -> str1 + " " + str2)
        );
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private List<Integer> nextList(int size) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.nextInt());
            return list;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}