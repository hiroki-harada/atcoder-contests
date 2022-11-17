import java.util.*;

public class Saturday {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        if (s.equals("Monday")) io.output(5);
        if (s.equals("Tuesday")) io.output(4);
        if (s.equals("Wednesday")) io.output(3);
        if (s.equals("Thursday")) io.output(2);
        if (s.equals("Friday")) io.output(1);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private void output(int result) {System.out.println(result);}
    }
}