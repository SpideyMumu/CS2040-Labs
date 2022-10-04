/**
 * Name: Muhammad Mursyid B Rosli
 * Matric. No: A0233270R
 */

import java.util.*;

public class Macarons {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int numOfMacarons = io.getInt();
    int divisor = io.getInt();
    long[] macarons = new long[numOfMacarons];


    for (int i = 0; i < numOfMacarons; i++) {
        macarons[i] = io.getLong();
    }

    io.println(calculateSubsequences(macarons, divisor));
    io.flush();
    io.close();
  }

  public static long calculateSubsequences(long[] macarons, int divisor) {
    Hashtable<Long, Long> table = new Hashtable<Long, Long>();
    long totalCount = 0;
    long[] prefixModArr = new long[macarons.length];
    
    for (int i = 0; i < macarons.length; i++) {
        if (i == 0) {
            prefixModArr[i] = macarons[i] % divisor;
        } else {
            prefixModArr[i] = ((prefixModArr[i - 1] % divisor) + (macarons[i] % divisor)) % divisor;
             if(prefixModArr[i] == 0) {
                totalCount++;
            }
        } 
    }

    for (long remainder : prefixModArr) {
        if (table.containsKey(remainder)) { 
            totalCount += table.get(remainder);
            table.put(remainder,table.get(remainder) + 1);
        } else {
            table.put(remainder, (long) 1);
        }
    }

    //System.out.println(Arrays.toString(prefixModArr));
    //System.out.println(table);
    //totalCount += table.values().stream().reduce((long) 0, (subtotal, element) -> subtotal + element); 
    return totalCount; 
  }
}
