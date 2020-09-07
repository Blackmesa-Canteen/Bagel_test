import bagel.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShadowLife extends AbstractGame {
    private final Image BACKGROUND = new Image("res/images/background.png");
    private Actor[] treeArray;
    private Actor[] gathererArray;
    private final long TICK = 500; // a tick == 500 ms

    /** This method will read csv file, find the number of  object with a specified name
     * , then return the instance number. The number will be handy in instantiating objects.
     */
    private int countInstances(String className) {
        int countInstance = 0; // IDs of instance-name-matched records
        String[] stringBuffer; // store a line of record
        String aLine;
        try {
            BufferedReader in = new BufferedReader(new FileReader("res/worlds/test.csv"));
            while ((aLine = in.readLine()) != null) {

                stringBuffer = aLine.split(",");
                if(stringBuffer[0].equals(className)) {
                    countInstance++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return countInstance;
    }

    /** This method will create Actor(Tree or Gatherer) instances.
     */
    private Actor[] createInstances(String className) {
        int i;
        int instanceNumber = countInstances(className);
        Actor[] actorArray = new Actor[instanceNumber];
        if (className.equals("Tree")) {
            for(i = 0; i < instanceNumber; i++) {
                actorArray[i] = new Tree();
            }

        } else if (className.equals("Gatherer")) {
            for(i = 0; i < instanceNumber; i++) {
                actorArray[i] = new Gatherer();
            }
        }

        return actorArray;
    }

    /** This method will deploy a Actor(Tree or Gatherer) object array.
     */
    private void deployActorArray(Actor[] actorArray) {
        for (Actor actor : actorArray) {
            actor.deploy();
        }
    }

    /** This method will deploy (tickNumber * 500)ms.
     */
    private void delayTicks(int tickNumber) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        while((end - start) != (TICK * tickNumber)) {
            end = System.currentTimeMillis();
        }
    }

    /** init the world.
     */
    public ShadowLife() {
        super(1024, 768, "ShadowLife");
        //instantiating Actors
        treeArray = createInstances("Tree");
        gathererArray = createInstances("Gatherer");
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        ShadowLife game = new ShadowLife();
        game.run();
    }

    /**
     * Performs a state update.
     */
    public void update(Input input) {

        BACKGROUND.drawFromTopLeft(0, 0);
        deployActorArray(treeArray);
        deployActorArray(gathererArray);

        //set updating frequency to 2 per second (1 tick).
        delayTicks(1);
    }
}
