import java.util.Scanner;

public class YCNo729 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            String moji = null;
            do{
                moji = scan.nextLine();
            }while(isNotPassCharacter(moji));
            String[] index = null;
            do{
                index = scan.nextLine().split(" ");
            }while(isNotIndexValidation(index, moji));
            System.out.println(swap(moji, Integer.parseInt(index[0]), Integer.parseInt(index[1])));
        }catch(NumberFormatException e){
            System.out.println("インデックスは正の整数値を入力してください");
        }
    }
    /**
     * 文字数確認
     * @param moji
     * @return
     */
    private static boolean isNotMojiNumberRange(String moji){
        if(moji.length()<2 || moji.length()>10)
            return true;
        return false;
    }
    /**
     * 小文字確認
     * @param moji
     * @return
     */
    private static boolean isNotLowerCharacter(String moji){
        if(!moji.matches("^[a-z]+$"))
            return true;
        return false;
    }
    /**
     * 入力文字確認
     * @param moji
     * @return
     */
    private static boolean isNotPassCharacter(String moji){
        if(isNotMojiNumberRange(moji) || isNotLowerCharacter(moji))
            return true;
        return false;
    }
    /**
     * 負の値の確認
     * @param index
     * @return
     */
    private static boolean isMinusNumber(String[] index){
        for(String s: index){
            if(Integer.parseInt(s)<0)
            return true;
        }
        return false;
    }
    /**
     * 長さ確認
     * @param moji
     * @param secondIndex
     * @return
     */
    private static boolean isNotLengthRange(String moji, String secondIndex){
        if( Integer.parseInt(secondIndex) > moji.length()-1)
            return true;
        return false;
    }
    /**
     * インデックス確認
     * @param index
     * @param moji
     * @return
     */
    private static boolean isNotIndexValidation(String[] index, String moji){
        if(isMinusNumber(index) || isNotLengthRange(moji, index[1]))
            return true;
        return false;
    }
    /**
     * 文字変換
     * @param moji
     * @param firstIndex
     * @param secondIndex
     * @return
     */
    private static String swap(String moji,int firstIndex, int secondIndex){
        char[] mojiChar = moji.toCharArray();
        char firstIndexChar = mojiChar[firstIndex];
        char secondIndexChar = mojiChar[secondIndex];
        mojiChar[firstIndex] = secondIndexChar;
        mojiChar[secondIndex] = firstIndexChar;
        return new String(mojiChar);
    }
}