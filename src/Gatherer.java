import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Gatherer extends Actor {
    private static int instanceCounter = 0;
    private int instanceId;
    private int frameCounter = 0;
    private final int speed = 64;
    private double x, y;
    private int moveFlag = 0;

    public Gatherer() {
        super("res/images/gatherer.png");
        instanceId = instanceCounter++;
    }

    public String readCsv() {
        int recordId = 0;
        String[] stringBuffer;
        try {
            BufferedReader in = new BufferedReader(new FileReader("res/worlds/test.csv"));
            String aLine;
            while ((aLine = in.readLine()) != null) {

                stringBuffer = aLine.split(",");
                if(stringBuffer[0].equals("Gatherer")) {
                    if (recordId == instanceId) {
                        return aLine;
                    } else {
                        recordId++;
                    }
                }
            }
            System.out.println("ERROR: No more records.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    private int moveFlagGenerator() {
        int moveFlag;
        if (Math.random() < 0.25) {
            moveFlag = 0;
        } else if (Math.random() >= 0.25 && Math.random() < 0.5) {
            moveFlag = 1;
        } else if (Math.random() >= 0.5 && Math.random() < 0.75) {
            moveFlag = 2;
        } else {
            moveFlag = 3;
        }
        return moveFlag;
    }

    public void deploy() {
        if(frameCounter == 0) {
            // Initialize position
            String line = readCsv();
            x = getXCoordinate(line);
            y = getYCoordinate(line);
            drawFromTopLeft(x, y);
            frameCounter = 300;
        }

        if(frameCounter == 300) {
            moveFlag = moveFlagGenerator();
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
