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
        reader = new BufferedReader(new FileReader(args[0]));
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
        boolean w = checkArg(args, "w");
        boolean c = checkArg(args, "c");
        boolean l = checkArg(args, "l");
        boolean printAll = !w && !c && !l;
        //System.out.println(" " + w + c + l + printAll);
        if(w || printAll){
            System.out.println("wierszy: " + wordCount);
        }
        if(c || printAll){
            System.out.println("znaków: " + charCount);
        }
        if(l || printAll){
            System.out.println("słów: " + lineCount);
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
