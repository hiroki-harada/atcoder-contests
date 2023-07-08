import java.util.*;

public class Rotate {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = io.nextStr().split("");
            for (int j = 0; j < str.length; j++) {
                a[i][j] =  Integer.parseInt(str[j]);
            }
        }
        io.close();

        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 1 行目
                if (i == 0) {
                    if (j == 0) b[i][j] = a[i+1][j];
                    else b[i][j] = a[i][j-1];
                }
                // N 行目
                else if (i == n-1) {
                    if (j == n-1) b[i][j] = a[i-1][j];
                    else b[i][j] = a[i][j+1];
                }
                // 1 列目
                else if (j == 0) {
                    if (i == n-1) b[i][j] = a[i][j+1];
                    else b[i][j] = a[i+1][j];
                }
                // N 列目
                else if (j == n-1) {
                    if (i == 0) b[i][j] = a[i][j-1];
                    else b[i][j] = a[i-1][j];
                }

                // 上記以外
                else b[i][j] = a[i][j];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(b[i][j]);
            }
            if (i != n-1) result.append("\n");
        }

        io.output(result.toString());
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
        private <T> void output(T result) {System.out.println(result);}
    }
}