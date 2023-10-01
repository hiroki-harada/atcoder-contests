import java.util.*;

public class FullMoon {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int m = io.nextInt();
        int p = io.nextInt();
        io.close();

        if (n-m < 0)  io.output(0);
        else io.output(1 + (n-m)/p);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}