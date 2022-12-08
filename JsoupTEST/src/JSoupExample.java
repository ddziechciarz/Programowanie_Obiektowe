import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoupExample {

	private final static Logger log = LogManager.getLogger(JSoupExample.class);
	private final static String address =  "https://www.ssa.gov/oact/babynames/";
	private final static String file =  "names.properties";
	
	
	
	public static void main(String[] args) {
		Configurator.initialize(new DefaultConfiguration());
	    Configurator.setRootLevel(Level.TRACE);

	    URL url = null;;
	    
		try(OutputStream outputStream = new FileOutputStream(file)) {
			url = new URL(address);
			log.info("Trying connect to: " + url);
			Response r = Jsoup.connect(url.toString()).header("Accept-Encoding", "gzip, deflate")
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
					.header("Content-Type", "text/html; charset=ISO-8859-1").referrer("http://www.google.com")
					.ignoreContentType(true).maxBodySize(0).timeout(600000).execute();
			log.info("Successfully connected to " + url);
			log.info("Parsing the content");		
			Document doc = r.parse();
			//<table class="c-table" width="100%"  summary="Top 10 baby names for 2020">
			Elements tmp = doc.select("table[class=c-table]");
			log.trace(tmp);
			log.info("Found "+tmp.size()+" table(s)");
			if (tmp.size()!=1) {
				log.fatal("It must equal 1.");
				System.exit(1);
			}
			tmp=tmp.first().select("td");
			log.trace(tmp);
			log.info("Found "+tmp.size()+" elements");
			if (tmp.size()%3!=0) {
				log.fatal("It must be devided be 3.");
				System.exit(1);				
			}

			ArrayList<String> al = new ArrayList<String>();
			
			for (int i=tmp.size()-1; i>0; i-=2) {
				al.add(tmp.get(i).text());
				al.add(tmp.get(--i).text());
			}
			
			Properties nameProps = new Properties();
			nameProps.setProperty("date", new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date()));
			nameProps.setProperty("names", ""+al.size());
			int i = 1;
			
			System.out.println("Found: "+al.size()+" names.");
			for (String name : al) {
				System.out.println(name);
				nameProps.setProperty("name."+i++, name);
			}
			nameProps.store(outputStream, address);
			
		} 	
		catch (FileNotFoundException e1) {
			log.error("Problems with local file: "+file);
		}
		catch (MalformedURLException e) {
			log.error("Problem with URL: " + url, e);
		}
		catch (UnknownHostException e) {
			log.error("Cannot connect to: "+url);			
		}
		catch (IOException e) {
			log.error("Exception: "+e.getLocalizedMessage(),e);
		}
		
	}
	
}	

	

