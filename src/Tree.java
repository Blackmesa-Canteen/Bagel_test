import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tree extends Actor {
    private static int instanceCounter = 0;
    private int instanceId;

    public Tree() {
        super("res/images/tree.png");
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
                if(stringBuffer[0].equals("Tree")) {
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
