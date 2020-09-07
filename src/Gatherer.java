public class Gatherer extends Actor {

    private static int instanceCounter = 0; // counting gatherer objs
    private int frameCounter = 0;
    private double x, y;

    public Gatherer() {
        super("res/images/gatherer.png");
        instanceId = instanceCounter++;
    }

    private int moveFlagGenerator() {
        int moveFlag;
        double roll = Math.random();
        if (roll < 0.25) {
            moveFlag = 0;
        } else if (roll >= 0.25 && roll < 0.5) {
            moveFlag = 1;
        } else if (roll >= 0.5 && roll < 0.75) {
            moveFlag = 2;
        } else {
            moveFlag = 3;
        }
        return moveFlag;
    }

    /*
     * https://piazza.com/class/kdfeskxlts6rr?cid=90
     * https://blog.csdn.net/weixin_42447373/article/details/88814221
     *
     * */
    public void deploy() {
        if(frameCounter == 0) {
            // Initialize position
            String line = readCsv("Gatherer");
            x = getXCoordinate(line);
            y = getYCoordinate(line);

        }

        // 5 ticks mean 2.5 seconds,
        // If FPS is 120, then 300 frames take 2.5 second.
        if(frameCounter == 300) {
            int moveFlag = moveFlagGenerator();
            final int speed = 64; //a tile
            switch(moveFlag) {
                case 0 :
                    x += speed;
                    break;
                case 1 :
                    x -= speed;
                    break;
                case 2 :
                    y += speed;
                    break;
                case 3 :
                    y -= speed;
                    break;
            }
            frameCounter = 1;

        } else {
            frameCounter++;
        }
        drawFromTopLeft(x, y);

    }

}
