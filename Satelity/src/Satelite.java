import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Satelite implements Comparator<Satelite> {

    public final static float NULL = 255;

    private ArrayList<String> name;

    // not always given
    private float clusterPosition;
    private String operator;

    // always given
    private float satelitePosition;
    private String model;
    private String launchDate;


    private Satelite(){
        clusterPosition = NULL;
    }
    public Satelite(String satName, float satPos) throws IOException {
        this();
        name = new ArrayList<String>();
        name.add(satName);
        satelitePosition = satPos;
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
    public void AddDate(String date){
        launchDate = date;
    }
    public void AddClusterPosition(float clusterPos){
        clusterPosition = clusterPos;
    }

    public float GetPosiiton(){
        return satelitePosition;
    }

    public String getName(){
        return name.get(0);
    }

    public void PrintData(){
        String satPos = (satelitePosition <0) ? -satelitePosition + " W" : satelitePosition + " E";
        //System.out.println(satelitePosition);
        //System.out.println(satPos);

        System.out.print("name: " + name.get(0) + " | position: " + satPos);
        if(clusterPosition != NULL){
            String clusterPos = (clusterPosition <0) ? -clusterPosition + " W" : clusterPosition + " E";
            System.out.print(" | cluster position: " + clusterPos);
        }
        if(operator != null){
            System.out.print(" | operator: " + operator);
        }
        if(model != null){
            System.out.print(" | model: " + model);
        }
        if(launchDate != null){
            System.out.print(" | launch date: " + launchDate);
        }
        if(name.size() > 1){
            System.out.print(" | extra names : ");
            for (int i = 1; i< name.size(); i++){
                System.out.print(name.get(i) + ", ");
            }
        }
        System.out.println("");
    }

    @Override
    public int compare(Satelite o1, Satelite o2) {
        return 0;
    }

    //@Override
    //public boolean eq

}
