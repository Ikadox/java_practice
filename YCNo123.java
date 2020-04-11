import java.util.Scanner;
import java.util.stream.IntStream;

public class YCNo123 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int maxNumber;
            do{
                maxNumber = Integer.parseInt(scan.next());
            }while(isNotAllowableCardMaxNumberRnage(maxNumber));

            int[] stackArray = new int[maxNumber];
            stackArray = IntStream.range(1, maxNumber+1).toArray();

            int shuffle;
            do{
                shuffle = Integer.parseInt(scan.next());
            }while(isNotAllowableShuffleRange(shuffle));

            int movingPosition, getCardNumber;
            for(;shuffle > 0;shuffle--){
                do{
                    movingPosition = Integer.parseInt(scan.next());
                }while(isNotAllowableMovingPositionRange(movingPosition, maxNumber));
                getCardNumber = stackArray[movingPosition-1];
                for(int i = 1, j = i + 1; i < movingPosition; i++, j++){
                    stackArray[movingPosition - i] = stackArray[movingPosition - j];
                }
                stackArray[0] = getCardNumber;
            }
            System.out.println(stackArray[0]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * カードに書かれた最大の数字が指定範囲外か判定する
     * @param maxNumber カードに書かれた最大の数字
     * @return 判定結果
     */
    private static boolean isNotAllowableCardMaxNumberRnage(int maxNumber){
        if(maxNumber < 1 || maxNumber > 50)
            return true;
        return false;
    }
    /**
     * カードをシャッフルする回数が指定範囲外か判定する
     * @param shuffle シャッフルする回数
     * @return 判定結果
     */
    private static boolean isNotAllowableShuffleRange(int shuffle){
        if(shuffle < 1 || shuffle > 100000)
            return true;
        return false;
    }
    /**
     * カードを引く位置（上から数えた位置）がカードの枚数を超過していないか判定する
     * カードの枚数は、カードに書かれた最大の数字に一致するため、引数にカードに書かれた最大の数字を使用する
     * @param movingPosition カードを引く位置（上から数えた位置）
     * @param maxNumber カードに書かれた最大の数字
     * @return
     */
    private static boolean isNotAllowableMovingPositionRange(int movingPosition, int maxNumber){
        if(movingPosition < 1 || movingPosition > maxNumber)
            return true;
        return false;
    }
}