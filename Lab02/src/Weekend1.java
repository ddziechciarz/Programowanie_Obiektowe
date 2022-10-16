import java.util.Date;

public class Weekend1 {

    public static void main(String[] args){
        Date date = new Date();
        int curr_date = date.getDay();
        if(curr_date == 0 || curr_date == 6){
            System.out.println("Jest weekend!");
        }
        else{
            switch (curr_date){
                case 1:
                    System.out.println("Jest Poniedizałek");
                    break;
                case 2:
                    System.out.println("Jest Wtorek");
                    break;
                case 3:
                    System.out.println("Jest Środa");
                    break;
                case 4:
                    System.out.println("Jest Czwartek");
                    break;
                case 5:
                    System.out.println("Jest Piątek");
                    break;
            }



        }
    }
}
