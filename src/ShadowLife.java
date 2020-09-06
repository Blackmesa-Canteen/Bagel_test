import bagel.*;

/*IntelliJ VCS test*/
public class ShadowLife extends AbstractGame {
    private Image background;
    private Tree[] trees;
    private Gatherer[] gatherers;
    private Tree tree0;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Gatherer gatherer0;
    private Gatherer gatherer1;

    public ShadowLife() {
        super(1024, 768, "ShadowLife");
        background = new Image("res/images/background.png");
        tree0 = new Tree();
        tree1 = new Tree();
        tree2 = new Tree();
        tree3 = new Tree();
        gatherer0 = new Gatherer();
        gatherer1 = new Gatherer();
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
        tree0.deploy();
        tree1.deploy();
        tree2.deploy();
        tree3.deploy();
        gatherer0.deploy();
        gatherer1.deploy();
    }
}
