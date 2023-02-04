import java.util.*;

public class Cat {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        io.output(io.nextStr().replaceAll("na", "nya"));
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}