import java.text.SimpleDateFormat;
import java.util.Date;

public class Hello {
    public static void main(String[] args) {
        Date curr_date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");

        System.out.println("Witaj! Teraz jest: " + dateFormat.format(curr_date));
    }
}
