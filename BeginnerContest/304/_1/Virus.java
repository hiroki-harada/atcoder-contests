import java.util.*;

public class Virus {

    static int[] x;
    static int[] y;

    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int n = io.nextInt();
        int d = io.nextInt();
        x = new int[n+1];
        y = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            x[i] = io.nextInt();
            y[i] = io.nextInt();
        }
        io.close();

        boolean[] isInfected = new boolean[n+1];
        Queue<Integer> patients = new ArrayDeque<>();

        patients.add(1);
        isInfected[1] = true;
        while (!patients.isEmpty()) {
            int carrier = patients.poll();
            for (int i = 1; i < n+1; i++) {
                // 範囲外の人は指定対象外
                if (dist(i, carrier) > d) continue;
                // 一度感染した人も指定対象外
                if (isInfected[i]) continue;

                // 感染者指定
                isInfected[i] = true;
                patients.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            result.append(isInfected[i] ? "Yes" : "No");
            if (i != n) result.append("\n");
        }
        io.output(result.toString());
    }

        private static double dist(int i, int j) {
            int dx = (int)Math.pow(x[i]-x[j], 2);
            int dy = (int)Math.pow(y[i]-y[j], 2);
            return Math.ceil(Math.sqrt(dx+dy));
        }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private <T> void output(T result) {System.out.println(result);}
    }
}