import java.util.*;

public class CashRegister {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        io.output(io.nextStr().replaceAll("00", "x").length());
        io.close();
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private void output(int result) {System.out.println(result);}
    }
}