import java.util.*;

public class CrossSum {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        int[][] a = new int[h][w];
        int[]  ai = new int[h];
        int[]  aj = new int[w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int aij = io.nextInt();
                a[i][j]  = aij;
                ai[i]   += aij;
                aj[j]   += aij;
            }
        }
        io.close();

        for (int i = 0; i < h; i++) {
            String result = "";
            for (int j = 0; j < w; j++) result += ai[i] + aj[j] - a[i][j] + " ";
            io.output(result.substring(0, result.length()-1));
        }
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {
            System.out.println(result);
        }
    }
}