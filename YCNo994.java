import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YCNo994 {
    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            int numberOfNodes;
            do{
                numberOfNodes = Integer.parseInt(scan.next());
            }while(isNotAllowableNodeRange(numberOfNodes));

            int numberOfCoins;
            do{
                numberOfCoins = Integer.parseInt(scan.next());
            }while(isNotAllowableCoinsRange(numberOfCoins));

            Map<Integer, ArrayList<Integer>> nodeMap = new HashMap<>();
            for(int i = 0; i < numberOfNodes-1; i++){
                int parentNode = Integer.parseInt(scan.next());
                int childNode = Integer.parseInt(scan.next());
                if(nodeMap.containsKey(parentNode)){
                    nodeMap.get(Integer.valueOf(parentNode)).add(Integer.valueOf(childNode));
                }
                else{
                    nodeMap.put(Integer.valueOf(parentNode), new ArrayList<Integer>());
                    nodeMap.get(Integer.valueOf(parentNode)).add(Integer.valueOf(childNode));
                }
            }
            if(numberOfCoins > numberOfNodes){
                System.out.println(-1);
                return;
            }
            int workingProcess = 0;
            for(ArrayList<Integer> n: nodeMap.values()){
                for(int i = n.size(); i > 0 && numberOfCoins > 1; i--, numberOfCoins--){
                    workingProcess++;
                }
            }
            System.out.println(workingProcess);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 頂点の数が指定範囲外か判定する
     * @param numberOfNode 頂点の数
     * @return 判定結果
     */
    private static boolean isNotAllowableNodeRange(int numberOfNode){
        if(numberOfNode< 2 || numberOfNode > 100000)
            return true;
        return false;
    }
    /**
     * コインの枚数が指定範囲外か判定する
     * @param numberOfCoins コインの枚数
     * @return 判定結果
     */
    private static boolean isNotAllowableCoinsRange(int numberOfCoins){
        if(numberOfCoins < 1 || numberOfCoins > 100000)
            return true;
        return false;
    }
}