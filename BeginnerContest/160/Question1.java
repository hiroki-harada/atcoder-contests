import java.util.Scanner;

class Question1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String strInput = scan.nextLine();
        scan.close();

        String answer = "No";
        if (strInput.charAt(2) == strInput.charAt(3)) {
            if(strInput.charAt(4) == strInput.charAt(5)) {
                answer = "Yes";
            }
        }
        System.out.println(answer);
    }
}