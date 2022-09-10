/**
 * Name : Muhammad Mursyid
 * Matric. No : A0233270R
 */
import java.io.*;
import java.util.*;

public class AmusementPark {
  //static int day = 0;
   
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Kattio io = new Kattio(System.in);
    //LinkedList<Integer> list = new LinkedList<Integer>();
    int day = 0;
    RideForTheDay ride = new RideForTheDay(day);
    boolean keepRunning = true;

    while (keepRunning) {
        String command = br.readLine();
        switch (commandDetector(command)) {
        case 1: //START RIDE
            ride.newDay(extractInt(command));
            break;
        case 2: //NEXT RIDE
            ride.nextRide(extractInt(command));
            break;
        case 3://DELETE FRONT
            if (extractInt(command) > ride.numOfRides()) {
                io.println("Invalid Command");
            } else {
                ride.deleteFront(extractInt(command));
            }
            break;
        case 4://DELETE BACK
            if (extractInt(command) > ride.numOfRides()) {
                io.println("Invalid Command");
            } else {
                ride.deleteBack(extractInt(command));
            }
            break;
        case 5://CHANGE FRONT
            int[] arrFront = extractTwoInt(command);
            if (arrFront[0] > ride.numOfRides()) {
                io.println("Invalid Command");
            } else {
                ride.changeFront(arrFront);
            }
            break;
        case 6://CHANGE BACK
            int[] arrBack = extractTwoInt(command);
            if (arrBack[0] > ride.numOfRides()) {
                io.println("Invalid Command");
            } else {
                ride.changeBack(arrBack);
            }
            break;
        case 7://NEXT DAY
            io.println(ride);
            break;
        case 8://END
            io.println(ride);
            keepRunning = false;
            break;
        default:
            io.println("Invalid Command");
        }
    }

    io.flush();
    io.close();
  }

    public static int extractInt(String command) {
        int a = command.indexOf(":");
        String num = command.substring(a + 1).trim();

        if (num.length() > 1) {
            String[] arr = num.split(" ");
        }

        return Integer.parseInt(num);
    }

    public static int[] extractTwoInt(String command) {
        int a = command.indexOf(":");
        String num = command.substring(a + 1).trim();            
        String[] arrOfStr = num.split(" ");

        //System.out.println(Arrays.toString(arrOfStr));
        int[] arrOfInt = new int[2];
        for (int i = 0; i < 2; i++) {
            arrOfInt[i] = Integer.parseInt(arrOfStr[i]);    
        }
        //System.out.println(Arrays.toString(arrOfInt));
        return arrOfInt;
    }


    public static int commandDetector(String command) {
        //Kattio io = new Kattio(System .in);
        if (command.contains("DELETE FRONT")) {
           //io.println("Invalid Command");
           return 3;
        } else if (command.contains("DELETE BACK")) {
           //io.println("Invalid Command");
           return 4;
        } else if (command.contains("NEXT RIDE")) {
            return 2;
        } else if (command.contains("START")) {
            //new ride for new day
            return 1;
        } else if (command.contains("CHANGE FRONT")) {
            return 5;
        } else if (command.contains("CHANGE BACK")) {
            return 6;
        } else if (command.equals("END")) {
            return 8; 
        } else if (command.equals("NEXT DAY")) {
           return 7;
        }
        return -1;
    }

  //public static void commandDetector(String command) {}
}

class RideForTheDay {
    int day;
    LinkedList<Integer> rides;

    RideForTheDay(int day) {
        this.day = day;
        this.rides = new LinkedList<Integer>();
    }

    RideForTheDay(int day, LinkedList<Integer> rides) {
        this.day = day;
        this.rides= rides;
    }

    public void nextRide(int rideId) {
        rides.add(rideId);
    }

    public void newDay(int rideId) {
        this.day++;
        if (rides.isEmpty()) {
            rides.add(rideId);
        } else {
            rides.clear();
            rides.add(rideId);
        }
    }

    public void deleteFront(int num) {
        for (int i = 0; i < num; i++) {
            //pollFirst
            rides.pollFirst();
        }
    }
    
    public void deleteBack(int num) {
        for (int i = 0; i < num; i++) {
            //pollFirst
            rides.pollLast();
        }
    }

    public void changeFront(int[] arr) {
        this.deleteFront(arr[0]);
        this.rides.addFirst(arr[1]);
    }

    public void changeBack(int[] arr) {
        this.deleteBack(arr[0]);
        this.nextRide(arr[1]);
    }

    public int numOfRides() {
        return rides.size();
    }

    @Override
    public String toString() {
        return String.format("Day %d: %s", day, rides);
    }
}

