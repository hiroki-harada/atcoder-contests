import java.util.*;

public class CountingPasses {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        int l = in.nextInt();
        int[] a = in.nextIntArray(n);
        in.close();

        System.out.println(
            Arrays.stream(a).filter(ai -> ai >= l).count()
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