import java.util.Scanner;

public class AlwaysPalindromes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String newStr = reverseString(s);

		if (s.equals(newStr)) {
			System.out.println(s);
		} else {
			System.out.println(s + newStr);
		};
	}

	public static String reverseString(String str) {
		String newStr =  "";
		for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.charAt(i);
        }

		return newStr;
	}
}

