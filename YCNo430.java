import java.util.Scanner;
/**
 * 計算量は O(n^2)
 */
public class YCNo430 {
    public static void main(String[] main){
        try(Scanner scan = new Scanner(System.in)){
            String searchedString = scan.next();
            int subStringNumber = Integer.parseInt(scan.next());
            int totalMatchCount = 0;
            for(int i = 0; i < subStringNumber; i++){
                totalMatchCount += subStringMatchCounter(searchedString, scan.next());
            }
            System.out.println(totalMatchCount);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * ある文字列の中に入力した文字列が部分文字列としていくつ含まれているか算出する。
     * @param searchedString ある文字列
     * @param subString 入力した文字列
     * @return 部分文字列として含まれていた数
     */
    private static int subStringMatchCounter(String searchedString, String subString){
        int matchCount = 0;
        for(int i = 0; i + subString.length() <= searchedString.length(); i++){
            if(searchedString.substring(i, i + subString.length()).equals(subString))
                matchCount++;
        }
        return matchCount;
    }
}