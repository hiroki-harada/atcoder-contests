import java.util.*;

public class Base8To9 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String n = io.nextStr();
        int k = io.nextInt();
        io.close();

        while (k-- > 0) {
            // 8 -> 9進数に変換
            n = Long.toString(Long.parseLong(n, 8), 9);
            // "8" -> "5" に置換
            n = n.replaceAll("8", "5");
        }

        io.output(n);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}