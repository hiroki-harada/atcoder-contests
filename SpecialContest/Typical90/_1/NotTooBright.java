import java.util.*;

public class NotTooBright {
    public static void main(String[] args) {

        IOHandler io = new IOHandler();
        int h = io.nextInt();
        int w = io.nextInt();
        io.close();

        /*
         * ↓が最大のブロック数
         * #*#*#*#*
         * ********
         * #*#*#*#*
         * ********
         *
         * ただし、縦横どちらかが 1 の場合は、縦 2 × 横 2 の、4 つの LED を含む領域は存在しないと扱うみたい
         * > 縦 2 × 横 2 の、4 つの LED を含む領域 && 点灯している LED が領域内に 2 つ以上あるものが存在する
         * > の前者がfalse
         */
        if (h == 1 | w == 1) io.output(h * w);
        else io.output((h/2 + h%2) * (w/2 + w%2));
    }


    private static class IOHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}

        private int nextInt() {return this.sc.nextInt();}

        private void output(int result) {System.out.println(result);}
    }
}