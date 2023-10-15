import java.util.*;

public class SquarePermutation {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String[] arrS = in.nextStr().split("");
        in.close();

        Arrays.sort(arrS);
        String s = String.join("", arrS);


        /*
        * i = 0~√10^n までの整数を生成し、それをソートした結果がSに一致するかを判定する
        */
        int result = 0;
        long max = (long)Math.pow(10d, n);
        for (long i = 0; i*i < max; i++) {
            String[] exp = zeroPadding(String.valueOf(i*i), s.length()).split("");

            Arrays.sort(exp);
            if (String.join("", exp).equals(s)) result++;
        }

        System.out.println(result);
    }

    private static String zeroPadding(String base, int size) {
        if (base.length() >= size) return base;

        StringBuilder sb = new StringBuilder();
        for (int i = base.length(); i < size; i++) sb.append("0");
        return sb.append(base).toString();
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}