import java.util.Scanner;

public class YCNo172 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int x, y, r;
            do{
                x = Integer.parseInt(scan.next());
            }while(isNotAllowablePointRange(x));
            do{
                y = Integer.parseInt(scan.next());
            }while(isNotAllowablePointRange(y));
            do{
                r = Integer.parseInt(scan.next());
            }while(isNotAllowableRadiusRange(r));
            System.out.println(calcLength(x, y, r));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 円盤型UFOの中心点の座標点が指定範囲外か判断する
     * @param point 座標点
     * @return 判定結果
     */
    private static boolean isNotAllowablePointRange(int point){
        if(point < -100 || point > 100)
            return true;
        return false;
    }
    /**
     * 円盤型UFOの半径が指定範囲外か判定する
     * @param radius UFOの円盤の半径
     * @return 判定結果
     */
    private static boolean isNotAllowableRadiusRange(int radius){
        if(radius < 1 || radius > 100)
            return true;
        return false;
    }
    /**
     * 円盤型UFOを囲えるマンハッタン距離を算出する
     * 円が座標上のどこにいても第1象限上での計算結果が算出される
     * @param x 円盤型UFOの中心点のx座標
     * @param y 円盤型UFOの中心点のy座標
     * @param r 円盤型UFOの半径
     * @return マンハッタン距離
     */
    private static long calcLength(int x, int y, int r){
        //円の中心点を通るx軸と平行な線からπ/4傾いた線が円周上と交わる点を求める
        double aY = (double)r * Math.sin(Math.PI/4) + Math.abs((double)y);
        double aX = (double)r * Math.cos(Math.PI/4) + Math.abs((double)x);
        return (long)calcThrowZeroPointByCircleTangent(aX, Math.abs(x), aY, Math.abs(y), r);
    }
    /**
     * 円の接戦の公式を用いいて、接線がY軸と交わる点を求める
     * 求められた点の小数点は切り上げが行われる
     * @param aX
     * @param x
     * @param aY
     * @param y
     * @param r
     * @return 接線がY軸と交わる点
     */
    private static double calcThrowZeroPointByCircleTangent(double aX, double x, double aY, double y, double r){
        // 円の接線の公式 (x1-α)(x-α) + (y1-ß)(y-ß) = r^2 より
        double throwZeroPointOfY = (Math.pow(r,2) - Math.pow(x,2) - Math.pow(y,2) + aX * x + aY * y )/ (aY - y);
        return Math.ceil(throwZeroPointOfY);
    }
}