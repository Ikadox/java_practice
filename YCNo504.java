import java.util.Scanner;

public class YCNo504 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int players;
            do{
                players = Integer.parseInt(scan.next());
            }while(isNotAllowablePlayerRange(players));
            
            int pointOfK;
            do{
                pointOfK = Integer.parseInt(scan.next());
            }while(isNotAllowablePointRange(pointOfK));

            int currentRank = 1;
            int pointOfOtherPlayer = 0;
            int[] rankLog = new int[players];
            rankLog[0] = currentRank;
            for(int i = 1; i < players; i++){
                do{
                    pointOfOtherPlayer = Integer.parseInt(scan.next());
                }while(isNotAllowablePointRange(pointOfOtherPlayer));
                if(pointOfOtherPlayer > pointOfK)
                    currentRank++;
                rankLog[i] = currentRank;
            }
            for(int n: rankLog)
                System.out.println(n);
        }
    }
    /**
     * 参加プレイヤーの人数が指定範囲外か判定する
     * @param players 参加プレイヤーの人数
     * @return 判定結果
     */
    private static boolean isNotAllowablePlayerRange(int players){
        if(players < 1 || players > 100000)
            return true;
        return false;
    }
    /**
     * 獲得したスコアが指定範囲外か判定する
     * @param point 獲得したスコア
     * @return 判定結果
     */
    private static boolean isNotAllowablePointRange(int point){
        if(point < 1 || point > 1000000000)
            return true;
        return false;
    }
}