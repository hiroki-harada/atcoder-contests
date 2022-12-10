import java.util.*;

public class CountDown {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        io.close();

        while(n >= 0)io.output(n--);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private void output(int result) {System.out.println(result);}
    }
}