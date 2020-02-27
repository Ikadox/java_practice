import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class YCNo851 {
    public static void main(String[] args){
        int inputCycleNumber;
        try(Scanner scan = new Scanner(System.in)){
            // N:反復回数を入力
            do {
                inputCycleNumber = Integer.parseInt(scan.nextLine());
            }while(isNotInputCycleNumber(inputCycleNumber));

            // 整数を入力
            long[] integers = new long[inputCycleNumber];
            for(int i=0; i<inputCycleNumber; i++){
                do {
                    String input = scan.nextLine();
                    inputFormatChecker(input);
                    integers[i] = Long.parseLong(input);
                }while(isNotIntegerNumberRange(integers[i]));
            }

            // 整数の加算
            Set<Long> addedIntegerSets = new HashSet<>();
            for(int i=0; i<inputCycleNumber-1; i++){
                for(int j=i+1; j<inputCycleNumber; j++){
                    addedIntegerSets.add(Long.valueOf(integers[i] + integers[j]));
                }
            }

            // バブルソートで並び替え
            Long[] addedIntegers = addedIntegerSets.toArray(new Long[addedIntegerSets.size()]);
            for(int i=0; i<addedIntegers.length-1; i++){
                for(int j=i+1; j<addedIntegers.length; j++ ){
                    if(addedIntegers[j] > addedIntegers[i]){
                        long tmp = addedIntegers[i];
                        addedIntegers[i] = addedIntegers[j];
                        addedIntegers[j] = tmp;
                    }
                }
            }
            System.out.println(addedIntegers[1]);
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch(InputFormnatException e){
            System.out.println("assert");
        }
    }
    /**
     * 入力された反復回数の確認
     * @param inputCycleNumber
     * @return
     */
    private static boolean isNotInputCycleNumber(int inputCycleNumber){
        if(3 != inputCycleNumber)
            return true;
        return false;
    }
    /**
     * 入力数値の範囲確認
     * @param integerNumber
     * @return
     */
    private static boolean isNotIntegerNumberRange(long integerNumber){
        if(integerNumber < 1)
            return true;
        if(integerNumber > Math.pow(10, 10))
            return true;
        return false;
    }
    /**
     * 入力文字に空白が含まれていたらエラーを投げる
     * @param input
     * @throws InputFormnatException
     */
    private static void inputFormatChecker(String input) throws InputFormnatException{
        if(input.contains(" "))
            throw new InputFormnatException();
    }
    /**
     * エラー用のクラス
     */
    @SuppressWarnings("serial")
    public static class InputFormnatException extends Exception{
        public InputFormnatException(){

        }
    }
}