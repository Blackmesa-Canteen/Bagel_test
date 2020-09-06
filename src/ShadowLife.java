import bagel.*;

public class ShadowLife extends AbstractGame {
    private Image background;

    public ShadowLife() {
        super(1024, 768, "ShadowLife");
        background = new Image("res/images/background.png");
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
        background.draw(Window.getWidth() / 2.0, Window.getHeight() / 2.0);
    }
}
