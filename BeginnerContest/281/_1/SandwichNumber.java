import java.util.*;

public class SandwichNumber {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        io.output(s.matches("[A-Z][1-9][0-9]{5}[A-Z]") ? "Yes" : "No");

    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private <T> void output(T result) {System.out.println(result);}
    }
}