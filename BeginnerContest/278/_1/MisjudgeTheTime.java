import java.util.*;

public class MisjudgeTheTime {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int m = io.nextInt();
        io.close();

        // 時と分、両方が見間違い易い組み合わせになることは無い
        // また、m=0 とするため、下記のif文が両方実行されることは無い

        if (h%10 >= 6) {
            h += 10 - h%10;
            m = 0;
        }

        if (h/10 == 2 && m/10 >= 4) {
            h = h%10>=3 ? 0 : h+1;
            m = 0;
        }

        io.output(h + " " + m);
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private <T> void output(T result) {System.out.println(result);}
    }
}