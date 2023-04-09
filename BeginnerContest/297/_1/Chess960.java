import java.util.*;

public class Chess960 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        int x1 = s.indexOf("B");
        int y1 = s.lastIndexOf("B");
        if (x1%2 == y1%2) {
            io.output("No");
            return;
        }

        int x2 = s.indexOf("R");
        int z2 = s.lastIndexOf("K");
        int y2 = s.lastIndexOf("R");
        if (!(x2 < z2 && z2 < y2)) {
            io.output("No");
            return;
        }
        io.output("Yes");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}