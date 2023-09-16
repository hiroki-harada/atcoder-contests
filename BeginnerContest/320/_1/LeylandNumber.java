import java.util.*;

public class LeylandNumber {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int a = io.nextInt();
        int b = io.nextInt();
        io.close();

        io.output((int)(Math.pow(a, b)+Math.pow(b, a)));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}