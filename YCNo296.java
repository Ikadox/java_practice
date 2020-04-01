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

    private static boolean isNotAllowableTimeRange(int repeatTimes){
        if(repeatTimes < 1 || repeatTimes > 1000000)
            return true;
        return false;
    }
    private static boolean isNotAllowableHourRange(int alertHour){
        if(alertHour < 0 || alertHour > 24)
            return true;
        return false;
    }
    private static boolean isNotAllowableMinuteRange(int alertMinute){
        if(alertMinute < 0 || alertMinute > 59)
            return true;
        return false;
    }
    private static boolean isNotAllowableSnoozeMinutesRange(int snoozeMinutes){
        if(snoozeMinutes < 0 || snoozeMinutes > 1440)
            return true;
        return false;
    }
}