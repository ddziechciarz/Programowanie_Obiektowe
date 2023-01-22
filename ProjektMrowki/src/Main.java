
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

enum sortType{
    SPECIES,
    ENDEMIC,
    ALPHABETICALLY
}

public class Main {
    //private static String antUrl = "https://www.antwiki.org/wiki/images/0/0c/AntWiki_Regional_Taxon_List.txt";

    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) throws IOException {

        Configurator.initialize(new DefaultConfiguration());
        Configurator.setRootLevel(Level.DEBUG);

        DataManager dataManager = new DataManager("anp app", 500, 650);
        dataManager.DownloadCountriesWithSpeciesNumber();
        dataManager.AddTable();
        dataManager.ShowUI();

    }
}