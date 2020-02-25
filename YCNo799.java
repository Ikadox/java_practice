import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class YCNo799 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int[] inputNumbers;
            do{
                String[] input = scan.nextLine().split(" ");
                inputNumbers = Stream.of(input).mapToInt(Integer::parseInt).toArray();
            }while(isNotInputRange(inputNumbers) 
                || isNotSizeTerms(inputNumbers[0], inputNumbers[1])
                || isNotSizeTerms(inputNumbers[2], inputNumbers[3])
                );
            int allPatern
                = (inputNumbers[1]-inputNumbers[0]+1) * (inputNumbers[3]-inputNumbers[2]+1);         
            System.out.println( allPatern - calcOverlappingNumber(inputNumbers) );
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    /**
     * 入力数値の範囲確認
     * @param number
     * @return
     */
    private static boolean isNotInputRange(int[] number){
        for(int i=0; i<number.length; i++){
            if(number[i] < 1 || number[i] > 100)
                return true;
        }
        return false;
    }
    /**
     * 大小確認
     * @param min
     * @param max
     * @return
     */
    private static boolean isNotSizeTerms(int min, int max){
        if(min>max)
            return true;
        return false;
    }
    /**
     * 重複する数の算出
     * @param inputNumbers
     * @return
     */
    private static int calcOverlappingNumber(int[] inputNumbers){
        int a = inputNumbers[0];
        int b = inputNumbers[1];
        int c = inputNumbers[2];
        int d = inputNumbers[3];
        if(c > b || a > d){
            return 0;
        }
        List<Integer> redBox = new ArrayList<>();
        while(b >= a){
            redBox.add(a);
            a++;
        }
        int overlappingNumber = 0;
        while(d >= c){
            if(redBox.contains(Integer.valueOf(c)))
            overlappingNumber++;
            c++;
        }
        return overlappingNumber;
    }
}