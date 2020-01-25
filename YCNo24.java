import java.util.InputMismatchException;
import java.util.Scanner;

public class YCNo24{
    public static void main(final String[] args) {
        final int answer = createAnswer();
        try {
            final int turnNumber = createTurnNumber();
            inputNumberArray(turnNumber, answer);
            System.out.println(answer);
        } catch (final InputMismatchException e) {
            System.out.println("you must input integer.");
        } catch (final ArrayIndexOutOfBoundsException e) {
            System.out.println("you must input 4 integers");
        }
    }
    /**
     * 解答の整数値（ 1<= 値 <=9 ）をランダムで生成する
     * @return 解答の整数値
     */
    private static int createAnswer(){
        int answer = (int)(Math.random() * 10);
        return answer;
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
                System.out.println("turnNumber : 2<n<6");
                System.out.print("turnNumber -> ");
                turnNumber = scan.nextInt();
                if (turnNumber >= 2 && turnNumber <= 6) {
                    isTurnNumberRange = true;
                }
            }
        return turnNumber;
    }
    /**
     * 回答を受け付けて、解答と一致しているかどうかを判定する
     * 判定は1ターンごとに行う
     * @param turnNumber
     * @param answer
     */
    private static void inputNumberArray(int turnNumber, int answer){
        String[] inputNumberArray = new String[4];
        Scanner scan = new Scanner(System.in);
            for (int i = 0; i < turnNumber; i++) {
                boolean isCorrect = false;
                inputNumberArray = scan.nextLine().split(" ");
                check:for (final String s : inputNumberArray) {
                    int inputNumber = Integer.parseInt(s);
                    if (inputNumber == answer) {
                        isCorrect = true;
                        System.out.println("yes");
                        break check;
                    }
                }
                if (!isCorrect) {
                    System.out.println("no");
                }
            }
    }
}