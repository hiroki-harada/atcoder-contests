import java.util.*;

public class GrowthRecord {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // n は読み落とす
        int m = io.nextInt();
        int x = io.nextInt();
        int t = io.nextInt();
        int d = io.nextInt();
        io.close();

        io.output(m >= x ? t : d*(m-x) + t);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private void output(int result) {System.out.println(result);}
    }
}