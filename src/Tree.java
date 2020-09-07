public class Tree extends Actor {

    private static int instanceCounter = 0; // counting tree obj
    public Tree() {
        super("res/images/tree.png");
        instanceId = instanceCounter++;
    }

    /**
     * deploys the tree object on canvas.
     */
    public void deploy() {
        String line = readCsv("Tree");
        double x = getXCoordinate(line);
        double y = getYCoordinate(line);
        drawFromTopLeft(x, y);
    }

}
