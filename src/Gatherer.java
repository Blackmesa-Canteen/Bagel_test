public class Gatherer extends Actor {

    private static int instanceCounter = 0; // counting gatherer obj
    private int frameCounter = 0;  // counting frames
    private double x, y; // coordinate
    private boolean initialized = false;
    private final int SPEED = 64; //a tile
    private final int TICKS_BETWEEN_CHANGES = 5; // ticks between changes of direction
    private enum Direction
    {
        UP, DOWN, LEFT, RIGHT
    }
    private Direction direction;

    public Gatherer() {
        super("res/images/gatherer.png");
        instanceId = instanceCounter++;
    }

    /**
     * choose the drection in random,
     * each direction's possibility is 0.25
     */
    private Direction moveDirectionGenerator() {
        double roll = Math.random(); // random number in [0, 1)
        if (roll < 0.25) {
            return Direction.UP;

        } else if (roll >= 0.25 && roll < 0.5) {
            return Direction.DOWN;

        } else if (roll >= 0.5 && roll < 0.75) {
            return Direction.LEFT;

        } else {
            return Direction.RIGHT;
        }
    }

    /**
     * deploy. Speed is 64 pixels per tick(a tile per second),
     * direction will change randomly in every 5 ticks(value of TICKS_BETWEEN_CHANGES)
     */
    public void deploy() {
        if (!initialized) {
            // Initialize position based on csv file
            String line = readCsv("Gatherer");
            x = getXCoordinate(line);
            y = getYCoordinate(line);
            direction = moveDirectionGenerator();
            initialized = true;

        } else {
            // After initialization
            if (frameCounter == TICKS_BETWEEN_CHANGES) {
                // change direction after 5 ticks.
                frameCounter = 0;
                direction = moveDirectionGenerator();
            }

            frameCounter++;
            switch(direction) {
               case RIGHT :
                   x += SPEED;
                   break;
               case LEFT :
                   x -= SPEED;
                   break;
               case UP :
                   y += SPEED;
                   break;
               case DOWN :
                   y -= SPEED;
                   break;
            }

            /* Prevent gatherers going too far away from visible screen.
             * They may move off the visible screen, but only in 1 tile away.
             */
            if (x > 1024) {
                x = 0;
            } else if (x < 0) {
                x = 1024;
            }

            if (y < 0) {
                y = 768;
            } else if (y > 768) {
                y = 0;
            }

        }
        drawFromTopLeft(x, y);
    }

}
