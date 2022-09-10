/**
 * Name: Muhammad Mursyid Rosli
 * Matric. No: A0233270R
 */
import java.util.*;

public class Entrepreneurship {

  public static void main(String args[]) {
    Kattio io = new Kattio(System.in);

    long numOfCommands = io.getLong(); //num of commands
    int maxOrders = io.getInt(); // max orders

    LinkedList<Batch> batches = new LinkedList<Batch>();

    Stack<Order> tempStack = new Stack<Order>();

    for (int i = 0; i < numOfCommands; i++) {
      String command = io.getWord();
      if (command.equals("ADD")) {
        long maxAdd = io.getLong();
        String dir = io.getWord();
        LinkedList<Order> pizzaOrders = new LinkedList<Order>();

        if (dir.equals("L")) {
          for (int a = 0; a < maxAdd; a++) {
            //add to pizzaOrders
            Order order = new Order(io.getLong(), io.getDouble());
            pizzaOrders.add(order);
          }
        } else {
          for (int b = 0; b < maxAdd; b++) {
            //add to tempStack
            Order order = new Order(io.getLong(), io.getDouble());
            tempStack.push(order);
          }
          //from tempStack add to pizzaOrders
          while (!tempStack.empty()) {
            pizzaOrders.add(tempStack.pop());
          }
        }
        Batch currBatch = new Batch(pizzaOrders);
        batches.add(currBatch);
      } else if (command.equals("CANCEL")) {
        long maxCancel = io.getLong();

        //Wrong cancelling mechanism
        for (int k = 0; k < maxCancel; k++) {
          batches.removeLast();
        }
      }
    }
    System.out.printf("%.1f%n", revenueCalc(extractOrders(batches), maxOrders));
    io.flush();
    io.close();
  }

  //Extract each Order from Batch LinkedList of Orders into one LinkedList 
  public static LinkedList<Order> extractOrders (LinkedList<Batch> batches) {
    LinkedList<Order> orders = new LinkedList<>();
    while(!batches.isEmpty()) {
        orders.addAll(batches.pollFirst().getOrders());
    }
    return orders;
  }

  public static double revenueCalc(LinkedList<Order> pizzaOrders, long maxOrders) {
    double currSum = 0.0;
    long currSize = 0;

    while (!pizzaOrders.isEmpty()) {
      Order order = pizzaOrders.pollFirst();
      //add current order in if still below limit
      if (currSize + order.getSize() <= maxOrders) {
        currSum += order.getRevenue();
        currSize += order.getSize();
      }
    }

    return currSum;
  }
}

class Batch {
    private LinkedList<Order> orders;

    Batch() {
        orders = new LinkedList<Order>();
    }
    
    Batch(LinkedList<Order> orders) {
        this.orders = orders;
    }

    LinkedList<Order> getOrders() {
        return orders;
    }
}

class Order {

  private long numOfpizzas;
  private double price;

  Order(long n, double p) {
    numOfpizzas = n;
    price = p;
  }

  long getSize() {
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
