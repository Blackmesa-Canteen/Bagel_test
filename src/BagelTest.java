import bagel.*;

import java.util.Random;

/**
 * An example Bagel game.
 *
 * @author Eleanor McMurtry
 */
public class BagelTest extends AbstractGame {
    private TestClass smiley;
    private Image bagel;
    private double x = 100;
    private double y = 100;

    public BagelTest() {
        super(1024, 768, "Hello World");
        bagel = new Image("res/bagel.png");
        smiley = new TestClass("res/images/tree.png");
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        BagelTest game = new BagelTest();
        game.run();
    }

    /**
     * Performs a state update. This simple example shows an image that can be controlled with the arrow keys, and
     * allows the game to exit when the escape key is pressed.
     */
    @Override
    public void update(Input input) {
        double speed = 0.5;

        if (input.isDown(Keys.LEFT)) {
            x -= speed;
        }
        if (input.isDown(Keys.RIGHT)) {
            x += speed;
        }
        if (input.isDown(Keys.UP)) {
            y -= speed;
        }
        if (input.isDown(Keys.DOWN)) {
            y += speed;
        }

        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }


        bagel.draw(Window.getWidth() / 2.0, Window.getHeight() / 2.0);
        smiley.draw(x, y);
    }
}
