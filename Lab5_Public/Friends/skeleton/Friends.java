/**
 * Name: Muhammad Mursyid
 * Matric. No: A0233270R
 */

public class Friends {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int numOfCafes = io.getInt();
    long limit = io.getLong();

    for (int i = 0; i < numOfCafes; i++) {
        String name = io.getWord();
        int numOfVisitors = io.getInt();

        for (int j = 0; j < numOfVisitors; j++) {
            io.getInt();
            io.getInt();
        }  
    }
    io.flush();
    io.close();
  }
}
