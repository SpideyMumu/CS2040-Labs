/**
 * Name : Muhammad Mursyid Bin Rosli
 * Matric. No : A0233270R
 */
import java.util.Arrays;

public class SpiralSnake {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);
    int row = io.getInt();
    int col = io.getInt();
    String[][] arr = new String[row][col];

    int xCoord = 0;
    int yCoord = 0;

    for(int r = 0; r < row; r++) {
	    for(int c = 0; c < col; c++) {
		    arr[r][c] = io.getWord();

            if (arr[r][c].equals("X")) {
                xCoord = r;
                yCoord = c;
            }
	    }
    }

    io.println(String.format("Apple at (%d, %d) eaten at step %d", xCoord, yCoord, spiralXFinder(arr)));

    io.flush();
    io.close();
  }

  public static int spiralXFinder(String[][] arr) {
    int m = arr.length, n = arr[0].length;
    boolean[][] seen = new boolean[m][n];
    int[] dr = { 0, 1, 0, -1 };
    int[] dc = { 1, 0, -1, 0 };
    int x = 0, y = 0, di = 0;
    int count = 0;
  
        // Iterate from 0 to R * C - 1
    for (int i = 0; i < m * n; i++) {
        count++;
        if (arr[x][y].equals("X")) {
            break;            
        }
        seen[x][y] = true;
        int cr = x + dr[di];
        int cc = y + dc[di];
  
        if (0 <= cr && cr < m && 0 <= cc && cc < n
            && !seen[cr][cc]) {
            x = cr;
            y = cc;
        } else {
            di = (di + 1) % 4;
            x += dr[di];
            y += dc[di];
        }
    }
    return count;
  }  
}
