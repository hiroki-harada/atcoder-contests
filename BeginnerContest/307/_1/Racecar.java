import java.util.*;

public class Racecar {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String[] s = io.nextStrArray(n);
        io.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                String target = s[i]+s[j];

                boolean isPalindrome = true;
                for (int k = 0, len = target.length(); k < len; k++) {
                    if (target.charAt(k) != target.charAt(len-k-1)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    io.output("Yes");
                    return;
                }
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