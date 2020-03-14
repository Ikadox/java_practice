import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class YCNo22 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int numberOfCharacter;
            int designatedCursor;
            String inputString;
            do{
                numberOfCharacter = Integer.parseInt(scan.next());
                designatedCursor = Integer.parseInt(scan.next());
                inputString = scan.next();
            }while(hasInputError(numberOfCharacter, designatedCursor, inputString));
            ArrayList<Integer> cursorMap = insertIntoCursorMap(new ArrayList<Integer>(inputString.length()), inputString.length());
            Optional<Integer> pairCursor = findPairCursor(designatedCursor, inputString, cursorMap);
            System.out.println(pairCursor.orElseThrow());
        }catch(NoSuchElementException e){
            System.out.println("Syntax error on token \"(\" or \")\" ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 入力値に誤りがあるか確認する
     * 入力値に誤りがあった場合 true を返し、誤りがない場合は false を返す
     * @param numberOfCharacter 文字数
     * @param designatedCursor 指定された文字の番号
     * @param inputString 入力文字
     * @return true or false
     */
    private static boolean hasInputError(int numberOfCharacter, int designatedCursor, String inputString){
        if(numberOfCharacter < 1 || numberOfCharacter > 10000)
            return true;
        if(designatedCursor < 1 || designatedCursor > numberOfCharacter)
            return true;
        if(numberOfCharacter != inputString.length())
            return true;
        if(inputString.matches("[()]+")){
            return false;
        }else{
            return true;
        }
    }
    /**
     * 指定されて文字の番号の括弧に対応する文字の番号を取得する
     * 対応する文字の番号が取得できない場合は null を返す
     * @param designatedCursor 指定された文字の番号
     * @param roundBrackets 丸括弧のみで構成された文字列
     * @param cursorMap 入力された際の文字の位置と配列の添字を紐づけるリスト
     * @return 対応する文字の番号 or null
     */
    private static Optional<Integer> findPairCursor(int designatedCursor, String roundBrackets, ArrayList<Integer> cursorMap){
        Integer PAIR_CURSOR = null;
        StringBuilder sb = new StringBuilder(roundBrackets);

        for(int i = roundBrackets.length()-2; i >= 0; i--){
            if(roundBrackets.charAt(i) == '(' && roundBrackets.charAt(i+1) == ')'){
                if(cursorMap.get(i).intValue() == designatedCursor)
                    PAIR_CURSOR = cursorMap.get(i+1);
                if(cursorMap.get(i+1).intValue() == designatedCursor)
                    PAIR_CURSOR = cursorMap.get(i);
                cursorMap.remove(i+1);
                cursorMap.remove(i);
                roundBrackets = sb.delete(i, i+2).toString();
            }
        }
        return Optional.ofNullable(PAIR_CURSOR);
    }
    /**
     * 入力された際の文字の位置と配列の添字を紐づけるリストを作成する
     * @param cursorMap 入力された際の文字の位置と配列の添字を紐づけるリスト
     * @param initialCapacity 入力された文字列の長さ
     * @return 入力された際の文字の位置と配列の添字が紐づいたリスト
     */
    private static ArrayList<Integer> insertIntoCursorMap(ArrayList<Integer> cursorMap, int initialCapacity){
        for(int i=0; i<initialCapacity; i++){
            cursorMap.add(Integer.valueOf(i+1));
        }
        return cursorMap;
    }
}