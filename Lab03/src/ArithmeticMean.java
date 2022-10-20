public class ArithmeticMean {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Brak argumentów programu");
        }
        else{
            float sum = 0;
            String args_decoded = "";
            for(String i:args){
                args_decoded = args_decoded + i + " ";
                int value = Integer.parseInt(i);
                sum += value;
            }
            System.out.println("Średnia arytmetyczna liczb " + args_decoded + "to " + sum/args.length);
        }

    }
}
