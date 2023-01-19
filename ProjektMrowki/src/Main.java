import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.io.File;
import java.util.ArrayList;

enum sortType{
    SPECIES,
    ENDEMIC,
    ALPHABETICALLY
}

public class Main {
    //private static String antUrl = "https://www.antwiki.org/wiki/images/0/0c/AntWiki_Regional_Taxon_List.txt";

    //region UIVariables
    private JFrame jFrame;
    private JPanel options;
    private JPanel utilsPanel;
    private JPanel dataPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames = {"Country", "Species Count", "Endemic species count"};


    //endregion

    public static void main(String[] args) throws IOException {
        //DataManager dataManager = new DataManager();
        //dataManager.DownloadCountriesWithSpeciesNumber();
        

        //UIManager uiManager = new UIManager("ant app", 500, 600);
        //uiManager.AddTable(dataManager.GetData());
        //uiManager.ShowUI();

        DataManager dataManager = new DataManager("anp app", 500, 600);
        dataManager.DownloadCountriesWithSpeciesNumber();
        dataManager.SortData(sortType.ENDEMIC);

        UIManager uiManager = new UIManager("ant app", 500, 600);
        uiManager.AddTable(dataManager.GetData());
        uiManager.ShowUI();
    }

    private void DownloadAntTxt(){
        File f = new File("mrowki.txt");
        if(f.exists() && !f.isDirectory()) {
            // do something
        }
        else{
            try {
                downloadUsingStream(antUrl, "mrowki.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}