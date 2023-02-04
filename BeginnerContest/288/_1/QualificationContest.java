import java.util.*;

public class QualificationContest {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int k = io.nextInt();
        List<String> s = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            s.add(io.nextStr());
            if (i == k) {
                s.sort((s1, s2) -> s1.compareTo(s2));
                io.outputArray(s.toArray(new String[s.size()]), "\n");
                return;
            }
        }
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}