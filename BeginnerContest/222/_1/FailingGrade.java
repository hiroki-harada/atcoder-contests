import java.util.*;

public class FailingGrade {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int p = io.nextInt();
        int[] a = io.nextIntArray(n);
        io.close();

        io.output(Arrays.stream(a).filter(ai -> ai < p).count());
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }

        private void output(long result) {System.out.println(result);}
    }
}