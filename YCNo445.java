import java.util.Scanner;

public class YCNo445 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            System.out.println(
                pointCalc(
                        Double.parseDouble(scan.next())
                    ,   Double.parseDouble(scan.next())
                )
            );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static long pointCalc(double n, double k){
        return 50 * Math.round(n) + Math.round(Math.floor((50 * n)/(0.8+0.2*k)));
    }
}