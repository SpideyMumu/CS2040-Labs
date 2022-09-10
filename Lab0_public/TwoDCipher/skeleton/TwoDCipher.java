/**
 * Name : Muhammad Mursyid
 * Matric. No : A0233270R
 */

import java.util.Scanner;

public class TwoDCipher {
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int rows = sc.nextInt();
    int columns = sc.nextInt();

    sc.nextLine();

    String text = sc.nextLine();

    System.out.println(encryptor(text, rows, columns));
  }

  private static String encryptor(String str, int row,  int col) {
    String newStr = "";
    String finalStr = "";
    int charNum = 0;

    for(int r = 0; r < row; r++) {
        for(int c = 0; c < col; c++) {
            int caesarNum = (r + 1) * (c + 1);
            //System.out.print(str.charAt(r + c));
            //System.out.println(caesarNum);
		    newStr += (char) (str.charAt(charNum) + caesarNum);
            charNum++;
	    }
    }

    for(int i = 0; i < row * col; i+=col) {
        finalStr += newStr.substring(i, i+col) + "\n";
    }


    return finalStr;
  }

}
