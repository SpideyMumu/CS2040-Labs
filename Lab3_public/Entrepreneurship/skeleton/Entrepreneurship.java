/**
 * Name: Muhammad Mursyid Rosli
 * Matric. No: A0233270R
 */
import java.util.*;

public class Entrepreneurship {
  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    int numOfCommands = io.getInt(); //num of commands
    int maxOrders = io.getInt(); // max orders
    
    Deque<BatchOrder> pizzaOrders = new LinkedList<BatchOrder>();

    Stack<BatchOrder> tempStack = new Stack<BatchOrder>();

    for (int i = 0; i < numOfCommands; i++) {
        String command = io.getWord();

        if (command.equals("ADD")) {
            int maxAdd = io.getInt();
            String dir = io.getWord();
            
            if (dir.equals("L")) {
                for (int a = 0; a < maxAdd; a++) {
                    //add to pizzaOrders
                    BatchOrder batch = new BatchOrder(io.getInt(), io.getDouble());
                    pizzaOrders.add(batch);
                }
            } else {
                for (int b = 0; b < maxAdd; b++) {
                    //add to tempStack
                    BatchOrder batch = new BatchOrder(io.getInt(), io.getDouble());
                    tempStack.push(batch);
                }
                //from tempStack add to pizzaOrders
                while(!tempStack.empty()) {
                    pizzaOrders.add(tempStack.pop());
                }
            }
        } else if (command.equals("CANCEL")) {
           int maxCancel = io.getInt();

           for (int k = 0; k < maxCancel; k++) {
                //remove from pizzaOrders 
                pizzaOrders.pollLast();
           }
        }
    }
    //System.out.println(pizzaOrders);
    io.println(String.format("%.1f", revenueCalc(pizzaOrders, maxOrders)));
    io.flush();
    io.close();
  }


  public static double revenueCalc(Deque<BatchOrder> pizzaOrders, int maxOrders) {
      double currSum = 0.0;
      int currSize = 0;
      //double tempFirst = 0.0;
      

      while (!pizzaOrders.isEmpty()) {
          BatchOrder order = pizzaOrders.pollFirst();
          //System.out.println(order); 
          //add current order in if still below limit
          if (currSize + order.getSize() <= maxOrders) {
            currSum += order.getRevenue();
            currSize += order.getSize();
            System.out.println(currSize);
          }
          //currSum += order.getRevenue();
          //currSize += order.getSize();
      }
      
      
      return currSum;  
  }
}

class BatchOrder {
    
    private int numOfpizzas;
    private double price;

    BatchOrder(int n, double p) {
        numOfpizzas = n;
        price = p;
    }

    int getSize() {
        return numOfpizzas;
    }

    double getPrice() {
        return price;
    }

    double getRevenue() {
        return numOfpizzas * price;
    }

    @Override
    public String toString() {
        return String.format("Quantity: %d, Price: %.1f", numOfpizzas, price);
    }

}
