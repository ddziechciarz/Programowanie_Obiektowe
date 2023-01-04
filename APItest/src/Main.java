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
            api = new URL("https://catfact.ninja/fact");
        }catch(Exception e){
            System.out.println("Hello world!");
            return;
        }

    }
}