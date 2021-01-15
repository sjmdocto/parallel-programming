/**
 * This class implements a dining philosopher.
 * 
 * @author Steve Docto
 * @version 2.0 - synchronized methods
 */
public class Philosopher extends Thread {
    // instance variables 
    private int id;          // Philosopher's unique identifier
    private TableMon table;  // Table where philosopher eats
    private WaiterMon waiter; //waiter monitor

    /**
     * Constructor for Philosopher objects 
     */
    public Philosopher(int id, TableMon table, WaiterMon waiter) {
        // initialize instance variables
        this.id = id;
        this.table = table;
        this.waiter = waiter;
    }


    /*
     * A dining philosopher's behavior 
     * is to eat and think -- forever!
     */ 
    public void run() {
        // don't all start in order of creation!
        this.delay( this.randomInt() );
	  
        while (true) {
            // waiter seats philosophers
            this.waiter.sitDown(this.id);

            // pick up chopsticks
            this.getChopsticks();

            // eat
            System.out.println("Philosopher " + this.id + " eating...");
            this.delay( this.randomInt() ); // chew your food!

            // finished eating, so put down chopsticks
            this.putDownChopsticks();
            System.out.println("BURP! (Philosopher " + this.id + ")");

            // leave table
            this.waiter.standUp(this.id);

            // think
            System.out.println("Philosopher " + id + " thinking...");
            this.delay( this.randomInt() ); // can't rush genius!
      }
    }

    /**
     * Pick up both chopsticks
     */
    private void getChopsticks() {
        this.table.getLeft(this.id);
        this.delay( this.randomInt() );   // simulate time to pick up chopstick
        this.table.getRight(this.id);
        this.delay( this.randomInt() );   // simulate time to pick up chopstick
    }
	
    /**
     * Philosopher puts down chopsticks.
     */
    private void putDownChopsticks() {
        this.table.putDownLeft(this.id);
        this.delay( this.randomInt() );   // simulate time to put down chopstick
        this.table.putDownRight(this.id);
        this.delay( this.randomInt() );   // simulate time to put down chopstick
    }

    /**
     * Returns a random integer.
     */
    public int randomInt() {
        double r = Math.random();
        return (int) Math.floor( r * 100 ) + 1;
    }

    /**
     * Simulates a philosopher pausing for a given amount of time.
     */
    public void delay(int mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException ex) {}
    }
}

