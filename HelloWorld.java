import java.util.Scanner;

public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello World!");

        String[] array = new String[2];
        Scanner scan  = new Scanner(System.in);
        for(int i=0; i<2; i++){
            array = scan.nextLine().split(",");
            System.out.print((i+1)+" : ");
            for(String n: array){
                System.out.print(n);
            }
            System.out.print("\n");
        }
        scan.close();
    }
}