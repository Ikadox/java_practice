import java.time.LocalTime;
import java.util.Scanner;

public class YCNo296 {
    public static void main (String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int repeatTimes;
            do{
                repeatTimes = Integer.parseInt(scan.next());
            }while(isNotAllowableTimeRange(repeatTimes));
            int alertHour;
            do{
                alertHour = Integer.parseInt(scan.next());
            }while(isNotAllowableHourRange(alertHour));
            int alertMinute;
            do{
                alertMinute = Integer.parseInt(scan.next());
            }while(isNotAllowableMinuteRange(alertMinute));
            int snoozeMinutes;
            do{
                snoozeMinutes = Integer.parseInt(scan.next());
            }while(isNotAllowableSnoozeMinutesRange(snoozeMinutes));

            LocalTime wakeupTime = LocalTime.of(alertHour, alertMinute);
            for(--repeatTimes; repeatTimes > 0; repeatTimes--){
                wakeupTime  = wakeupTime.plusMinutes(snoozeMinutes);
            }
            System.out.println(wakeupTime.getHour());
            System.out.println(wakeupTime.getMinute());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 繰り返し寝た回数が指定範囲外か判定する
     * @param repeatTimes 繰り返し寝た回数
     * @return 判定結果
     */
    private static boolean isNotAllowableTimeRange(int repeatTimes){
        if(repeatTimes < 1 || repeatTimes > 1000000)
            return true;
        return false;
    }
    /**
     * アラームをセットした時間の時の値が指定範囲外か判定する
     * @param alertHour アラームをかけた時間の時の値
     * @return 判定結果
     */
    private static boolean isNotAllowableHourRange(int alertHour){
        if(alertHour < 0 || alertHour > 24)
            return true;
        return false;
    }
    /**
     * アラームをセットした時間の分の値が指定範囲外か判定する
     * @param alertMinute アラームをかけた時間の分の値
     * @return 判定結果
     */
    private static boolean isNotAllowableMinuteRange(int alertMinute){
        if(alertMinute < 0 || alertMinute > 59)
            return true;
        return false;
    }
    /**
     * 次にアラームが鳴る時間（分単位）が指定範囲外か判定する
     * @param snoozeMinutes 次にアラームがなる時間（分単位）
     * @return 判定結果
     */
    private static boolean isNotAllowableSnoozeMinutesRange(int snoozeMinutes){
        if(snoozeMinutes < 0 || snoozeMinutes > 1440)
            return true;
        return false;
    }
}