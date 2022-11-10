import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        if(args.length < 2){
            System.out.println("Brak argumentów programu");
            System.out.println("Użycie: java FileCopy <source_file> <target>");
            return;
        }

        File source = new File(args[0]);
        File destination = new File(args[1]);

        boolean isValidURL = checkURL(args[0]);

        // check if source is URL address
        if(!isValidURL){
            // if it itsn't, perform more checks for file
            if(!source.exists()){
                System.out.println("Plik" + source.getName() + " nie istnieje");
            }
            if(source.isDirectory()){
                System.out.println("Plik " + source.getName() + " jest katalogiem");
            }
            if(!source.canRead()){
                System.out.println("Brak dostępu do pliku " + source.getName());
            }
        }
        if(!destination.exists()){
            destination.createNewFile();
        }
        else {
            if (destination.isDirectory()) {
                if (!destination.canWrite()) {
                    System.out.println("Brak wymaganych uprawnień do katalogu " + destination.getName());
                }
                destination = new File(destination.getAbsolutePath() + "/" + source.getName());
            }
            if (destination.exists() && !destination.canWrite()) {
                System.out.println("Nie można nadpisać pliku" + destination.getName());
            }
        }

        try{
            if(isValidURL){
                URL url = new URL(args[0]);
                copyURL(url, destination);
            }
            else{
                copyFile(source, destination);
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkURL(String urlString){
        try{
            new URL(urlString).toURI();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    private static void copyFile(File src, File dst) throws IOException{
        FileChannel input = null;
        FileChannel output = null;
        try{
            input = new FileInputStream(src).getChannel();
            output = new FileOutputStream(dst).getChannel();
            output.transferFrom(input, 0, input.size());

            /*int c;
            while((c=input.read()) != -1){
                output.write(c);
            }*/
        }
        finally {
            input.close();
            output.close();
        }
    }

    private static void copyURL(URL url, File dst) throws IOException{

        String inputLine;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            FileWriter fwriter = new FileWriter(dst);
            while((inputLine = in.readLine()) != null){
                fwriter.write(inputLine);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
