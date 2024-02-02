import java.util.*;
import java.util.stream.*;

public class LongLoong {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        in.close();

        String no = Stream.generate(() -> "o").limit(n).collect(Collectors.joining (""));
        System.out.println("L" + no + "ng");
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}