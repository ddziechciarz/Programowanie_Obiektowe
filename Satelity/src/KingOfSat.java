//package SatTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KingOfSat extends WebPage {
	
	public KingOfSat(String url) {
		super(url);
	}
	
	@Override
	public void DownloadPage() {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements media = doc.select("div[id='cbfreq']").select("tbody").select("tr");

	    	String component = "";
	    	
	    	for(Element el: media) {
	    		Elements tmp = el.select("td");
	    		String orbPos = tmp.get(0).text();
	    		String name = tmp.get(1).select("a").get(0).text();
	    		String satPos = tmp.get(7).text();
	    	    Float orbPosition;
	    	    Float satPosition;
	    		
	    		if(orbPos.split("°")[1].equals("E")) {
	    			orbPosition = Float.parseFloat(orbPos.split("°")[0]);
	    		}
	    		else {
	    			orbPosition = -Float.parseFloat(orbPos.split("°")[0]);
	    		}
	    		
	    		if(satPos.split("°")[1].equals("E")) {
	    			satPosition = Float.parseFloat(satPos.split("°")[0]);
	    		}
	    		else {
	    			satPosition = -Float.parseFloat(satPos.split("°")[0]);
	    		}
	    		
	    	    Satelite satelite = new Satelite(name, satPosition);
				satelite.AddClusterPosition(orbPosition);
	    	    satelites.add(satelite);
	    		
	    	}	    	
		}
		catch(HttpStatusException hse) {
			System.exit(1);
		}
		catch(UnknownHostException uhe) {
			System.exit(1);
		}
		catch(IOException io) {
			System.exit(1);
		}
	}
	

}
