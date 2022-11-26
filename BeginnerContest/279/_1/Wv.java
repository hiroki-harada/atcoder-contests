import java.util.*;

public class Wv {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long result = io.nextStr().chars().mapToLong(s -> s == 'v' ? 1l : 2l).sum();
        io.close();
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private void output(long result) {System.out.println(result);}
    }
}