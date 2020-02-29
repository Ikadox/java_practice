import java.util.Scanner;

public class YCNo47 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            long numberOfBiscuit;
            do{
                numberOfBiscuit = Long.parseLong(scan.nextLine());
            }while(isNotNumberOfBiscuitRange(numberOfBiscuit));
            System.out.println(calcClapNumber(numberOfBiscuit));
        }
    }
    /**
     * ビスケットの枚数が指定範囲外か判定する
     * @param number
     * @return
     */
    private static boolean isNotNumberOfBiscuitRange(long number){
        if(number < 1 || number > Math.pow(10,8) )
            return true;
        return false;
    }
    /**
     * ポケットを叩いた回数を算出する
     * @param numberOfBiscuit
     * @return
     */
    private static long calcClapNumber(long numberOfBiscuit){
        long clapNumber = 0;
        while(Math.pow(2,clapNumber) < numberOfBiscuit)
            clapNumber++;
        return clapNumber;
    }
}