import java.util.Scanner;

public class LineSensor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        String[][] c = new String[h][w];

        for (int i = 0; i < h; i++) {
            // Cij Cij+1 は連結しているため、分割
            String[] temp = sc.next().split("");
            for (int j = 0; j < w; j++) {
                c[i][j] = temp[j];
            }
        }
        sc.close();

        for (int j = 0; j < w; j++) {
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                if (c[i][j].equals("#")) cnt++;
            }
            System.out.print(cnt + " ");
        }

    }
}