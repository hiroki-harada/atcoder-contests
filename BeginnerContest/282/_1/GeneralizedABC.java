import java.util.*;

public class GeneralizedABC {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();
        io.output("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, n));
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {System.out.println(result);}
    }
}