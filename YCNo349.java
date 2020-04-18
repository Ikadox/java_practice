import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class YCNo349 {
    public static void main(String[] args){
        HashMap<String, Integer> etoMap = new HashMap<>();
        etoMap = formatEtoMap(etoMap);

        try(Scanner scan = new Scanner(System.in)){
            int numberOfetoOrnament;
            do{
                numberOfetoOrnament = Integer.parseInt(scan.next());
            }while(isNotAllowableNumberOfOrnamentRange(numberOfetoOrnament));

            String eto;
            for(int i = 0; i<numberOfetoOrnament; i++){
                eto = scan.next();
                if(etoMap.containsKey(eto)){
                    etoMap.put(eto, etoMap.get(eto).intValue()+1);
                }
            }
            int maxNumberOfEtoOrnamae = etoMap.values().stream().max(Comparator.naturalOrder()).get();
            if(numberOfetoOrnament % 2 == 1){
                if(maxNumberOfEtoOrnamae > (numberOfetoOrnament / 2 + 1)){
                    System.out.println("NO");
                    return;
                }
            }else{
                if(maxNumberOfEtoOrnamae > numberOfetoOrnament / 2){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 干支がキーとなったHashMapを生成する。Valueは干支の置物の数
     * @return Keyが干支、ValueがKeyの干支の置物の数であるHashMap
     */
    private static HashMap<String, Integer> formatEtoMap(HashMap<String, Integer> etoMap){
        etoMap.put("ne",0);
        etoMap.put("ushi",0);
        etoMap.put("tora",0);
        etoMap.put("u",0);
        etoMap.put("tatsu",0);
        etoMap.put("mi",0);
        etoMap.put("uma",0);
        etoMap.put("hitsuji",0);
        etoMap.put("saru",0);
        etoMap.put("tori",0);
        etoMap.put("inu",0);
        etoMap.put("i",0);

        return etoMap;
    }
    /**
     * 干支の置物が指定範囲外か判定する
     * @param numberOfetoOrnament 干支の置物の数
     * @return 判定結果
     */
    private static boolean isNotAllowableNumberOfOrnamentRange(int numberOfetoOrnament){
        if(numberOfetoOrnament < 2 || numberOfetoOrnament > 50)
            return true;
        return false;
    }
}