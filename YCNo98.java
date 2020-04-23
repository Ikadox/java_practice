import java.util.Scanner;

public class YCNo98 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int xp, yp;
            do{
                xp = Integer.parseInt(scan.next());
            }while(isNotAllowableRange(xp));
            do{
                yp = Integer.parseInt(scan.next());
            }while(isNotAllowableRange(yp));
            System.out.println(calcDiameter(xp, yp));
        }
    }
    /**
     * 整数座標値が指定範囲外か判定する
     * @param point 整数座標
     * @return 判定結果
     */
    private static boolean isNotAllowableRange(int point){
        if(point < -10000 || point > 10000)
            return true;
        return false;
    }
    /**
     * 直径を算出する
     * @param xp Xp座標
     * @param yp Yp座標
     * @return 直径
     */
    private static long calcDiameter(double xp, double yp){
        if(Math.hypot(xp, yp) == Math.round(Math.hypot(xp, yp)))
            return Math.round(Math.hypot(xp, yp)) * 2 + 1;
        return Math.round(Math.hypot(xp, yp)) * 2;
    }
}