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
        try{
            reader = new BufferedReader(new FileReader(args[0]));
        }catch (Exception e){
            return;
        }

        String s;
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        while((s=reader.readLine())!=null){
            lineCount +=1;
            charCount += s.length();
            String words[] = s.split("\\s");
            wordCount += words.length;
        }
        String toPrint = "";
        boolean words = checkArg(args, "w");
        boolean chars = checkArg(args, "c");
        boolean lines = checkArg(args, "l");
        boolean printAll = !words && !chars && !lines;
        //System.out.println(" " + w + c + l + printAll);
        if(words || printAll){
            System.out.println("słów: " + wordCount);
        }
        if(chars || printAll){
            System.out.println("znaków: " + charCount);
        }
        if(lines || printAll){
            System.out.println("lini: " + lineCount);
        }

}
    private static boolean checkArg(String[] args, String argToCheck) {
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                continue;
            }
            if (arg.contains(argToCheck)) {
                return true;
            }
        }
        return false;
    }
}
