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

        int[] id = new int[365];
        try{
            Document doc = Jsoup.connect(url).get();
            Elements table = doc.selectXpath("//*[@id=\"sat_grid\"]");   //#sat_grid.sat_grid
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
                String sateliteNames = cells.get(3).text();
                String norad = cells.get(4).text();
                String sateliteModel = cells.get(6).text();
                String operator = cells.get(7).text();
                String launchDate = cells.get(10).text();
                id[i] = Integer.parseInt(norad);
                arr[i] = Integer.parseInt(norad);
                i++;

                String extraNames = " ";
                if(sateliteNames.indexOf("(") > 0){
                    extraNames = sateliteNames.substring(sateliteNames.indexOf("(") + 1, sateliteNames.indexOf(")"));
                    sateliteNames = sateliteNames.substring(0, sateliteNames.indexOf("("));
                }


                float pos = 0;
                String[] posString = position1.split(" ");
                if(posString[1] == "W"){
                    pos = -Integer.parseInt(posString[0]);
                }
                else{
                    pos = Integer.parseInt(posString[0]);
                }

                Satelite sat = new Satelite(sateliteNames, pos);
                sat.AddOperator(operator);
                sat.AddModel(sateliteModel);
                sat.AddDate(launchDate);
                if(extraNames != " "){
                    sat.AddNames(extraNames);
                }

                satelites.add(sat);
            }
            Arrays.sort(id);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
