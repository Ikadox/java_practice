import java.util.InputMismatchException;
import java.util.Scanner;

public class YCNo1168 {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            int number;
            do{
                number = Integer.parseInt(scan.next());
            }while(isUnavailabledNumber(number));
            for(int i = 2; i <= 100; i++){
                number = sumDigitNumber(number);
            }
            System.out.println(number);
        }catch(InputMismatchException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 入力された数値が範囲外か判定する
     * @param number 入力された数字
     * @return 範囲外ならtrueを返し、範囲内ならfalseを返す
     */
    private static boolean isUnavailabledNumber(int number){
        if(number < 1 || number > 1000000000){
            return true;
        }
        return false;
    }

    private static int sumDigitNumber(int number){
        int numberOfDigit = 0;
        int sum = 0;
        for(int digitInMultiplesOfTen = determineDigit(number);digitInMultiplesOfTen>0;digitInMultiplesOfTen/=10){
            numberOfDigit = number/digitInMultiplesOfTen;
            sum += numberOfDigit;
            number -= numberOfDigit * digitInMultiplesOfTen;
        }
        return sum;
    }
    private static int determineDigit(int number){
        int MAX_DIVIDE_NUMBER = 100000000;
        int maxDigitInMultiplesOfTen = MAX_DIVIDE_NUMBER;
        while(number/maxDigitInMultiplesOfTen == 0){
            maxDigitInMultiplesOfTen/=10;
        }
        return maxDigitInMultiplesOfTen;
    }
}
