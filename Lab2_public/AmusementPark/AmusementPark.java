/**
 * Name : Muhammad Mursyid
 * Matric. No : A0233270R
 */
import java.io.*;
import java.util.*;

public class AmusementPark {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Kattio io = new Kattio(System.in);
        
        //Stores all RidesForTheDay object to be printed at the end
        LinkedList<RidesForTheDay> listOfDays = new LinkedList<RidesForTheDay>();
        
        RidesForTheDay ride = new RidesForTheDay(0);

        //keepRunning will turn to false upon END command
        boolean keepRunning = true;
        
        while (keepRunning) {
            String command = br.readLine();
                    
            //commandDetector() will return an integer that determines which
            //RidesForTheDay methods to execute
            switch (commandDetector(command)) {
                case 1: // START RIDE - reassign a new RidesForTheDay object to 'ride'
                    ride = ride.newDay(extractInt(command));
                    listOfDays.add(ride);
                    break;
                case 2: // NEXT RIDE - add ride to the back of list
                    ride.nextRide(extractInt(command));
                    break;
                case 3: // DELETE FRONT
                    if (extractInt(command) > ride.numOfRides()) {//when num is more than size of list
                        io.println("Invalid command");
                    } else {
                        ride.deleteFront(extractInt(command));
                    }
                    break;
                case 4: // DELETE BACK
                    if (extractInt(command) > ride.numOfRides()) {//when num is more than size of list
                        io.println("Invalid command");
                    } else {
                        ride.deleteBack(extractInt(command));
                    }
                    break;
                case 5: // CHANGE FRONT
                    int[] arrFront = extractTwoInt(command);
                    if (arrFront[0] > ride.numOfRides()) {//when num is more than size of list
                        io.println("Invalid command");
                    } else {
                        ride.changeFront(arrFront);
                    }
                    break;
                case 6: // CHANGE BACK
                    int[] arrBack = extractTwoInt(command);
                    if (arrBack[0] > ride.numOfRides()) {//when num is more than size of list
                        io.println("Invalid command");
                    } else {
                        ride.changeBack(arrBack);
                    }
                    break;
                case 7: // NEXT DAY
                    break;
                case 8: // END
                    //this will stop while loop from running
                    keepRunning = false;
                    break;
                default:
                    io.println("Invalid command");
            }
        }
        listOfDays.forEach(x -> io.println(x));
        io.flush();
        io.close();
    }

    //Return a number based on the command -
    //this is to neaten the statements in main method
    public static int commandDetector(String command) {
        if (command.contains("START")) {
            return 1;
        } else if (command.contains("NEXT RIDE")) {
            return 2;
        } else if (command.contains("DELETE FRONT")) {
            return 3;
        } else if (command.contains("DELETE BACK")) {
            return 4; 
        } else if (command.contains("CHANGE FRONT")) {
            return 5;
        } else if (command.contains("CHANGE BACK")) {
            return 6;
        } else if (command.equals("NEXT DAY")) {
            return 7;
        } else if (command.equals("END")) {
            return 8;
        } 
        return -1;
    }

    //Extract the single digit from the command
    public static int extractInt(String command) {
        int a = command.indexOf(":");
        String num = command.substring(a + 1).trim();
        return Integer.parseInt(num);
    }

    //Extract the 2 digits from the command and store in an array
    //Used only for CHANGE commands
    public static int[] extractTwoInt(String command) {
        int a = command.indexOf(":");
        String num = command.substring(a + 1).trim();
        String[] arrOfStr = num.split(" ");

        int[] arrOfInt = new int[2];
        for (int i = 0; i < 2; i++) {
            arrOfInt[i] = Integer.parseInt(arrOfStr[i]);
        }
        return arrOfInt;
    }
}

/*
 * Class RidesForTheDay is to store the day number and rides for the day as an object
 */
class RidesForTheDay {

    //attributes
    int day;
    LinkedList<Integer> rides;

    //constructors
    RidesForTheDay(int day) {
        this.day = day;
        this.rides = new LinkedList<Integer>();
    }

    RidesForTheDay(int day, LinkedList<Integer> rides) {
        this.day = day;
        this.rides = rides;
    }

    //add ride to the back of LinkedList
    public void nextRide(int rideId) {
        rides.add(rideId);
    }
    
    //return new RidesForTheDay object with updated day
    public RidesForTheDay newDay(int rideId) {
        LinkedList<Integer> newRides = new LinkedList<Integer>();
        newRides.add(rideId);
        return new RidesForTheDay(day + 1, newRides);
    }
    
    //delete first num rides
    public void deleteFront(int num) {
        for (int i = 0; i < num; i++) {
            rides.pollFirst();
        }
    }

    //delete last num rides
    public void deleteBack(int num) {
        for (int i = 0; i < num; i++) {
            // pollFirst
            rides.pollLast();
        }
    }

    //delete rides from the front with class methods then add to the front
    public void changeFront(int[] arr) {
        this.deleteFront(arr[0]);
        this.rides.addFirst(arr[1]);
    }

    //delete rides from the back with class methods then add to the back
    public void changeBack(int[] arr) {
        this.deleteBack(arr[0]);
        this.nextRide(arr[1]);
    }

    //return length of LinkedList
    public int numOfRides() {
        return rides.size();
    }

    @Override
    public String toString() {
        return String.format("Day %d: %s", day, rides);
    }
}
