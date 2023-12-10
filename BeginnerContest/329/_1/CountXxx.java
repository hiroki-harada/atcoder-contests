import java.util.*;

public class CountXxx {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int n = in.nextInt();
        String s = in.nextStr();
        in.close();

        int[] result = new int[26];

        // 1 種類の文字のみからなるものの数 -> 1 種類の文字の最大長
        // と読み替え、各英小文字の最大長を求める
        int cntSeqence = 0;
        for (int i = 0; i < n; i++) {
            // 最大長を更新
            cntSeqence++;
            result[s.charAt(i)-'a'] = Math.max(result[s.charAt(i)-'a'], cntSeqence);
            // i文字目とi+1文字目が異なるなら、ストリークをリセット
            if (i < n-1 && s.charAt(i) != s.charAt(i+1)) cntSeqence = 0;
        }

        System.out.println(Arrays.stream(result).sum());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
        private String nextStr() {return this.sc.next();}
    }
}