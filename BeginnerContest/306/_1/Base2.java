import java.math.BigInteger;
import java.util.*;

public class Base2 {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        var a = io.nextList(64);
        Collections.reverse(a);
        io.close();

        var result = new BigInteger(String.join("", a), 2);
        io.output(result);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private List<String> nextList(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}