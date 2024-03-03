import java.util.*;

public class LangtonsTakahashi {
    public static void main(String[] args) {

        InputHandler in = new InputHandler();
        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        in.close();

        char[][] result = new char[h][w];
        for (char[] cs : result) Arrays.fill(cs, '.');

        // 初期値を定義
        Direction currentDirection = Direction.UP;
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            // 座標の補正処理
            if (x > h-1) x = 0;
            if (x < 0) x = h-1;
            if (y > w-1) y = 0;
            if (y < 0) y = w-1;

            // 現在のマスが白の場合
            if (result[x][y] == '.') {
                result[x][y] = '#';
                currentDirection = turnClockwise(currentDirection);
            } else {
                // 現在のマスが黒の場合
                result[x][y] = '.';
                currentDirection = turnCounterClockwise(currentDirection);
            }

            // 1歩進む
            if (currentDirection == Direction.UP) x--;
            if (currentDirection == Direction.RIGHT) y++;
            if (currentDirection == Direction.DOWN) x++;
            if (currentDirection == Direction.LEFT) y--;
        }

        // 操作後の結果を出力
        for (char[] cs : result) {
            for (char cs2 : cs) System.out.print(cs2);
            System.out.println();
        }
    }

    // 体の向き
    private enum Direction {
        UP,
        RIGHT,
        LEFT,
        DOWN
    }

    // 時計回りに90度回転
    private static Direction turnClockwise(Direction currentDirection) {
        return switch (currentDirection) {
            case UP -> Direction.RIGHT;
            case RIGHT -> Direction.DOWN;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.UP;
        };
    }

    // 反時計回りに90度回転する関数
    private static Direction turnCounterClockwise(Direction currentDirection) {
        return switch (currentDirection) {
            case UP -> Direction.LEFT;
            case LEFT -> Direction.DOWN;
            case DOWN -> Direction.RIGHT;
            case RIGHT -> Direction.UP;
        };
    }

    private static class InputHandler {
        private Scanner sc = new Scanner(System.in);
        private void close() {this.sc.close();}
        private int nextInt() {return this.sc.nextInt();}
    }
}