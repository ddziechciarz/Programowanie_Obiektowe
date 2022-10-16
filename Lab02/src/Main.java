import java.util.Date;

public class Main {
    public static void main(String[] args)
    {

        Date date = new Date();
        int curr_day = date.getDay();
        if(curr_day == 0 || curr_day == 6) {
            System.out.println("Już jest weekend");
        }
        else{
            System.out.println("Do weekendu pozostało : " + (6-curr_day) + " dni");
        }

    }


}