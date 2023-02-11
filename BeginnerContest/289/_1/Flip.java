import java.util.*;

public class Flip {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.output(io.nextStr().replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1"));
        // io.output(~(io.nextInt()));
        io.close();
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        // private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}