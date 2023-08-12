import java.util.*;

public class Pi {
    public static void main(String[] args) {

        final String pi = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        io.output(pi.substring(0, n+2));
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}