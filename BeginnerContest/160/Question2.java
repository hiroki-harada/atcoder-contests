import java.util.Scanner;

class Question2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numInput = scan.nextInt();
        scan.close();

        int cntFiveHundred = numInput / 500;
        int cntFive = ( numInput - cntFiveHundred * 500 )/5;

        int answer = cntFiveHundred * 1000 + cntFive * 5;
        System.out.println(answer);
    }
}