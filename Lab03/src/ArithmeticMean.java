public class ArithmeticMean {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Brak argumentów programu");
            return;
        }

        float sum = Integer.parseInt(args[0]);
        String args_decoded = args[0];

        for(int i = 1; i < args.length; i++){
            args_decoded = args_decoded + "," + args[i];
            int value = Integer.parseInt(args[i]);
            sum += value;
        }

        System.out.print("Średnia arytmetyczna liczb " + args_decoded + " to: " +  (int)Math.floor(sum/args.length));
        if(sum%args.length != 0){
            System.out.println(" a reszta to: " + (int)(sum % args.length));
        }


    }
}
