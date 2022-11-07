import java.util.*;

public class AUniqueLetter {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        char[] s = io.next().toCharArray();
        io.close();

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) set.add(s[i]);
        if (set.size() == 1) {
            System.out.println(-1);
            return;
        } else if (set.size() == 3) {
            System.out.println(s[1]);
        }

        if (s[0] == s[1]) System.out.println(s[2]);
        if (s[1] == s[2]) System.out.println(s[0]);
        if (s[0] == s[2]) System.out.println(s[1]);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String next() {return this.sc.next();}

    }
}