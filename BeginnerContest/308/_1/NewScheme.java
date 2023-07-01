import java.util.*;

public class NewScheme {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int[] s = io.nextIntArray(8);
        io.close();

        boolean isMatch = true;
        int previous = -1;
        for (int i = 0; i < s.length; i++) {
            if (previous > s[i]) {
                isMatch = false;
                break;
            }
            previous = s[i];

            if (s[i] < 100 || s[i] > 675) {
                isMatch = false;
                break;
            }

            if (s[i]%5 != 0) {
                isMatch = false;
                break;
            }
        }

        if (isMatch) io.output("Yes");
        else io.output("No");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = this.sc.nextInt();
            return array;
        }
        private <T> void output(T result) {System.out.println(result);}
    }
}