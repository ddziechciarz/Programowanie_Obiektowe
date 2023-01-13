import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.io.File;

public class Main {
    private static String antUrl = "https://www.antwiki.org/wiki/images/0/0c/AntWiki_Regional_Taxon_List.txt";


    public static void main(String[] args) throws IOException {
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


    }

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