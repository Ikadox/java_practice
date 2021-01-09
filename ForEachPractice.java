import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachPractice {
    public static void main(String[] args){
        //JDK9以降
        //Arrays.asList():配列のラッパで、サイズ固定、要素の変更が可能
        //List.of():要素の変更は不可、immutable
        List<String> sampleList = new ArrayList<String>(List.of("a", "b", "c", "d", "e", "f", "g"));
        outputMethod(sampleList);
        arrayMethod();
    }
    /**
     * 単純な出力
     * @param sampleList
     */
    public static void outputMethod(List<String> sampleList){
        String tmp = "hoge";//ラムダ式の外で宣言した変数はラムダ式内で参照可能だが、変更はできない
        sampleList.forEach(a -> System.out.println(a + tmp));
        // for(String a: sampleList){
        //     System.out.println(a + tmp);
        // }
    }
    /**
     * 配列の場合
     */
    public static void arrayMethod(){
        String[] sampleArray = {"a", "b", "c", "d", "e", "f", "g"};
        //配列の場合、Arrays.stream() メソッドを使って Stream を生成する
        Arrays.stream(sampleArray).forEach(a -> System.out.println(a));

    }
}