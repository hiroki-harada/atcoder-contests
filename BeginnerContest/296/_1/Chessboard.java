import java.util.*;

public class Chessboard {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = 8;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) s[i] = io.nextStr();
        io.close();

        String alphabet = "abcdefgh";
        for (int row = 0; row < n; row++) {
            int column = s[row].indexOf('*');
            if (column == -1) continue;

            io.output(alphabet.charAt(column) +""+ (n-row));
        }

    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}