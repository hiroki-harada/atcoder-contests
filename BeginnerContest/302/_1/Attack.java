import java.util.*;

public class Attack {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long a = io.nextLong();
        long b = io.nextLong();
        io.close();

        // a/b の切り上げは、(a+b-1)/b と一致する
        io.output((a+b-1)/b);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}