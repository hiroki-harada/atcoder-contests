import java.util.*;

public class MinimumCoins {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int a = io.nextInt();
        int b = io.nextInt();
        int c = io.nextInt();
        io.close();

        int result = 0;
        result += n/c;
        n %= c;
        result += n/b;
        n %= b;
        result += n/a;
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}