import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gatherer extends Actor {
    private static int instanceCounter = 0;
    private int instanceId;

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

}
