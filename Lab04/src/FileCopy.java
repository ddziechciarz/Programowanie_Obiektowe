import java.io.*;
import java.nio.file.Paths;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        if(args.length < 2){
            System.out.println("Brak argumentów programu");
            System.out.println("Użycie: java FileCopy <source_file> <target>");
        }

        File source = new File(args[0]);
        File destination = new File(args[1]);

        if(!source.exists()){
            System.out.println("Plik" + source.getName() + " nie istnieje");
        }
        if(source.isDirectory()){
            System.out.println("Plik " + source.getName() + " jest katalogiem");
        }
        if(!source.canRead()){
            System.out.println("Brak dostępu do pliku " + source.getName());
        }
        if(destination.isDirectory()){
            if(!destination.canWrite()){
                System.out.println("Brak wymaganych uprawnień do katalogu " + destination.getName());
            }
            String filename = source.getName();
            //String filename = String.valueOf(Paths.get(source.getName()).getFileName());
            destination = new File(destination.getName() + "/" + filename);
        }
        if(destination.exists() && !destination.canWrite()){
            System.out.println("Nie można nadpisać pliku" + destination.getName());
        }
        try{
            copyFile(source, destination);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void copyFile(File src, File dst) throws IOException{
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream(src);
            output = new FileOutputStream(dst);

            byte[] buffer = new byte[2048];

            int bytesReacCount;
            while((bytesReacCount = input.read(buffer)) > 0){
                output.write(buffer, 0, bytesReacCount);
            }

        }
        finally {
            input.close();
            output.close();
        }
    }
}
