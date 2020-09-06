import bagel.Image;

public abstract class Actor extends Image {

    public Actor(String filename) {
        super(filename);
    }

    public abstract String readCsv();

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

    public void deploy() {
        String line = readCsv();
        double x = getXCoordinate(line);
        double y = getYCoordinate(line);
        drawFromTopLeft(x, y);
    }

}
