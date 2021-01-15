/**
 * This class implements a dining philosopher.
 * 
 * @author Steve Docto
 * @version 1.0 - synchronized code blocks
 */
public class Philosopher extends Thread {
    private int id;          // Philosopher's unique identifier
    private Chopsticks table;  // sets table full of chopsticks

    /**
     * Constructor for Philosopher objects 
     */
    public Philosopher(int id, Chopsticks table) {
        // initialize instance variables
        this.id = id;
        this.table = table;
    }

    /*
     * A dining philosopher's behavior 
     * is to eat and think -- forever!
     */ 
    public void run() {
        // don't all start in order of creation!
        this.delay( this.randomInt() );
	  
        while (true) {
        // synchronized code block
        synchronized(this.table.getLeft(this.id)) {// pick up left chopstick
            synchronized(this.table.getRight(this.id)) {// pick up right chopstick
                // eat
                System.out.println("Philosopher " + this.id + " eating...");
                this.delay( this.randomInt() ); // chew your food!

                // finished eating, so put down chopsticks
                this.putDownChopsticks();
                System.out.println("BURP! (Philosopher " + this.id + ")");
            }
        }
        // think
        System.out.println("Philosopher " + id + " thinking...");
        this.delay( this.randomInt() ); // can't rush genius!
        }
    }

    /**
     * Put down left chopstick, then right chopstick
     */
    private void putDownChopsticks() {
      this.table.putDownLeft(this.id);
      this.table.putDownRight(this.id);
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

