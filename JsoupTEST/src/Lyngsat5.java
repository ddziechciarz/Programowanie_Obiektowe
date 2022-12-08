package tomek.it.itjp.jsoup;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
	https://jsoup.org/download
	jsoup-1.13.1.jar core library
	jsoup-1.13.1-sources.jar optional sources jar
	jsoup-1.13.1-javadoc.jar optional javadoc jar
*/


public class Lyngsat5 {

	private final static String url = "https://www.lyngsat.com";

	public static void main(String[] args) throws IOException {
        
        // Parse the web page
        Document doc = Jsoup.connect(url).get();
        
/*

<td><font face="Arial" size=2><b>Satellites:</b></td>
<td align="center"><font face="Arial" size=2><b><a href="asia.html">Asia</a></b></td>
<td align="center"><font face="Arial" size=2><b><a href="europe.html">Europe</a></b></td>
<td align="center"><font face="Arial" size=2><b><a href="atlantic.html">Atlantic</a></b></td>
<td align="center"><font face="Arial" size=2><b><a href="america.html">America</a></b></td>

*/
        
        // Choose TAG: TABLE where width=468 and border=1

        Elements media = doc.select("table[width=468][border=1]");
        
        System.out.println("1. TABLES: "+media.size());
        
        System.out.println("2. Select TR attribute.");
        Elements tmp = media.first().select("TR");
        for (Element el: tmp) {
        	// System.out.println(el.children().first().text());      
            if (el.children().first().text().strip().toLowerCase().contains("satellites")) {
        		tmp=el.select("font");
                tmp.remove(0);
        		break;
        	}
        }

        tmp = tmp.select("A");
        
        URL[] alURL = new  URL[tmp.size()];
        String[] alString = new  String[tmp.size()];
        
        for (int i=0; i<tmp.size(); i++) {       	
            System.out.println(tmp.get(i));
            alURL[i]=new URL(tmp.get(i).absUrl("href"));
            alString[i]=tmp.get(i).text();
        }
        
        for (int i=0; i<tmp.size(); i++) {       
        	System.out.println(alString[i]+": "+alURL[i]);
        }        
    }

}


