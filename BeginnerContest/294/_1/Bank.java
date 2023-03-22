import java.util.*;

public class Bank {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        // discard n
        io.nextInt();
        int q = io.nextInt();

        // que, List(?)より、高速で処理ができる
        TreeSet<Integer> queCalled = new TreeSet<>();

        StringBuilder result = new StringBuilder();

        int lastCalled = 1;
        while (q-- > 0) {

            int op = io.nextInt();

            if (op == 1) {
                queCalled.add(lastCalled++);
            }
            else if (op == 2) {
                queCalled.remove(io.nextInt());
            }
            else {
                result.append(queCalled.first()).append("\n");
            }
        }
        io.close();

        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}