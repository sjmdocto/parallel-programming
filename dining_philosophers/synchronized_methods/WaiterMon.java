/**
 * This class implements a waiter monitor
 * 
 * @author Steve Docto
 * @version 2.0 - synchronized methods
 */

 public class WaiterMon {
     private int seatCount;

     // WaiterMon constructor
     public WaiterMon(){
         seatCount = 0;
     }

     public synchronized void sitDown(int id) {
         //wait if the table is full
         while(seatCount >= 4) {
            System.out.println("Philosopher " + id + " is waiting for a seat...");
            try { wait(); }
                catch (InterruptedException ex) {}
         }
         seatCount++;
         System.out.println("Philosopher " + id + " is now seated.");
     }

     public synchronized void standUp(int id) {
         seatCount--;
         System.out.println("Philosopher " + id + " has left the table.");
         notifyAll();//let others know a seat has opened up
     }
 }
 