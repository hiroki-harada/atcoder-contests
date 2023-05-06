import java.util.*;

public class TreasureChest {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        // discard n
        io.nextInt();
        String s = io.nextStr();
        io.close();

        int pipe1 = s.indexOf("|");
        int pipe2 = s.lastIndexOf("|");
        int aster = s.indexOf("*");

        if (pipe1 < aster && aster < pipe2)
            io.output("in");
        else
            io.output("out");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}