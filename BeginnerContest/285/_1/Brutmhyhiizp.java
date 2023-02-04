import java.util.*;

public class Brutmhyhiizp {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        String s = io.nextStr();
        io.close();

        // long result = 0;
        long result2 = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            // 1桁目から計算、こっちだとなぜかうまくいかない。。
            // result += (s.charAt((int)(length - i - 1))-'A'+1) * Math.pow(26, i);
            // io.output("result : " + result);
            // n桁目から計算
            result2 = result2*26 + (s.charAt(i)-'A')+ 1;
            // io.output("result2 : " + result2);
        }
        // io.output("result : " + result);
        // io.output("result2 : " + result2);
        io.output(result2);
    }

    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private String nextStr() {return this.sc.next();}
        private void output(long result) {System.out.println(result);}
    }
}