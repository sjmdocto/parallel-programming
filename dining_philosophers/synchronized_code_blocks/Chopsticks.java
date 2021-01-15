/**
 * This class implements the chopsticks.
 * 
 * @author Steve Docto
 * @version 1.0 - synchronized code blocks
 */

 public class Chopsticks {
    // array of chopstick objects
    private Chopstick[] chopsticks;

    /*
    * Chopsticks constructor
    */
    public Chopsticks() {
        // chopstick 0 is not used
        this.chopsticks = new Chopstick[6];
        for (int i = 1; i <= 5; i++) {
            // initially, each chopstick is available
            chopsticks[i] = new Chopstick();
        }
    }

     // inner Chopstick class
    class Chopstick {
        // boolean to keep track of whether chopstick is being used or not
        private boolean use;
        public Chopstick(){
            this.use = false;
        }
        public boolean getUse(){
            return use;
        }
        public void setUse(boolean change){
            use = change;
        }
    }
     
    // get left chopstick
    public Chopstick getLeft(int id) {
        chopsticks[id].setUse(true);
        return chopsticks[id];
    }

    // get right chopstick
    public Chopstick getRight(int id) {
        chopsticks[id%5 + 1].setUse(true);
        return chopsticks[id%5 + 1];
    }

    // put down left chopstick
    public void putDownLeft(int id){
        chopsticks[id].setUse(false);
    }

    // put down left chopstick
    public void putDownRight(int id){
        chopsticks[id%5 + 1].setUse(false);
    }
}