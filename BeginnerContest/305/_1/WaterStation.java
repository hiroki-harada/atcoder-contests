import java.util.*;

public class WaterStation {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        io.output(n%5 == 0 ? n : n%5 < 3 ? n - (n%5) : n + 5 - (n%5));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private void output(int result) {System.out.println(result);}
    }
}