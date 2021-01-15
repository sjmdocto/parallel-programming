/**
 * This class is an implementation of the table from the Dining 
 * Philosophers problem. The activities of obtaining and releasing
 * chopsticks are implemented using synchronized methods -- Java's 
 * version of approximating a monitor.  Philosophers wait() for chopsticks
 * on the table object's implicit wait queue; and upon releasing 
 * their chopsticks, signal any waiting philosophers via notifyAll().
 * 
 * @author Steve Docto
 * @version 2.0 - synchronized methods
 */
public class TableMon {
    // an array of "chopsticks"
    private int[] chopstick;

   /*
    * Table Constructor
    */
    public TableMon() {
      /*
       * Allocate chopstick array (need 5 chopsticks)
       */
      chopstick = new int[6];  // chopstick "0" not used...
      for (int i = 1; i <= 5; i++) {
        chopstick[i] = 1;      // initially each chopstick is available
      }
    }

   /*
    * Synchronized method to pick up left chopstick of given philosopher.
    * Notice the use of wait() to avoid busy waiting. This queues
    * the philosopher on the table's implicit condition variable.
    */
    public synchronized void getLeft(int id) {
        // wait for left chopstick, if necessary, then pick up
        while ( chopstick[id] == 0 ) {
            System.out.println("Philosopher " + id + " waiting for left chopstick...");
        try { wait(); }
            catch (InterruptedException ex) {}
        }
        chopstick[id] = 0;
        System.out.println("Philosopher " + id + " picked up left chopstick!");
    }

   /*
    * Synchronized method to pick up right chopstick of given philosopher.
    * Notice the use of wait() to avoid busy waiting. This queues
    * the philosopher on the table's implicit condition variable.
    */
    public synchronized void getRight(int id) {
        // wait for right chopstick, if necessary, then pick up
        while ( chopstick[id%5 + 1] == 0 ) {
            System.out.println("Philosopher " + id + " waiting for right chopstick...");
        try { wait(); }
            catch (InterruptedException ex) {}
        }
      chopstick[id%5 + 1] = 0;
      System.out.println("Philosopher " + id + " picked up right chopstick!");
    }

   /* 
    * Effect of this method: philosopher puts down left chopstick.
    * Since method is synchronized, the body treats access to
    * chopstick as critical section.
    */
    public synchronized void putDownLeft(int id) {
        // put down left chopstick
        chopstick[id] = 1;
        System.out.println("Philosopher " + id + " put down left chopstick.");

        // give the other philosophers a chance to eat
        notifyAll();
    }
	
   /* 
    * Effect of this method: philosopher puts down left chopstick.
    * Since method is synchronized, the body treats access to
    * chopstick as critical section.
    */
    public synchronized void putDownRight(int id) {
        // put down right chopstick
        chopstick[id%5 + 1] = 1;
        System.out.println("Philosopher " + id + " put down right chopstick.");

        // give the other philosophers a chance to eat
        notifyAll();
    }
}

