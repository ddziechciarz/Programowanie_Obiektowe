public class CommandLineArguments {

    public static void main(String[] args){
        int arg_count = args.length;
        System.out.println("Liczba argumentów: " + arg_count);
        for(int i = 0; i <= arg_count; i++){
            System.out.println((i+1) + ". " + args[i]);
        }

    }
}
