import java.util.Scanner;

public class DrawTriangle {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int triangleSize;
        try{
            triangleSize = input.nextInt();
            if(triangleSize > 0){
                printTriangle(triangleSize);
                return;
            }
            System.out.println("Niewłaściwa wartość argumentu");
        }
        catch (Exception e){
            System.out.println("Niepoprawna długość boku " + e);
        }
    }

    public static void printTriangle(int height){
        int baseSize = height * 2 - 1;
        for(int i = 0; i < height; i++){
            int paddingSize = 4 - (i+1);
            String padding = "";
            for(int a = 0; a < paddingSize; a++){
                padding += " ";
            }

        }
    }
}
