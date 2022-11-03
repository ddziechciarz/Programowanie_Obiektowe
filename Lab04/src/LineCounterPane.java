import javax.sound.sampled.Line;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class LineCounterPane {
    JFrame f;
    String response;
    LineCounterPane(){
        f=new JFrame();
        response=JOptionPane.showInputDialog(f,"Enter Name");
    }

    int countLines(){
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(response));
            String s;
            int lineCount = 0;
            while((s=reader.readLine())!=null){
                lineCount +=1;
            }
            return lineCount;
        }
        catch (Exception e){
            System.out.println("something went wrong");
        }
        return -1;
    }

    public static void main(String[] args) {
        LineCounterPane window = new LineCounterPane();
        System.out.println(window.countLines());
    }
}
