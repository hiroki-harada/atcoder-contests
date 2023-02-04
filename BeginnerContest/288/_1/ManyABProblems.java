import java.util.*;

public class ManyABProblems {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        while (n-- > 0) {
            io.output(io.nextLong() + io.nextLong());
        }
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private long nextLong() {return this.sc.nextLong();}
        private void output(long result) {System.out.println(result);}
    }
}