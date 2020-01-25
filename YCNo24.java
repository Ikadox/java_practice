import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class YCNo24{
    public static void main(final String[] args) {
        try {
            final int turnNumber = createTurnNumber();
            List<String> nonCandidateList = ioNumberList(turnNumber);
            outputAnswer(nonCandidateList);
        } catch (final InputMismatchException e) {
            System.out.println("you must input integer.");
        } catch (final ArrayIndexOutOfBoundsException e) {
            System.out.println("you must input 4 integers");
        }
    }
    /**
     * ターン数の入力を受け付け、登録する
     * 登録される数値：Nの範囲は 2 <= N <= 6 である
     * @return ターン数
     */
    private static int createTurnNumber(){
        int turnNumber = 0;
        Scanner scan = new Scanner(System.in);
        boolean isTurnNumberRange = false;
            while (!isTurnNumberRange) {
                turnNumber = scan.nextInt();
                if (turnNumber >= 2 && turnNumber <= 6) {
                    isTurnNumberRange = true;
                }
            }
        return turnNumber;
    }
    /**
     * NOとなった数値を nonCandidateList に入れて、
     * YESとなった数値はその数値以外を nonCandidateList に入れる
     * @param turnNumber
     * @return 正答以外の候補リスト
     */
    private static List<String> ioNumberList (int turnNumber){
        List<String> nonCandidateList = new ArrayList<>(); 

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < turnNumber; i++) {
            String[] inputNumberArray = scan.nextLine().split(" ");
            
            if(inputNumberArray[(inputNumberArray.length)-1].equals("NO")){
                for(int j=0; j<inputNumberArray.length; j++){
                    nonCandidateList.add(inputNumberArray[j]);
                }
            }else{
                for(int j=0; j<inputNumberArray.length-1; j++){
                    List<String> checkBox = Arrays.asList(inputNumberArray);
                    for(int m=0; m<10; m++){
                        Integer number  = m;
                        if(!checkBox.contains(number.toString())){
                            nonCandidateList.add(number.toString());
                        }
                    }
                }
            }
        }
        return nonCandidateList;
        
    }
    /**
     * nonCandidateList にない数値を探して出力する
     * @param nonCandidateList
     */
    private static void outputAnswer(List<String> nonCandidateList){
        for(int i=0; i<10; i++){
            Integer checkedNumber  = i;
            if(!nonCandidateList.contains(checkedNumber.toString())){
                    System.out.println(i);
                    return;
            }
        }
    }
}