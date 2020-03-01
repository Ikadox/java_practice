import java.util.Scanner;
import java.util.TreeSet;

public class YCNo851 {
    public static void main(String[] args){
        int inputCycleNumber;
        try(Scanner scan = new Scanner(System.in)){
            // N:反復回数を入力
            do {
                inputCycleNumber = Integer.parseInt(scan.nextLine());
            }while(isNotInputCycleNumber(inputCycleNumber));

            // 整数を入力
            long[] longIntegers = new long[inputCycleNumber];
            do{
                for(int i=0; i<inputCycleNumber; i++){
                    do {
                        String input = scan.nextLine();
                        inputFormatChecker(input);
                        longIntegers[i] = Long.parseLong(input);
                    }while(isNotIntegerNumberRange(longIntegers[i]));
                }
            }while(longIntegers[0] == longIntegers[inputCycleNumber-1]);

            // 整数の加算
            TreeSet<Long> addedIntegerSets = new TreeSet<>();
            for(int i=0; i<inputCycleNumber-1; i++){
                for(int j=i+1; j<inputCycleNumber; j++){
                    addedIntegerSets.add(Long.valueOf(longIntegers[i] + longIntegers[j]));
                }
            }
            System.out.println(addedIntegerSets.lower(addedIntegerSets.last()));
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
     * @param longIntegerNumber
     * @return
     */
    private static boolean isNotIntegerNumberRange(long longIntegerNumber){
        if(longIntegerNumber < 1)
            return true;
        if(longIntegerNumber > Math.pow(10, 10))
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