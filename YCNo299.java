import java.util.Scanner;

public class YCNo299 {
    public static void main(String[] args){
        final long SUB = 52;
        final long FIRST_VERSION_PAGE = 316;

        try(Scanner scan = new Scanner(System.in)){
            long version;
            do{
                version = Long.parseLong(scan.next());
            }while(isNotAllowableRange(version));
            System.out.println(FIRST_VERSION_PAGE + SUB * (version - 1));
        }
    }
    /**
     * 版が許容範囲外か判定する
     * @param version 版
     * @return 判定結果
     */
    private static boolean isNotAllowableRange(long version){
        if(version < 1L || version > 10000000000L)
            return true;
        return false;
    }
}