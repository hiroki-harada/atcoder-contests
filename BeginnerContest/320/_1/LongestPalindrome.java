import java.util.*;

public class LongestPalindrome {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        int maxLength = 1; // 最小の回文の長さは1
        // すべての文字を中心とする場合を考える
        for (int i = 0, len = s.length(); i < len; i++) {
            // 奇数長の回文を考える
            int oddLength = expandAroundCenter(s, i, i);
            maxLength = Math.max(maxLength, oddLength);

            // 偶数長の回文を考える
            int evenLength = expandAroundCenter(s, i, i + 1);
            maxLength = Math.max(maxLength, evenLength);
        }

        io.output(maxLength);
    }

    // 左右に拡張できなくなるまでの回文の長さを返す
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private void output(int result) {System.out.println(result);}
    }
}