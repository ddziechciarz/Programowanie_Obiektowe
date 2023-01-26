import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Flysat extends WebPage {


    public Flysat(String url) {
        super(url);
    }

    //For parsing W/E endings
    private static float parsePosition(String position) {
        Float posNumber = Float.parseFloat(position.substring(0,position.length()-3));
        String director = position.substring(position.length()-1);
        if(director.equals(new String("W"))){
            posNumber=posNumber*(-1);
        }
        return posNumber;
    }

    @Override
    public void DownloadPage() {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();

            //precise matcher for rows containing satellite data
            Elements sats = document.select("tr:has(> td > font > a)");
            for (Element sat : sats) {
                Elements fields = sat.select("a");
                String satName = fields.eq(0).text();
                String satPos = fields.eq(1).text();

                float pos = 0;
                String[] posString = satPos.split("°");
                if (posString.length == 1) {
                    pos = 180;
                } else {
                    if (posString[1].contains("W")) {
                        pos = -Float.parseFloat(posString[0]);
                    } else {
                        pos = Float.parseFloat(posString[0]);
                    }
                }
                Satelite satelite = new Satelite(satName, pos);
                satelites.add(satelite);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        }
    }

