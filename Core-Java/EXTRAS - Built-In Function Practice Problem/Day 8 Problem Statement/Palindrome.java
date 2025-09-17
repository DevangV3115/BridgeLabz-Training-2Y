import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll(" ", "");
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPalindrome(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
