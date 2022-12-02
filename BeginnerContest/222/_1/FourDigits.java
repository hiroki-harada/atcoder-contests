import java.util.*;

public class FourDigits {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.output(String.format("%04d", io.nextInt()));
        io.close();
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {System.out.println(result);}
    }
}