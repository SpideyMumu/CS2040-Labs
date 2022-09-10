/**
 * Name : Muhammad Mursyid
 * Matric. No : A0233270R
 */

import java.io.*;

public class Hello {
  public static void main(String args[]) throws IOException {
    // Here's some I/O boilerplate to get you started.
    Kattio io = new Kattio(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //io.print("first output\n");
    String str = br.readLine();
    String[] arr = str.split(" ");
    int num = 0;

    for (String word : arr) {
        if (word.equals("Hello")) {
            num++;
        } else if (word.equals("World")) {
            num--;
        }
    }

    //io.flush(); /* writes to screen immediately but slows program down */
    io.print(num + "\n");
    br.close();
    io.close();
  }
}
