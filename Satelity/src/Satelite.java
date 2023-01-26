import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Satelite implements Comparator<Satelite>, Comparable<Satelite> {

    public final static float NULL = 255;
    public static final int NAME = 17;
    public static final int POSITION = 60;

    private ArrayList<String> name;

    // not always given
    private float clusterPosition;
    private String operator;

    // always given
    private float satelitePosition;
    private String model;
    private String launchDate;
    private static int sortOption = NAME;


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

    //public void setSortOption(){
  //
    //}

    @Override
    public String toString(){
        String toPrint ="";
        String satPos = (satelitePosition <0) ? -satelitePosition + " W" : satelitePosition + " E";
        //System.out.println(satelitePosition);
        //System.out.println(satPos);

        toPrint += "name: " + name.get(0) + " | position: " + satPos;
        if(clusterPosition != NULL){
            String clusterPos = (clusterPosition <0) ? -clusterPosition + " W" : clusterPosition + " E";
            toPrint += " | cluster position: " + clusterPos;
        }
        if(operator != null){
            toPrint += " | operator: " + operator;
        }
        if(model != null){
            toPrint += " | model: " + model;
        }
        if(launchDate != null){
           toPrint += " | launch date: " + launchDate;
        }
        if(name.size() > 1){
            toPrint += " | extra names : ";
            for (int i = 1; i< name.size(); i++){
                toPrint += (name.get(i) + ", ");
            }
        }
        return toPrint;
    }


    @Override
    public int compare(Satelite o1, Satelite o2) {
        switch (sortOption){
            case NAME :
                return o1.getName().compareToIgnoreCase(o2.getName());
        }
        return 0;
    }

    @Override
    public int compareTo(Satelite o) {
        if(o == null){
            return -1;
        }
        return this.getName().compareToIgnoreCase(o.getName());
    }

    public void setSortOption(int option) {
        sortOption = switch(option){
            case NAME, POSITION:
                yield option;
            default:
                throw new IllegalArgumentException("unknown option: " + option);
        };
    }



    //@Override
    //public boolean eq

}
