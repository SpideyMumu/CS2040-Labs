/**
 * Name : Muhammad Mursyid
 * Matric. No : A0233270R
 */

import java.util.Scanner;

public class TwoDCipher {
  private static String alphabets = "abcdefghijklmnopqrstuvwxyz";

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int rows = sc.nextInt();
    int columns = sc.nextInt();

    sc.nextLine();

    String text = sc.nextLine();

    encryptor(text, rows, columns);
  }

  private static void encryptor(String str, int row,  int col) {
    String newStr = "";
    int charNum = 0;

    for(int r = 0; r < row; r++) {
        for(int c = 0; c < col; c++) {
            int caesarNum = (r + 1) * (c + 1);
		    int num = alphabets.indexOf(str.charAt(charNum)) + caesarNum;
            if (num > 25) {
                newStr += alphabets.charAt(num%26);
            } else {
                newStr += alphabets.charAt(num);
            }
            charNum++;
	    }
    }

    for(int i = 0; i < row * col; i+=col) {
        System.out.println(newStr.substring(i, i+col));
    }
  }

}
