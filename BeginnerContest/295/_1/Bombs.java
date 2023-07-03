import java.util.*;

public class Bombs {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int r = io.nextInt();
        int c = io.nextInt();
        String[] b = io.nextStrArray(r);
        io.close();

        boolean[][] isBlasted = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!Character.isDigit(b[i].charAt(j))) continue;
                int bij = Character.getNumericValue(b[i].charAt(j));

                for (int ni = 0; ni < r; ni++) {
                    for (int nj = 0; nj < c; nj++) {
                        if (Math.abs(i - ni) + Math.abs(j - nj) <= bij) isBlasted[ni][nj] = true;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (isBlasted[i][j]) b[i] = b[i].substring(0, j) + "." + b[i].substring(j+1, c);
            }
        }
        io.outputArray(b, "\r\n");
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String[] nextStrArray(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) list.add(this.sc.next());
            return list.toArray(new String[size]);
        }
        private <T> void outputArray(T[] array, String delimiter) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < array.length; i++)  result.append(array[i]).append(delimiter);
            System.out.println(result.toString().substring(0, result.length()-delimiter.length()));
        }
    }
}