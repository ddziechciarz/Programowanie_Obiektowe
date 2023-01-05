import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {


        URL api = null;
        try{
            api = new URL("https://www.antwiki.org/wiki/images/0/0c/AntWiki_Regional_Taxon_List.txt");
        }catch(Exception e){
            System.out.println("Hello world!");
            return;
        }
        InputStream input = null;
        try{
            input = api.openConnection().getInputStream();
        }
        catch(Exception e){
            return;
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line = null;

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception e){
            return;
        }

    }
}