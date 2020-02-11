import java.util.Scanner;

public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello World!");
        tryWithResourceScanner();
    }

    public static void tryWithResourceScanner(){
        //try-with-resource構文によって、tryブロック終了時(finally時)に暗黙的にリソースをcloseする
        try(Scanner scan = new Scanner(System.in)){
            boolean flag = true;
            System.out.println("If you wanna finish input, type word \"end\"");
            while(flag){
                System.out.print(">");
                String line = scan.nextLine();
                System.out.print("\n");
                if(line.equals("end")){
                    System.out.println("input end");
                    flag = false;
                }
            }
        }
    }
}