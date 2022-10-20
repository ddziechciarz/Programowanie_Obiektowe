public class FloatArithmeticMean {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Brak argumentów programu");
        }
        else{
            float sum = 0;
            int longest_arg = 0;
            float[] values = new float[args.length];

            for(int i = 0; i < args.length; i++) {
                if (args[i].length() > longest_arg) {
                    longest_arg = args[i].length();
                }
                float value = Float.parseFloat(args[i]);
                values[i] = value;
                sum += value;
            }

            if((Math.round(sum)+4) > longest_arg){
                longest_arg = (Integer.toString(Math.round(sum))).length() +4;
            }

            String format = "%" + longest_arg + ".3f%n";

            for(Float i:values){
                System.out.printf(format, i);
            }
            System.out.println("-".repeat(longest_arg+1));
            System.out.printf(format, sum);
            //String output = Float.toString(sum/args.length);
            System.out.printf("Srednia arytmetyczna to: %.4f", sum/args.length);
        }
    }
}
