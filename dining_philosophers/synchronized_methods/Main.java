/**
 * This is the main program to demonstrate 
 * a monitor solution to the Dining Philosophers 
 * problem in Java.  It uses threads and Java's
 * object synchronization mechanism.
 * 
 * @author Steve Docto
 * @version 2.0 - synchronized methods
 */
public class Main {
    /*
     * The main method for the Main class
     */
    public static void main(String[] arg) {
        // Create the philosophers' table
        TableMon table = new TableMon();

        // Create the waiter (the monitor)
        WaiterMon waiter = new WaiterMon();

        // Create and start the philosophers (threads)
        for (int i=1; i <= 5; i++) {
            new Philosopher(i, table, waiter).start();
        }
    }
}

