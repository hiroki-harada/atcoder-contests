import java.util.*;

public class Ctz {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        in.close();

        String binaryN = Integer.toBinaryString(n);
        System.out.println(binaryN.length() - binaryN.lastIndexOf('1') - 1);
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}