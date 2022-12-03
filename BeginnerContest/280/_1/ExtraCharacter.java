import java.util.*;

public class ExtraCharacter {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        char[] s = io.nextStr().toCharArray();
        char[] t = io.nextStr().toCharArray();
        io.close();

        // s の文字数でループする、t の文字数でループするとruntime error
        for (int i = 0; i < s.length; i++) {
            if (!(t[i] == s[i])) {
                io.output(i+1);
                return;
            }
        }

        // s の末尾に英小文字が挿入された場合の処理
        io.output(s.length + 1);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private String nextStr() {return this.sc.next();}

        private void output(int result) {System.out.println(result);}
    }
}
