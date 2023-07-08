import java.util.*;

public class Nine {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int a = io.nextInt();
        int b = io.nextInt();
        io.close();

        if (b == 1 || b == 4 || b == 7) {
            io.output("No");
            return;
        }
        if (a+1 == b) io.output("Yes");
        else io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}