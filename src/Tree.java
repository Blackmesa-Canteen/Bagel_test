import bagel.*;
import java.io.*;


public class Tree extends Image {
    private static int instanceCounter = 0;
    private int treeId;

    public Tree(String filename) {
        super(filename);
        treeId = instanceCounter++;
    }

    private String readCsv() {
        int lineId = 0;
        String[] stringBuffer;
        try {
            BufferedReader in = new BufferedReader(new FileReader("res/worlds/test.csv"));
            String aLine;
            while ((aLine = in.readLine()) != null) {
                if (lineId != treeId) {
                    lineId++;
                    continue;
                }
                stringBuffer = aLine.split(",");
                if(stringBuffer[0].equals("Tree")) {
                    return aLine;
                }
            }
            System.out.println("ERROR: No more records.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    private double getXCoordinate(String aLine) {
        double xCoordinate;

        if (aLine.equals("ERROR")) {
            System.out.println("Invalid info from file!");
            return 0;
        }
        String[] stringBuffer = aLine.split(",");
        xCoordinate = Double.parseDouble(stringBuffer[1]);
        return xCoordinate;
    }

    private double getYCoordinate(String aLine) {
        double yCoordinate;

        if (aLine.equals("ERROR")) {
            System.out.println("Invalid info from file!");
            return 0;
        }
        String[] stringBuffer = aLine.split(",");
        yCoordinate = Double.parseDouble(stringBuffer[2]);
        return yCoordinate;
    }

    public void setTree() {
        String line = readCsv();
        double x = getXCoordinate(line);
        double y = getYCoordinate(line);
        drawFromTopLeft(x, y);

    }

}
