import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class YCNo24{
    private static List<String> candidateList = new ArrayList<>();
    public static void main(final String[] args) {
        final int formatMaxNumber = 9;
        final int formatMinNumber = 0;
        formatArray(formatMaxNumber, formatMinNumber) ;

        try(Scanner scan = new Scanner(System.in)) {
            int turnNumber  = 0;
            do{
                turnNumber = Integer.parseInt(scan.nextLine());
            }while(!isTurnNumber(turnNumber));

            for(int i=0; i<turnNumber; i++){
                String[] inputNumberArray = scan.nextLine().split(" ");
                ioNumberList(inputNumberArray);
            }
            candidateList.forEach(a -> System.out.println(a));
            scan.close();
        } catch (final InputMismatchException e) {
            System.out.println("you must input integer.");
        } catch (final ArrayIndexOutOfBoundsException e) {
            System.out.println("you must input 4 integers");
        }
    }

    private static void formatArray(int formatMaxNumber, int formatMinNumber){
        for(; formatMinNumber<=formatMaxNumber; formatMinNumber++){
            candidateList.add(Integer.toString(formatMinNumber));
        }
    }

    /**
     * ターン数の範囲確認
     * 許容される数値の範囲N： 2 <= N <= 6 である
     * @return boolean
     */
    private static boolean isTurnNumber(int turnNumber){
        return (turnNumber >= 2 && turnNumber <= 6)? true : false;
    }
    /**
     * 入力された数値がNoの場合、candidateListから削除する
     * 入力された数値がYesの場合、inputNumberListに含まれていないcandidateListの値を削除する
     * @param inputNumberArray
     */
    private static void ioNumberList (String[] inputNumberArray){
        List<String> inputNumberList = Arrays.asList(inputNumberArray);
        List<String> nonCandidateIndexList = new ArrayList<>();
        if(inputNumberArray[(inputNumberArray.length)-1].equals("NO")){
            inputNumberList.forEach(a -> candidateList.remove(a));
        }else{
            for(String a: candidateList){
                if(!inputNumberList.contains(a))
                    nonCandidateIndexList.add(a);
            }
        }
        nonCandidateIndexList.forEach(a -> candidateList.remove(a));
    }
}