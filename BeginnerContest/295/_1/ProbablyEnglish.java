import java.util.*;

public class ProbablyEnglish {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String[] w = io.nextStrArray(n);
        io.close();

        for (String wi : w) {
            if (Arrays.asList("and", "not", "that", "the", "you").contains(wi)) {
                io.output("Yes");
                return;
            }
        }
        io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}