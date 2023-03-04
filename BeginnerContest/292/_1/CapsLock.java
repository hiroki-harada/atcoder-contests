import java.util.*;

public class CapsLock {
    public static void main(String[] args) {
        IOHandler io = new IOHandler();
        io.output(io.nextStr().toUpperCase());
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}