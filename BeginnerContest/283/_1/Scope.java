import java.util.*;

public class Scope {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        Set<Character> store = new HashSet<>();
        for (int i = 0, length = s.length(); i < length; i++) {

            char si = s.charAt(i);

            if (si == '(') continue;
            if (si == ')') store.clear();
            if (!store.add(si)) {
                io.output("No");
                return;
            }
        }
        io.output("Yes");
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}