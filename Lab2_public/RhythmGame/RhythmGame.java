/**
 * Name: Muhammad Mursyid Bin Rosli
 * Matric. No: A0233270R
 */
import java.util.*;

public class RhythmGame {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int num = io.getInt();

    LinkedList<Integer> list = new LinkedList<Integer>();

    for (int i = 0; i < num; i++) {
        list.add(io.getInt());
    }
    //ArrayList<Integer> finalLis; 
    io.println(comboMaker(list).size());
    io.println(comboMaker(list));

    io.flush();
    io.close();
  }

  public static LinkedList<Integer> comboMaker(LinkedList<Integer> list) {
   LinkedList<Integer> finalList = new LinkedList<Integer>();
   boolean alternatingMode = false;
   boolean addToLeft = false;

   for (Integer num : list) {
    if (num == 0) {
      finalList.clear();  
    } else if (num > 0 && num < 5) {
            if (addToLeft) {
                finalList.add(0, num);
            } else {
             finalList.add(num);
            }    
    } else if (num == 5) {
        addToLeft = true;
    } else if (num == 6) {
        alternatingMode = !alternatingMode;
    }

    //to toggle addToLeft during alternatingMode
    if (alternatingMode && addToLeft) {
        addToLeft = false;
    } else if (alternatingMode && !addToLeft) {
        addToLeft = true;
    } 
    
    //for toggling off number 5 
    if (!alternatingMode && addToLeft) {
        addToLeft = false;
    }
   }
    return finalList;
  }
}
