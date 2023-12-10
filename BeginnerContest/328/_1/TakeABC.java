import java.util.*;

public class TakeABC {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        String s = in.nextStr();
        in.close();

        final String TARGET = "ABC";

        // 空の文字列からスタートして、求める文字列を作成する
        StringBuilder result = new StringBuilder();
        for (String si : s.split("")) {
            result.append(si);

            // 末尾の ABC を削除
            if (result.toString().endsWith(TARGET))
                result.replace(result.length()-TARGET.length(), result.length(), "");
        }

        System.out.println(result.toString());
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
    }
}