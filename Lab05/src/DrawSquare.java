import java.util.Scanner;

public class DrawSquare {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int edgeSize;
        System.out.println("Podaj długość boku");
        try{
            edgeSize = input.nextInt();
            if(edgeSize > 0){
                printSquare(edgeSize);
                return;
            }
            System.out.println("Niewłaściwa wartość argumentu");
        }
        catch (Exception e){
            System.out.println("Niepoprawna długość boku " + e);
        }
    }

    public static void printSquare(int edgeSize){
        String horizontalEdge = "";
        for(int i = 0; i <edgeSize; i++){
            horizontalEdge += "#";
        }
        String verticalEdge = "#";
        for(int i = 1; i < edgeSize-1; i++){
            verticalEdge += " ";
        }
        verticalEdge += "#";

        System.out.println(horizontalEdge);
        for(int i = 1; i < edgeSize -1; i++){
            System.out.println(verticalEdge);
        }
        System.out.println(horizontalEdge);
    }
}
