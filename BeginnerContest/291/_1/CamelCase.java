import java.util.*;

public class CamelCase {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        char[] s = io.nextStr().toCharArray();
        io.close();
        for (int i = 0; i < s.length; i++) {
            if (Character.isUpperCase(s[i])) {
                io.output(i+1);
                return;
            }

        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}