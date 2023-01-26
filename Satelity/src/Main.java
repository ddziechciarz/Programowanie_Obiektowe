import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        SatBeams satBeams = new SatBeams("https://satbeams.com/satellites?status=active");

        //satBeams.SortByPosition();
        //satBeams.SortByName();
        //satBeams.PrintData(10);
        KingOfSat kingOfSat = new KingOfSat("https://en.kingofsat.net/satellites.php");
        //kingOfSat.PrintData(10);

        ArrayList<Satelite> satelitesKing = kingOfSat.getSatelites();
        ArrayList<Satelite> satelitesBeams = satBeams.getSatelites();
        System.out.println(satelitesBeams.get(0));
        //Flysat flysat = new Flysat("https://www.flysat.com/en/satellitelist");
        //flysat.PrintData();

    }
}