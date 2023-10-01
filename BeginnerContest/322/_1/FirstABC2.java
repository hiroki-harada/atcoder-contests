import java.util.*;

public class FirstABC2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        String s = io.nextStr();
        io.close();

        int result = s.indexOf("ABC");

        if (result == -1) io.output(result);
        else io.output(result+1);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}