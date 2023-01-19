import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


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

    public void AddOperator(String opName){
        operator = opName;
    }
    public void AddModel(String modName){
        model = modName;
    }
    public void AddNames(String[] extraNames){
        Collections.addAll(name, extraNames);
    }
    public void AddNames(String extraNames){
        String[] names = extraNames.split(",");
        Collections.addAll(name, names);
    }


    public void PrintData(){
        String orbPos = (orbitalPosition<0) ? -orbitalPosition + " W" : orbitalPosition + " E";

        System.out.print("name: " + name.get(0) + " | position: " + orbPos);
        if(operator != null){
            System.out.print(" | operator: " + operator);
        }
        if(model != null){
            System.out.print(" | model: " + model);
        }
        if(name.size() > 1){
            System.out.print(" | extra names : ");
            for (int i = 1; i< name.size(); i++){
                System.out.print(name.get(i) + ", ");
            }
        }


        System.out.println("");

    }


}
