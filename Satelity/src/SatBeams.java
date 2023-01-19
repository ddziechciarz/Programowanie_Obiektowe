import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class SatBeams extends WebPage {
    public SatBeams(String url){
        super(url);
    }
    @Override
    public void DownloadPage() {
        //pobiera dane i tworzy nowe satelity

        int[] id = new int[365];
        String url = "https://satbeams.com/satellites?status=active";
        try{
            Document doc = Jsoup.connect(url).get();
            Elements table = doc.selectXpath("//*[@id=\"sat_grid\"]");   //#sat_grid.sat_grid
            //System.out.println(table);
            int d = 0;
            String filename = "Satelites.csv";
            File file = new File(filename);
            PrintWriter writer = new PrintWriter(file);
            int[] arr = new int[400];
            int i = 0;
            for (Element row : table.select("tr")) {
                Elements cells = row.select("td");
                if (cells.size() == 0) {
                    continue;
                }
                String position = cells.get(0).text();
                String position1 = cells.get(1).text();
                String status = cells.get(2).text();
                String sateliteName = cells.get(3).text();
                String norad = cells.get(4).text();
                String sateliteModel = cells.get(6).text();
                String operator = cells.get(7).text();
                String launchDate = cells.get(10).text();
                id[i] = Integer.parseInt(norad);
                arr[i] = Integer.parseInt(norad);
                i++;

                float pos = 0;
                String[] posString = position1.split(" ");
                if(posString[1] == "W"){
                    pos = -Integer.parseInt(posString[0]);
                }
                else{
                    pos = Integer.parseInt(posString[0]);
                }
                System.out.println(pos);
                //System.out.println(position + " " + position1 + " " + status + " " + sateliteName + " " + norad + " " + sateliteModel + " " + launchDate);
                //String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", position, position1, status, sateliteName, norad, sateliteModel, operator, launchDate);
                //writer.println(line);
                Satelite sat = new Satelite(sateliteName, pos);
                satelites.add(sat);
                //sat.PrintData();
                d++;
            }
            Arrays.sort(id);
            writer.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
