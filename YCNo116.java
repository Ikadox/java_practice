import java.util.Scanner;

public class YCNo116 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int bambooNumber;
            do{
                bambooNumber = Integer.parseInt(scan.nextLine());
            }while(isNotBambooNumberRange(bambooNumber));
            int[] heightArray;
            do{
                String[] inputHeightArray = scan.nextLine().split(" ");
                heightArray = new int[inputHeightArray.length];
                for(int i = 0; i < inputHeightArray.length; i++){
                    heightArray[i] = Integer.parseInt(inputHeightArray[i]);
                }
            }while(isNotHeightRange(heightArray));
            System.out.println(calcKadomatsuPattern(heightArray));
        }
    }
    /**
     * 竹の数が指定の範囲外か判定する
     * @param bambooNumber
     * @return
     */
    private static boolean isNotBambooNumberRange(int bambooNumber){
        if(bambooNumber < 3 || bambooNumber > 100)
            return true;
        return false;
    }
    /**
     * 高さが指定の範囲外か判定する
     * @param heightArray
     * @return
     */
    private static boolean isNotHeightRange(int[] heightArray){
        for(int i : heightArray){
            if( i < 1 || i > 100)
                return true;
        }
        return false;
    }
    /**
     * 左右の高さが異なるかを判定する
     * 異なる場合、真ん中の竹が一番高いか小さいかを判定し、左右の高さが2番目かどうか判別する
     * @param leftSide
     * @param center
     * @param rightSide
     * @return
     */
    private static boolean isKadomatsuStyle(int leftSide, int center, int rightSide){
        if(leftSide != rightSide){
            if(center > leftSide && center > rightSide)
                return true;
            if(center < leftSide && center < rightSide)
                return true;
        }
        return false;
    }
    /**
     * 門松列になる組み合わせ数を算出
     * @param heightArray
     * @return
     */
    private static int calcKadomatsuPattern(int[] heightArray){
        int kadomatsuPattern = 0;
        for(int i = 0; i < heightArray.length-2; i++){
            if(isKadomatsuStyle(heightArray[i], heightArray[i+1], heightArray[i+2]))
                kadomatsuPattern++;
        }
        return kadomatsuPattern;
    }
}