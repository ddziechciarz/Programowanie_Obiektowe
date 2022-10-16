import java.util.Date;
import java.util.Calendar;

public class Weekend2 {

    public static void main(String[] args){
        int curr_day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println(curr_day);
        if( curr_day== 1 || curr_day == 7){
            System.out.println("Jest weekend!");
        }
        else{
            String[]dni = {"Poniedziałek", "Wtorek", "Środa", "Czwartel", "Piątek"};
            if(curr_day == 6){
                System.out.println("Dzisiaj jest Piątek, do weekendu pozostał 1 dzień");
            }
            else{
                System.out.println("Dzisiaj jest " + dni[curr_day-2] + ", do weekednu zostało " + (7 - curr_day) + "dni");
            }


        }
    }
}
