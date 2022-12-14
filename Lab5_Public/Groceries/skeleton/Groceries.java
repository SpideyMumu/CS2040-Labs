/**
 * Name: Muhammad Mursyid Rosli
 * Matric. No: A0233270R
 */

import java.util.*; 

public class Groceries {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int numOfItems = io.getInt();
    int minItems = io.getInt();
    int freeItems = io.getInt();
    int[] items = new int[numOfItems];
    //ArrayList<Integer> arr = new ArrayList<Integer>;

    for (int i = 0; i < numOfItems; i++) {
        items[i] = io.getInt();
    }

    if (numOfItems < minItems) {
        io.println(calcTotalPrice(items));
    } else {
        //io.println(calcTotalPrice(items));
        //io.println(calcPromo(items, freeItems, minItems));
        
        io.println(
                calcTotalPrice(items) -
                calcPromo(items, freeItems, minItems)
                );
    }

    io.flush();
    io.close();
  }

  static int calcPromo(int[] items, int freeItems, int minItems) {
    //1. Sort array
    Arrays.sort(items);
    
    int discount = 0;
    int count = items.length - minItems;

    while (count >= 0) {
        //System.out.println("current count is: " + count);
        //discount += items[i];   
        for (int i = 0; i < freeItems; i++) {
         discount += items[count + i];
        }
    count -= minItems;
    }
    return discount;
  }

  static int calcTotalPrice(int[] items) {
    int totalPrice = 0;

    for (int price : items) {
        totalPrice += price;
    }

    return totalPrice;
  }
}
