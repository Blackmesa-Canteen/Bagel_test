import bagel.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Actor extends Image {

    protected int instanceId;

    public Actor(String filename) {
        super(filename);
    }

    /**
     * read the World file.
     * @return     A String containing one name-matched line.
     */
    public String readCsv(String objName) {
        int recordId = 0; // IDs of instance-name-matched records
        String[] stringBuffer; // store a line of record
        try {
            BufferedReader in = new BufferedReader(new FileReader("res/worlds/test.csv"));
            String aLine;
            while ((aLine = in.readLine()) != null) {

                stringBuffer = aLine.split(",");
                if(stringBuffer[0].equals(objName)) {
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

    public double getXCoordinate(String aLine) {
        double xCoordinate;

        if (aLine.equals("ERROR")) {
            System.out.println("Invalid info from file!");
            return 0;
        }
        String[] stringBuffer = aLine.split(",");
        xCoordinate = Double.parseDouble(stringBuffer[1]);
        return xCoordinate;
    }

    public double getYCoordinate(String aLine) {
        double yCoordinate;

        if (aLine.equals("ERROR")) {
            System.out.println("Invalid info from file!");
            return 0;
        }
        String[] stringBuffer = aLine.split(",");
        yCoordinate = Double.parseDouble(stringBuffer[2]);
        return yCoordinate;
    }

    public abstract void deploy();

}
