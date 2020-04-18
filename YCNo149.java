import java.util.HashMap;
import java.util.Scanner;

public class YCNo149 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            HashMap<String, Integer> bagA = new HashMap<>();
            HashMap<String, Integer> bagB = new HashMap<>();

            int whiteOfA;
            do{
                whiteOfA = Integer.parseInt(scan.next());
            }while(isNotAllowableNumberOfStone(whiteOfA));
            bagA.put("white", whiteOfA);
            
            int blackOfA;
            do{
                blackOfA = Integer.parseInt(scan.next());
            }while(isNotAllowableNumberOfStone(blackOfA));
            bagA.put("black", blackOfA);

            int whiteOfB;
            do{
                whiteOfB = Integer.parseInt(scan.next());
            }while(isNotAllowableNumberOfStone(whiteOfB));
            bagB.put("white", whiteOfB);

            int blackOfB;
            do{
                blackOfB = Integer.parseInt(scan.next());
            }while(isNotAllowableNumberOfStone(blackOfB));
            bagB.put("black", blackOfB);

            int moveToBagB;
            do{
                moveToBagB = Integer.parseInt(scan.next());
            }while(isNotAllowableMovingNumberToBagB(moveToBagB));
            
            int moveToBagA;
            do{
                moveToBagA = Integer.parseInt(scan.next());
            }while(isNotAllowableMovingNumberToBagA(moveToBagA));

            if(bagA.get("black") < moveToBagB){
                bagB.put("white", bagB.get("white").intValue() + moveToBagB - bagA.get("black"));
                bagA.put("white", bagA.get("white").intValue() - (bagB.get("white") - whiteOfB));
            }
            if(bagB.get("white") < moveToBagA){
                bagA.put("white", bagA.get("white").intValue() + bagB.get("white"));
            }else{
                bagA.put("white", bagA.get("white").intValue() + moveToBagA);
            }
            System.out.println(bagA.get("white"));
        }
    }
    /**
     * 碁石の数が指定範囲外か判定する
     * @param numberOfStone 碁石の数
     * @return 判定結果
     */
    private static boolean isNotAllowableNumberOfStone(int numberOfStone){
        if(numberOfStone < 0 || numberOfStone > 100000)
            return true;
        return false;
    }
    /**
     * 袋Bに移動する碁石の数が指定範囲外か判定する
     * @param moveToBagB 袋Bに移動する碁石の数
     * @return 判定結果
     */
    private static boolean isNotAllowableMovingNumberToBagB(int moveToBagB){
        if(moveToBagB < 0 || moveToBagB > 200000)
            return true;
        return false;
    }
    /**
     * 袋Aに移動する碁石の数が指定範囲外か判定する
     * @param moveToBagA 袋Aに移動する碁石の数
     * @return 判定結果
     */
    private static boolean isNotAllowableMovingNumberToBagA(int moveToBagA){
        if(moveToBagA < 0 || moveToBagA > 400000)
            return true;
        return false;
    }
}