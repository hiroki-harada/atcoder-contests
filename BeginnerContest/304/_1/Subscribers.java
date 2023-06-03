import java.util.*;

public class Subscribers {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        long n = io.nextLong();
        io.close();

        double divisor = Math.pow(10, String.valueOf(n).length() -3);
        io.output(Math.round(Math.floor(n/(divisor)) * divisor));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private long nextLong() {return this.sc.nextLong();}
        private <T> void output(T result) {System.out.println(result);}
    }
}