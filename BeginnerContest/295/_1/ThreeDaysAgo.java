import java.util.*;

public class ThreeDaysAgo {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        long result = 0;


        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private void output(long result) {System.out.println(result);}
    }
}