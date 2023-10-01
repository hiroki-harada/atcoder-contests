import java.util.*;

public class Chord {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        final String macher = "ACE,BDF,CEG,DFA,EGB,FAC,GBD";
        for (String str : macher.split(",")) {
            if (s.equals(str)) {
                io.output("Yes");
                return;
            }
        }
        io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}