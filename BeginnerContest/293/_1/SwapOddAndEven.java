import java.util.*;

public class SwapOddAndEven {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i +=2) {
            result.append(s.charAt(i+1)).append(s.charAt(i));
        }
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}