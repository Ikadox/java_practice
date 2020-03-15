import java.util.Scanner;

public class YCNo51 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            double remainingWorkload;
            do{
                remainingWorkload = Double.parseDouble(scan.next());
            }while(isNotAllowedRange(remainingWorkload));
            double byTheDeadlineDay;
            do{
                byTheDeadlineDay = Double.parseDouble(scan.next());
            }while(isNotAllowedRange(byTheDeadlineDay));
            System.out.println((long)(calcWorkloadPerDay(remainingWorkload, byTheDeadlineDay)));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 作業量と日数が許容値範囲外がどうか判断する
     * @param value 作業量 or 日数
     * @return 判断結果
     */
    private static boolean isNotAllowedRange(double value){
        if(value < 1.0 || value > Math.pow(10, 5))
            return true;
        return false;
    }
    /**
     * ある1日の作業量を算出する
     * @param workload 残りの作業量
     * @param byTheDeadlineDay 締め切りまでの日数
     * @return ある1日の作業量
     */
    private static double calcWorkloadPerDay(double remainingWorkload, double byTheDeadlineDay){
        double aWorkloadPerDay = Math.floor(remainingWorkload / Math.pow(byTheDeadlineDay, 2));
        if(byTheDeadlineDay > 1.0)
            aWorkloadPerDay = calcWorkloadPerDay(remainingWorkload - aWorkloadPerDay, byTheDeadlineDay-1.0);
        return aWorkloadPerDay;
    }
}