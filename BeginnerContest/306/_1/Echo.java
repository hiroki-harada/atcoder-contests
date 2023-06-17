import java.util.*;

public class Echo {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.nextInt(); // discard n
        String[] s = io.nextStr().split("");
        io.close();

        var result = new StringBuilder();
        for (String str : s) result.append(str).append(str);
        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}