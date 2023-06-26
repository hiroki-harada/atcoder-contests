import java.util.*;

public class MismatchedParentheses {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt();  // discard n
        var s = io.nextStr().toCharArray();
        io.close();

        var indexStore = new ArrayList<Integer>();
        var result = new StringBuilder();
        for (int i = 0, len = s.length; i < len; i++) {
            if (s[i] == '(') {
                result.append(s[i]);
                indexStore.add(i);
            }
            else  if (s[i] == ')') {
                if (indexStore.isEmpty()) {
                    result.append(s[i]);
                } else {
                    result = new StringBuilder(result.substring(0, indexStore.get(Math.max(0, indexStore.size()-1))));
                    indexStore.remove(Math.max(0, indexStore.size()-1));
                }

            }
            else {
                result.append(s[i]);
            }
        }
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}