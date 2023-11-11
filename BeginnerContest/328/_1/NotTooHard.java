import java.util.*;

public class NotTooHard {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int x = in.nextInt();
        int[] s = in.nextIntArray(n);
        in.close();

        System.out.println(
            Arrays.stream(s).filter(si -> si <= x).reduce(0, (si, sj) -> si+sj)
        );
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
    }
}