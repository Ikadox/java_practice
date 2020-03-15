import java.util.Arrays;
import java.util.Scanner;

public class YCNo5{
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int boxWidth;
            do{
                boxWidth = Integer.parseInt(scan.nextLine());
            }while(isNotBoxWidthRange(boxWidth));

            int numberOfBlocks;
            do{
                numberOfBlocks = Integer.parseInt(scan.nextLine());
            }while(isNotNumberOfBlockRange(numberOfBlocks));

            int[] widthOfBlocks;
            do{
                widthOfBlocks = parseIntArray(scan.nextLine().split(" "));
            }while(isNotBlocksWidthRange(widthOfBlocks, boxWidth));
            Arrays.sort(widthOfBlocks);
            System.out.println(calcBlocksInTheBox(widthOfBlocks, boxWidth, numberOfBlocks, 0, 0));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 箱の中に何個のブロックが入るか算出する
     * @param widthOfBlocks 各ブロックの幅が入った配列
     * @param boxWidth 箱の幅
     * @param numberOfBlocks ブロックの数
     * @param inBoxBlocks 箱の中に入ったブロックの数
     * @param sumWidthBlocks 箱の中に入れようとしているブロックの合計幅
     * @return
     */
    private static int calcBlocksInTheBox(int[] widthOfBlocks, int boxWidth, int numberOfBlocks, int inBoxBlocks, int sumWidthBlocks){
        if(inBoxBlocks < numberOfBlocks){
            sumWidthBlocks += widthOfBlocks[inBoxBlocks];
            if(sumWidthBlocks <= boxWidth){
                inBoxBlocks++;
                inBoxBlocks = calcBlocksInTheBox(widthOfBlocks, boxWidth, numberOfBlocks, inBoxBlocks, sumWidthBlocks);
            }
        }
        return inBoxBlocks;
    }
    /**
     * String配列をint型配列に変換する
     * int型に変換できない要素があった場合、 NumberFormatException を throw する
     * @param stringArray String型配列
     * @return int型配列
     * @throws NumberFormatException
     */
    public static int[] parseIntArray(String[] stringArray)throws NumberFormatException{
        int[] intArray = new int[stringArray.length];
        for(int i = 0; i< stringArray.length; i++){
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }
    /**
     * 箱の幅が指定範囲外か判定する
     * @param width 箱の幅
     * @return
     */
    public static boolean isNotBoxWidthRange(int width){
        if(width < 1 || width > 10000)
            return true;
        return false;
    }
    /**
     * ブロックの数が指定範囲外か判定する
     * @param number ブロックの数
     * @return
     */
    public static boolean isNotNumberOfBlockRange(int number){
        if(number < 1 || number > 10000)
            return true;
        return false;
    }
    /**
     * あるブロックの幅が箱の幅を超えていないか、または1未満かどうかを判定する
     * @param blocks ブロックの幅が記入されている配列
     * @param boxWidth 箱の幅
     * @return 
     */
    public static boolean isNotBlocksWidthRange(int[] blocks, int boxWidth){
        for(int i: blocks){
            if(i > boxWidth || i < 1)
                return true;
        }
        return false;
    }
}