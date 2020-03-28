import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class YCNo83 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int numberOfMatch;
            do{
                numberOfMatch = Integer.parseInt(scan.next());
            }while(isNotAllowableRange(numberOfMatch));
            System.out.println(buildDisplsayMaxNumber(numberOfMatch));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * マッチ棒の本数が許容範囲外か判定する
     * @param number マッチ棒の本数
     * @return 判定結果
     */
    private static boolean isNotAllowableRange(int number){
        if(number < 2 || number > 100000)
            return true;
        return false;
    }
    /**
     * 与えられたマッチ棒の本数で表現される数値の中で最大の数値を構築する
     * @param number マッチの本数
     * @return 表示できる最大の数値
     */
    private static String buildDisplsayMaxNumber(int number){
        StringBuilder displayNumber = new StringBuilder();
        TreeMap<Integer, List<Integer>> displayCostMap = new TreeMap<>();
        displayCostMap = initMatchNumber(displayCostMap);
        int minCost = displayCostMap.firstKey();
        int higherCost = displayCostMap.higherKey(minCost);
        
        while(minCost <= number){
            if(1 == number % minCost){
                displayNumber.append(displayCostMap.get(higherCost).stream().min(Comparator.naturalOrder()).get());
                number -= higherCost;
            }else{
                displayNumber.append(displayCostMap.get(minCost).stream().min(Comparator.naturalOrder()).get());
                number -= minCost;
            }
        }
        return new String(displayNumber);
    }
    /**
     * コストをKeyとして、そのコストで表示できる数値をValueに設定した TreeMap を生成する
     * @param displayCostMap
     * @return Key:コスト, Value:表示できる数値のCollection で構成されたTreeMap
     */
    private static TreeMap<Integer , List<Integer>> initMatchNumber(TreeMap<Integer, List<Integer>> displayCostMap){
        final Integer[] cost2 = {1};
        final Integer[] cost3 = {7};
        final Integer[] cost4 = {4};
        final Integer[] cost5 = {2, 3, 5};
        final Integer[] cost6 = {0, 6, 9};
        final Integer[] cost7 = {8};
        displayCostMap.putAll(
            Map.of(
                2, List.of(cost2),
                3, List.of(cost3),
                4, List.of(cost4),
                5, List.of(cost5),
                6, List.of(cost6),
                7, List.of(cost7)
                )
        );
        return displayCostMap;
    }
}