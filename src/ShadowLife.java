import bagel.*;

/*IntelliJ VCS test*/
public class ShadowLife extends AbstractGame {
    private Image background;
    private Tree tree0;
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;

    public ShadowLife() {
        super(1024, 768, "ShadowLife");
        background = new Image("res/images/background.png");
        tree0 = new Tree("res/images/tree.png");
        tree1 = new Tree("res/images/tree.png");
        tree2 = new Tree("res/images/tree.png");
        tree3 = new Tree("res/images/tree.png");
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
        tree0.setTree();
        tree1.setTree();
        tree2.setTree();
        tree3.setTree();
    }
}
