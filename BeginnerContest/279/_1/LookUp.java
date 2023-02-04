import java.util.*;

public class LookUp {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        String t = io.nextStr();
        io.close();

        io.output(s.replace(t, "").equals(s) ? "No" : "Yes");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private <T> void output(T result) {System.out.println(result);}
    }
}