import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Satelite {

    public final static float NULL = 255;

    private ArrayList<String> name;
    private float orbitalPosition;

    private String operator;
    private float satelitePosition;
    private String model;
    private String launchDate;

    private Satelite(){
        satelitePosition = NULL;
    }

    public Satelite(String satName, float oribtalPos) throws IOException {
        this();
        name = new ArrayList<String>();
        name.add(satName);
        orbitalPosition = oribtalPos;
    }


}