import java.util.*;

public class OverallWinner {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        String s = io.nextStr();
        io.close();

        if (s.replaceAll("T", "").length() > n/2) io.output("A");
        else if (s.replaceAll("A", "").length() > n/2) io.output("T");
        else io.output(s.lastIndexOf("A") == n-1 ? "T" : "A");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}