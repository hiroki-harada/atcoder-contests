import java.util.*;

public class EdgeChecker2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int a = io.nextInt();
        int b = io.nextInt();
        io.close();
        io.output(a*2 == b ? "Yes" : a*2+1 == b ? "Yes" : "No");

    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}