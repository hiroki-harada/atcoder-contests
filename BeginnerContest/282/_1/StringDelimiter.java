import java.util.*;

public class StringDelimiter {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        StringBuilder result = new StringBuilder();
        boolean isDelimiter = true;
        for (int i = 0; i < n; i++) {
            char s1 = s.charAt(i);
            if (s1 == '\"') isDelimiter = !isDelimiter;
            if (isDelimiter && s1 == ',') s1 = '.';
            result.append(s1);
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