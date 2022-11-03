import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Brak argumentów!");
            return;
        }
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("File.txt"));
        String s;
        int lineCount = 0;
        while((s=reader.readLine())!=null){
            lineCount +=1;
        }
        System.out.println(lineCount);


}}
