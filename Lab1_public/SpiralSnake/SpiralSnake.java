/**
 * Name : Muhammad Mursyid Bin Rosli
 * Matric. No : A0233270R
 */
import java.util.Arrays;

// CAN TRY: marking visited space with another character

public class SpiralSnake {
  
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);
    int row = io.getInt();
    int col = io.getInt();
    String[][] arr = new String[row][col];

    int xCoord = 0;
    int yCoord = 0;

    for(int r = 0; r < row; r++) {
	    String str = io.getWord();
        String[] tempArr = str.split("");
        for(int c = 0; c < col; c++) {
		    arr[r][c] = tempArr[c]; 
        }
    }

    spiralXFinder(arr);

    io.flush();
    io.close();
  }

  public static void spiralXFinder(String[][] arr) {
    Kattio io = new Kattio(System.in);
    int m = arr.length, n = arr[0].length;  
    
    //Different possible additions to x and y  
    //r for row and c for col
    int[] dr = { 0, 1, 0, -1 };
    int[] dc = { 1, 0, -1, 0 };
    
    int x = 0, y = 0, di = 0;
    int step = 0;
   
     for (int i = 0; i < m * n; i++) {
        step++;
        if (arr[x][y].equals("X")) {
          io.println(String.format(
                      "Apple at (%d, %d) eaten at step %d",
                      y, x, step));   
        }  
        arr[x][y] = "*"; // to mark that it has been travelled
        int cr = x + dr[di];
        int cc = y + dc[di];
  
        // if next
        if (0 <= cr && cr < m && 0 <= cc && cc < n
            && !arr[cr][cc].equals("*")) {
            x = cr;
            y = cc;
        } else {
            di = (di + 1) % 4; //reset the counter when di = 3
            x += dr[di];
            y += dc[di];
        }
    }
    io.flush();
    io.close();
  }  
}
